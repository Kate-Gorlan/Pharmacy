package pharmacy.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import pharmacy.dao.IngredientDao;
import pharmacy.entity.Ingredient;

public class IngredientMapper extends SqlSessionDaoSupport implements IngredientDao{

    @Override
    public void create(Ingredient obj) {
        getSqlSession().insert("pharmacy.dao.IngredientDao.create", obj);
    }

    @Override
    public Ingredient read(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.IngredientDao.read", id);
    }

    @Override
    public void update(Ingredient obj) {
        getSqlSession().update("pharmacy.dao.IngredientDao.update", obj);
    }

    @Override
    public void delete(Long id) {
        getSqlSession().delete("pharmacy.dao.IngredientDao.delete", id);
    }

    @Override
    public Ingredient findIngredient(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.IngredientDao.findById", id);
    }

    @Override
    public List<Ingredient> findAll() {
        return getSqlSession().selectList("pharmacy.dao.IngredientDao.findAll");
    }

    @Override
    public void add(Ingredient obj) {
        if (obj.getId() == null) {
            this.create(obj);
        } else {
            this.update(obj);
        }
    }
} 
