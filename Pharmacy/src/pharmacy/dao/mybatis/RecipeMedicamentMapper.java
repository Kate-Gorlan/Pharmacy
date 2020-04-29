package pharmacy.dao.mybatis;

import java.math.BigDecimal;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import pharmacy.dao.RecipeMedicamentDao;
import pharmacy.entity.RecipeMedicament;

public class RecipeMedicamentMapper extends SqlSessionDaoSupport implements RecipeMedicamentDao{

    @Override
    public void create(RecipeMedicament obj) {
        getSqlSession().insert("pharmacy.dao.RecipeMedicamentDao.create", obj);
    }

    @Override
    public RecipeMedicament read(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.RecipeMedicamentDao.read", id);
    }

    @Override
    public void update(RecipeMedicament obj) {
        getSqlSession().update("pharmacy.dao.RecipeMedicamentDao.update", obj);
    }

    @Override
    public void delete(Long id) {
        getSqlSession().delete("pharmacy.dao.RecipeMedicamentDao.delete", id);
    }

    @Override
    public RecipeMedicament findRecipeMedicament(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.RecipeMedicamentDao.findById", id);
    }

    @Override
    public List<RecipeMedicament> findAll() {
        return getSqlSession().selectList("pharmacy.dao.RecipeMedicamentDao.findAll");
    }

    @Override
    public BigDecimal getPrice(String name) {
        return getSqlSession().selectOne("pharmacy.dao.RecipeMedicamentDao.getPrice", name);
    }

    @Override
    public RecipeMedicament findByMedName(String name) {
        return getSqlSession().selectOne("pharmacy.dao.RecipeMedicamentDao.findByName", name);
    }
} 
