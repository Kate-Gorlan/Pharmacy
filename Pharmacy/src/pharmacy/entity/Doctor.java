package pharmacy.entity;

public class Doctor extends Entity {

    private static final long serialVersionUID = 1L;
    
    private String doctorFullName;

    public String getDoctorFullName() {
        return doctorFullName;
    }

    public void setDoctorFullName(String doctorFullName) {
        this.doctorFullName = doctorFullName;
    }

    
}
