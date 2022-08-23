package it.univr.employeemanager.model;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class EmployeeService {

    //crud functionality
    public String createEmployee(Employee employee) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("employee").document(String.valueOf(employee.getDocumentId())).set(employee);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public Employee getEmployee(String documentId) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("employee").document(documentId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Employee employee;
        if (document.exists()) {
            employee = document.toObject(Employee.class);
            return employee;
        }
        return null;
    }

    public String updateEmployee(Employee employee) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("employee").document(employee.getName()).set(employee);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteEmployee(String documentId) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("employee").document(documentId).delete();
        return "Successfully deleted " + documentId;
    }
}
