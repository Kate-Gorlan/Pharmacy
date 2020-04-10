package pharmacy.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import pharmacy.dao.MedicamentStockDao;
import pharmacy.entity.MedicamentStock;

public class MedicamentStockMapper extends SqlSessionDaoSupport implements MedicamentStockDao{

    @Override
    public void create(MedicamentStock obj) {
        getSqlSession().insert("pharmacy.dao.MedicamentStockDao.create", obj);
    }

    @Override
    public MedicamentStock read(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.MedicamentStockDao.read", id);
    }

    @Override
    public void update(MedicamentStock obj) {
        getSqlSession().update("pharmacy.dao.MedicamentStockDao.update", obj);
    }

    @Override
    public void delete(Long id) {
        getSqlSession().delete("pharmacy.dao.MedicamentStockDao.delete", id);
    }

    @Override
    public MedicamentStock findMedicamentStock(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.MedicamentStockDao.findById", id);
    }

    @Override
    public List<MedicamentStock> findAll() {
        return getSqlSession().selectList("pharmacy.dao.MedicamentStockDao.findAll");
    }

    @Override
    public List<MedicamentStock> GetMedicamentThatHaveExpired() {
        return getSqlSession().selectList("pharmacy.dao.MedicamentStockDao.GetMedicamentThatHaveExpired");
    }

    @Override
    public List<MedicamentStock> GetMedicamentThatWillSoonExpire() {
        return getSqlSession().selectList("pharmacy.dao.MedicamentStockDao.GetMedicamentThatWillSoonExpire");
    }
} 
