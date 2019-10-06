package pharmacy.entity;

import pharmacy.entity.Entity;

public class Position extends Entity {

    private static final long serialVersionUID = 1L;
    
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
