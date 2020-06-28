package pharmacy.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import pharmacy.dao.PrescriptionDao;
import pharmacy.entity.Prescription;

public class PrescriptionMapper extends SqlSessionDaoSupport implements PrescriptionDao{

    @Override
    public void create(Prescription obj) {
        getSqlSession().insert("pharmacy.dao.PrescriptionDao.create", obj);
    }

    @Override
    public Prescription read(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.PrescriptionDao.read", id);
    }

    @Override
    public void update(Prescription obj) {
        getSqlSession().update("pharmacy.dao.PrescriptionDao.update", obj);
    }

    @Override
    public void delete(Long id) {
        getSqlSession().delete("pharmacy.dao.PrescriptionDao.delete", id);
    }

    @Override
    public Prescription findPrescription(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.PrescriptionDao.findById", id);
    }

    @Override
    public List<Prescription> findAll() {
        return getSqlSession().selectList("pharmacy.dao.PrescriptionDao.findAll");
    }

    @Override
    public List<Prescription> findNew() {
        return getSqlSession().selectList("pharmacy.dao.PrescriptionDao.findNew");
    }
} 