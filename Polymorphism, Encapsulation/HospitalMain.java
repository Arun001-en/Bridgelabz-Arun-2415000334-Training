abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    public String getPatientId(){ return patientId; }
    public void setPatientId(String id){ this.patientId = id; }
    public String getName(){ return name; }
    public void setName(String n){ this.name = n; }
    public int getAge(){ return age; }
    public void setAge(int a){ this.age = a; }
    public String getPatientDetails(){ return patientId+" "+name+" "+age; }
    public abstract double calculateBill();
}
interface MedicalRecord {
    void addRecord(String rec);
    String viewRecords();
}
class InPatient extends Patient implements MedicalRecord {
    private double days;
    private StringBuilder sb = new StringBuilder();
    public void setDays(double d){ this.days = d; }
    @Override
    public double calculateBill(){ return days * 2000; }
    @Override
    public void addRecord(String rec){ sb.append(rec).append(";"); }
    @Override
    public String viewRecords(){ return sb.toString(); }
}
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee = 500;
    private StringBuilder sb = new StringBuilder();
    @Override
    public double calculateBill(){ return consultationFee; }
    @Override
    public void addRecord(String rec){ sb.append(rec).append(";"); }
    @Override
    public String viewRecords(){ return sb.toString(); }
}
public class HospitalMain {
    public static void main(String[] args){
        Patient[] p = new Patient[2];
        InPatient ip = new InPatient(); ip.setPatientId("P1"); ip.setName("K"); ip.setAge(40); ip.setDays(3);
        OutPatient op = new OutPatient(); op.setPatientId("P2"); op.setName("L"); op.setAge(25);
        p[0]=ip; p[1]=op;
        for(Patient x: p) System.out.println(x.getPatientDetails()+" Bill: "+x.calculateBill());
        ip.addRecord("Surgery"); op.addRecord("Consultation");
        System.out.println(((InPatient)ip).viewRecords()+" "+((OutPatient)op).viewRecords());
    }
}
