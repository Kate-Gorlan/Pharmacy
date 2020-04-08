package pharmacy.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import pharmacy.dao.UserDao;
import pharmacy.entity.User;

public class UserMapper extends SqlSessionDaoSupport implements UserDao{

    @Override
    public void create(User obj) {
        getSqlSession().insert("pharmacy.dao.UserDao.create", obj);
    }

    @Override
    public User read(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.UserDao.read", id);
    }

    @Override
    public void update(User obj) {
        getSqlSession().update("pharmacy.dao.UserDao.update", obj);
    }

    @Override
    public void delete(Long id) {
        getSqlSession().delete("pharmacy.dao.UserDao.delete", id);
    }

    @Override
    public User findUser(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.UserDao.findUser", id);
    }

    @Override
    public List<User> findAll() {
        return getSqlSession().selectList("pharmacy.dao.UserDao.findAll");
    }

}
