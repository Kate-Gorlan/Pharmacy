package pharmacy.function;

import pharmacy.entity.Entity;

public class Functions {

    private Functions() {
    }

    public static boolean contains(final Entity entity, final Iterable<Entity> list) {
        if (entity != null && list != null) {
            for (Entity e : list) {
                if (e.getId().equals(entity.getId())) {
                    return true;
                }
            }
        }
        return false;
    }

} // class
