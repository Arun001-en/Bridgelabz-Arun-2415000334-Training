class Patient {
    // Static variable
    static String hospitalName = "City Care Hospital";
    static int totalPatients = 0;

    // Instance variables
    String name;
    int age;
    String ailment;
    final int patientID;

    // Constructor using 'this'
    Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;  // count patient on creation
    }

    // Static method to get total patients
    static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    // Display patient details
    void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        } else {
            System.out.println("Invalid object.");
        }
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        // Create Patient objects
        Patient p1 = new Patient(101, "Amit Kumar", 30, "Fever");
        Patient p2 = new Patient(102, "Neha Singh", 25, "Fracture");

        // Display patient details
        p1.displayPatientDetails();
        System.out.println("---------------------------");
        p2.displayPatientDetails();

        System.out.println("---------------------------");
        // Display total patients (static method)
        Patient.getTotalPatients();
    }
}
