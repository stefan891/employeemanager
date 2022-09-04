package it.univr.employeemanager.repo;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
public class EmployeemanagerApplication {

    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = EmployeemanagerApplication.class.getClassLoader();

        //per poter accedere a firebase
        File file = new File(Objects.requireNonNull(classLoader.getResource("employeemanagerKey.json")).getFile());
        FileInputStream serviceAccount = new FileInputStream(file.getAbsolutePath());

        //we ask from service account the options
        //this only need to connect to our database
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://employeemanager-52add-default-rtdb.europe-west1.firebasedatabase.app")
                .build();

        FirebaseApp.initializeApp(options);

        Firestore db = FirestoreClient.getFirestore();


        SpringApplication.run(EmployeemanagerApplication.class, args);
    }

}
