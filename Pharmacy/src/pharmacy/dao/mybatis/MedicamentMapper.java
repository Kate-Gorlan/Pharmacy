package pharmacy.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import pharmacy.common.MedCriticalNorm;
import pharmacy.common.MedTechnology;
import pharmacy.common.MedTechnologyByName;
import pharmacy.common.MedTechnologyByType;
import pharmacy.common.MedicamentInfo;
import pharmacy.common.MedicamentIngredients;
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

    @Override
    public List<MedCriticalNorm> getMinMedInStockByType(String type) {
        return getSqlSession().selectList("pharmacy.dao.MedicamentDao.GetMinMedInStockByType", type);
    }

    @Override
    public List<MedCriticalNorm> getMinMedInStock() {
        return getSqlSession().selectList("pharmacy.dao.MedicamentDao.GetMinMedInStock");
    }

    @Override
    public List<MedTechnology> getTechnologyOrderInProduction() {
        return getSqlSession().selectList("pharmacy.dao.MedicamentDao.GetTechnologyOrderInProduction");
    }

    @Override
    public List<MedTechnologyByName> getTechnologyByName(String name) {
        return getSqlSession().selectList("pharmacy.dao.MedicamentDao.GetTechnologyByName", name);
    }

    @Override
    public List<MedTechnologyByType> getTechnologyByType(String type) {
        return getSqlSession().selectList("pharmacy.dao.MedicamentDao.GetTechnologyByType", type);
    }

    @Override
    public List<MedicamentInfo> getInfoMedicamentByName(String name) {
        return getSqlSession().selectList("pharmacy.dao.MedicamentDao.GetInfoMedicamentByName", name);
    }

    @Override
    public List<MedicamentIngredients> getIngredients(String name) {
        return getSqlSession().selectList("pharmacy.dao.MedicamentDao.GetIngredients", name);
    }
} 
