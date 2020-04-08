package pharmacy.dao;

import java.util.List;
import pharmacy.entity.User;

public interface UserDao extends CrudDao<Long, User>{

    User findUser(Long id);

    List<User> findAll();
}
