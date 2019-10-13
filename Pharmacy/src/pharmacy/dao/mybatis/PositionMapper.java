package pharmacy.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import pharmacy.dao.PositionDao;
import pharmacy.entity.Position;

public class PositionMapper extends SqlSessionDaoSupport implements PositionDao{

    @Override
    public void create(Position obj) {
        getSqlSession().insert("pharmacy.dao.PositionDao.create", obj);
    }

    @Override
    public Position read(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.PositionDao.read", id);
    }

    @Override
    public void update(Position obj) {
        getSqlSession().update("pharmacy.dao.PositionDao.update", obj);
    }

    @Override
    public void delete(Long id) {
        getSqlSession().delete("pharmacy.dao.PositionDao.delete", id);
    }

    @Override
    public Position findPosition(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.PositionDao.findById", id);
    }

    @Override
    public List<Position> findAll() {
        return getSqlSession().selectList("pharmacy.dao.PositionDao.findAll");
    }

}
