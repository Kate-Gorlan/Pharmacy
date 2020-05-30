package pharmacy.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import pharmacy.common.ListMedicamentType;
import pharmacy.common.MedCriticalNorm;
import pharmacy.common.MedInfoAvailability;
import pharmacy.common.MedTechnology;
import pharmacy.common.MedTechnologyByName;
import pharmacy.common.MedTechnologyByType;
import pharmacy.common.MedicamentInfo;
import pharmacy.common.MedicamentIngredients;
import pharmacy.common.TopMedicament;
import pharmacy.common.TopOverdueMed;
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

    @Override
    public Medicament findByName(String name) {
        return getSqlSession().selectOne("pharmacy.dao.MedicamentDao.findByName", name);
    }

    @Override
    public List<Medicament> findByModOfAppl(String modOfAppl) {
        return getSqlSession().selectList("pharmacy.dao.MedicamentDao.findByModOfAppl", modOfAppl);
    }

    @Override
    public List<Medicament> findByType(String type) {
        return getSqlSession().selectList("pharmacy.dao.MedicamentDao.findByType", type);
    }

    @Override
    public List<Medicament> findByAvailabilityOfPrescription(String availabilityOfPrescription) {
        return getSqlSession().selectList("pharmacy.dao.MedicamentDao.findByAvailabilityOfPrescription", availabilityOfPrescription);
    }

    @Override
    public List<Medicament> findByManufacturability(String manufacturability) {
        return getSqlSession().selectList("pharmacy.dao.MedicamentDao.findByManufacturability", manufacturability);
    }

    @Override
    public List<ListMedicamentType> typeList() {
        return getSqlSession().selectList("pharmacy.dao.MedicamentDao.getAllMedType");
    }

    @Override
    public List<TopOverdueMed> overdueList() {
        return getSqlSession().selectList("pharmacy.dao.MedicamentDao.getTopOverdueMed");
    }

    @Override
    public MedInfoAvailability getMedInfoAvailability(Long idMed) {
        return getSqlSession().selectOne("pharmacy.dao.MedicamentDao.getMedInfoAvailability", idMed);
    }

    @Override
    public Integer getQuantityMedPending(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.MedicamentDao.getQuantityMedPending", id);
    }
} 
