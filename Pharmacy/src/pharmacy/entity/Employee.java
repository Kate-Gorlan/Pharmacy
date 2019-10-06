package pharmacy.entity;

public class Employee extends Entity {

    private static final long serialVersionUID = 1L;
    
    private Position position;
    
    private String fullName;
    
    private String password;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
