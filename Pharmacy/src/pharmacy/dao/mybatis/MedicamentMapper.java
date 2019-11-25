package pharmacy.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import pharmacy.common.MedCriticalNorm;
import pharmacy.common.TopMedicament;
import pharmacy.dao.MedicamentDao;
import pharmacy.entity.Medicament;

public class MedicamentMapper extends SqlSessionDaoSupport implements MedicamentDao{

    @Override
    public void create(Medicament obj) {
        getSqlSession().insert("pharmacy.dao.MedicamentDao.create", obj);
    }

    @Override
    public Medicament read(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.MedicamentDao.read", id);
    }

    @Override
    public void update(Medicament obj) {
        getSqlSession().update("pharmacy.dao.MedicamentDao.update", obj);
    }

    @Override
    public void delete(Long id) {
        getSqlSession().delete("pharmacy.dao.MedicamentDao.delete", id);
    }

    @Override
    public Medicament findMedicament(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.MedicamentDao.findById", id);
    }

    @Override
    public List<Medicament> findAll() {
        return getSqlSession().selectList("pharmacy.dao.MedicamentDao.findAll");
    }

    @Override
    public List<TopMedicament> getTopMedicament() {
        return getSqlSession().selectList("pharmacy.dao.MedicamentDao.GetTopMedicament");
    }

    @Override
    public List<TopMedicament> getTopMedicamentType(String type) {
        return getSqlSession().selectList("pharmacy.dao.MedicamentDao.GetTopMedicamentType", type);
    }

    @Override
    public List<Medicament> getMedOver() {
        return getSqlSession().selectList("pharmacy.dao.MedicamentDao.GetMedOver");
    }

    @Override
    public List<MedCriticalNorm> getReachedCriticalNorm() {
        return getSqlSession().selectList("pharmacy.dao.MedicamentDao.GetReachedCriticalNorm");
    }
} 
