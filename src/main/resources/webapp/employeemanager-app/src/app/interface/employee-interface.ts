export interface EmployeeInterface {
  employeeID: Number;
  name: String;
  surname: String;
  phoneNumber: String;
  birthplace: String;
  birthDate: String;
  nationality: String;
  address: String;
  email: String;
  workExperience: String;
  workInterval: {
    from: String;
    to: String;
  };
  languages: String[];
  hasLicense: Boolean;
  hasCar: Boolean;
  workZone?: String;
  emergencyName?: String ;
  emergencySurname?: String;
  emergencyPhone?: String;
  emergencyEmail?: String;
}
