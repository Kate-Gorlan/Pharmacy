package pharmacy.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import pharmacy.dao.DoctorDao;
import pharmacy.entity.Doctor;

public class DoctorMapper extends SqlSessionDaoSupport implements DoctorDao{

    @Override
    public void create(Doctor obj) {
        getSqlSession().insert("pharmacy.dao.DoctorDao.create", obj);
    }

    @Override
    public Doctor read(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.DoctorDao.read", id);
    }

    @Override
    public void update(Doctor obj) {
        getSqlSession().update("pharmacy.dao.DoctorDao.update", obj);
    }

    @Override
    public void delete(Long id) {
        getSqlSession().delete("pharmacy.dao.DoctorDao.delete", id);
    }

    @Override
    public Doctor findDoctor(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.DoctorDao.findById", id);
    }

    @Override
    public List<Doctor> findAll() {
        return getSqlSession().selectList("pharmacy.dao.DoctorDao.findAll");
    }
}
