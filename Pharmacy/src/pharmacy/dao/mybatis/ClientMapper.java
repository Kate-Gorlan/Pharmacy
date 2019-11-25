package pharmacy.dao.mybatis;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import pharmacy.dao.ClientDao;
import pharmacy.entity.Client;
import pharmacy.common.ClientMed;
import pharmacy.common.ClientNotTakenOrder;
import pharmacy.common.ClientsPendingOrder;

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

    @Override
    public List<ClientNotTakenOrder> getNotTakeOrderClient() {
        return getSqlSession().selectList("pharmacy.dao.ClientDao.GetNotTakeOrderClient");
    }

    @Override
    public int getNumberOfNotTakeOrderClient() {
        return getSqlSession().selectOne("pharmacy.dao.ClientDao.GetNumberOfNotTakeOrderClient");
    }

    @Override
    public List<ClientsPendingOrder> getClientsPendingOrder() {
        return getSqlSession().selectList("pharmacy.dao.ClientDao.GetClientsPendingOrder");
    }

    @Override
    public List<ClientsPendingOrder> getCPOMedicament(String name) {
        return getSqlSession().selectList("pharmacy.dao.ClientDao.GetCPOMedicament", name);
    }

    @Override
    public int getNCPOMedicament(String name) {
        return getSqlSession().selectOne("pharmacy.dao.ClientDao.GetNCPOMedicament", name);
    }

    @Override
    public int getNumberOfClientsPendingOrder() {
        return getSqlSession().selectOne("pharmacy.dao.ClientDao.GetNumberOfClientsPendingOrder");
    }

    @Override
    public List<ClientMed> getClientMedPeriod(HashMap<String, Object> values) {
        return getSqlSession().selectList("pharmacy.dao.ClientDao.GetClientMedPeriod", values);
    }

    @Override
    public List<ClientMed> getClientMedTypePeriod(HashMap<String, Object> values) {
        return getSqlSession().selectList("pharmacy.dao.ClientDao.GetClientMedTypePeriod", values);
    }

    @Override
    public int getNumberOfClientMedTypePeriod(HashMap<String, Object> values) {
        return getSqlSession().selectOne("pharmacy.dao.ClientDao.GetNumberOfClientMedTypePeriod", values);
    }

    @Override
    public int getNumberOfClientMedPeriod(HashMap<String, Object> values) {
        return getSqlSession().selectOne("pharmacy.dao.ClientDao.GetNumberOfClientMedPeriod", values);
    }
}
