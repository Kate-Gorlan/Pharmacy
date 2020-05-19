package pharmacy.service;

import java.util.Collections;
import java.util.List;

import pharmacy.dao.RoleDao;
import pharmacy.dao.UserDao;
import pharmacy.entity.Role;
import pharmacy.entity.User;
import pharmacy.util.BCrypt;

public class UserService {

    private UserDao userDao;

    private RoleDao roleDao;

    public RoleDao getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(User obj) {
        String pass = obj.getPassword();
        if (obj.getId() == null) {
            obj.setPassword(BCrypt.bcrypt(pass));
            userDao.create(obj);
        } else {
            obj.setPassword(BCrypt.bcrypt(pass));
            userDao.update(obj);
        }
    }

    public User getClientById(Long id) {
        return userDao.read(id);
    }

    public List<User> getUsers() {
        List<User> reverseUsers = userDao.findAll();
        Collections.reverse(reverseUsers);
        return reverseUsers;
    }

    public void deleteById(Long id) {
        userDao.delete(id);
    }

    public User getUserByLogin(String login) {
        return userDao.findUser(login);
    }
    
    public List<Role> getRoles() {
        return roleDao.findAll();
    }
    
    public void saveUser(User user, Long[] rid) {
        add(user);

        roleDao.deleteUsersRoles(user.getId());

        if (rid != null) {
            for (Long id : rid) {
                roleDao.addUsersRoles(user.getId(), id);
            }
        }
    }
}
