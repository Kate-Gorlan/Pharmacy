package pharmacy.dao;

import java.util.List;
import pharmacy.entity.User;

public interface UserDao extends CrudDao<Long, User>{

    User findUser(String login);

    List<User> findAll();

    List<User> findAllByMask(String mask);
}
