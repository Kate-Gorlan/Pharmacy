package pharmacy.dao;

import java.util.List;

import pharmacy.entity.Client;

public interface ClientDao extends CrudDao<Long, Client>{

    Client findClient(Long id);
    
    List<Client> findAll();
}
