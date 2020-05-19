package pharmacy.entity;

public class Employee extends Entity {

    private static final long serialVersionUID = 1L;
    
    private Position position;
    
    private String fullName;
    
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
