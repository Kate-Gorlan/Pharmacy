package pharmacy.service;

import java.util.Collections;
import java.util.List;

import pharmacy.dao.UserDao;
import pharmacy.entity.User;

public class UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(User obj) {
        if (obj.getId() == null) {
            userDao.create(obj);
        } else {
            userDao.update(obj);
        }
    }

    public User getClientById(Long id) {
        return userDao.read(id);
    }
    
    public List<User> getUsers(){
        List<User> reverseUsers = userDao.findAll();
        Collections.reverse(reverseUsers);
        return reverseUsers;
    }
    
    public void deleteById(Long id) {
        userDao.delete(id);
    }
}
