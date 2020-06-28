package pharmacy.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import pharmacy.dao.RequestDao;
import pharmacy.entity.Request;

public class RequestMapper extends SqlSessionDaoSupport implements RequestDao{

    @Override
    public void create(Request obj) {
        getSqlSession().insert("pharmacy.dao.RequestDao.create", obj);
    }

    @Override
    public Request read(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.RequestDao.read", id);
    }

    @Override
    public void update(Request obj) {
        getSqlSession().update("pharmacy.dao.RequestDao.update", obj);
    }

    @Override
    public void delete(Long id) {
        getSqlSession().delete("pharmacy.dao.RequestDao.delete", id);
    }

    @Override
    public List<Request> findAll() {
        return getSqlSession().selectList("pharmacy.dao.RequestDao.findAll");
    }

    @Override
    public List<Request> findAllById(Long id) {
        return getSqlSession().selectList("pharmacy.dao.RequestDao.findAllById", id);
    }

    @Override
    public List<Request> findAllByStatus(String status) {
        return getSqlSession().selectList("pharmacy.dao.RequestDao.findAllByStatus", status);
    }

}
