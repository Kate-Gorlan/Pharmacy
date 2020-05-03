package pharmacy.dao;

import java.util.HashMap;
import java.util.List;

import pharmacy.entity.Client;
import pharmacy.common.ClientMed;
import pharmacy.common.ClientNotTakenOrder;
import pharmacy.common.ClientsPendingOrder;
import pharmacy.common.TopClientsMed;

public interface ClientDao extends CrudDao<Long, Client>{

    void createNotUser(Client obj);
    
    Client findClient(Long id);
    
    List<Client> findAll();
    
    List<ClientNotTakenOrder> getNotTakeOrderClient();
    
    int getNumberOfNotTakeOrderClient();
    
    List<ClientsPendingOrder> getClientsPendingOrder();
    
    List<ClientsPendingOrder> getCPOMedicament(String name);
    
    int getNCPOMedicament(String name);
    
    int getNumberOfClientsPendingOrder();
    
    List<ClientMed> getClientMedPeriod(HashMap<String, Object> values);
    
    List<ClientMed> getClientMedTypePeriod(HashMap<String, Object> values);
    
    int getNumberOfClientMedTypePeriod(HashMap<String, Object> values);
    
    int getNumberOfClientMedPeriod(HashMap<String, Object> values);
    
    List<TopClientsMed> getClientsMedByName(String name);
    
    List<TopClientsMed> getClientsMedByType(String type);
}
