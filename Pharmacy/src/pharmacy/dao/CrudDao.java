package pharmacy.dao;

public interface CrudDao<ID, T> extends Dao<T> {
    void create(T o);

    T read(ID id);

    void update(T o);

    void delete(ID id);
}
