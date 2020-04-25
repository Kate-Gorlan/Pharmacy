package pharmacy.entity;

public class Role extends Entity {

private static final long serialVersionUID = 1L;
    
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role [id=" + getId() + ", name=`" + roleName + "']";
    }
}
