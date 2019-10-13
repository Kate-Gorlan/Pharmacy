package pharmacy.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import pharmacy.dao.ClientDao;
import pharmacy.entity.Client;

public class ClientMapper extends SqlSessionDaoSupport implements ClientDao{

    @Override
    public void create(Client obj) {
        getSqlSession().insert("pharmacy.dao.ClientDao.create", obj);
    }

    @Override
    public Client read(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.ClientDao.read", id);
    }

    @Override
    public void update(Client obj) {
        getSqlSession().update("pharmacy.dao.ClientDao.update", obj);
    }

    @Override
    public void delete(Long id) {
        getSqlSession().delete("pharmacy.dao.ClientDao.delete", id);
    }

    @Override
    public Client findClient(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.ClientDao.findById", id);
    }

    @Override
    public List<Client> findAll() {
        return getSqlSession().selectList("pharmacy.dao.ClientDao.findAll");
    }

}
