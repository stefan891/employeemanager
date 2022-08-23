package it.univr.employeemanager.model;

import com.github.fabiomaffioletti.firebase.document.FirebaseDocument;
import com.github.fabiomaffioletti.firebase.document.FirebaseId;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@FirebaseDocument("/employee")
public class Employee{
    @FirebaseId
    private String documentId;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String profession;
    private String employeeCode;

}
