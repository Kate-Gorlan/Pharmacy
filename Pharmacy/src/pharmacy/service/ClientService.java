package pharmacy.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import pharmacy.dao.ClientDao;
import pharmacy.entity.Client;

public class ClientService {

    private ClientDao clientDao;

    public ClientDao getClientDao() {
        return clientDao;
    }

    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }
    
    public void add(Client obj) {
        if (obj.getId() == null) {
            clientDao.create(obj);
        } else {
            clientDao.update(obj);
        }
    }
    
    
    public ArrayList<String> check(Client client) {
        ArrayList<String> errors = new ArrayList<String>();
        if (client.getFullName().length()>80) {
            errors.add("Длинна ФИО превышает 80 символов");
        }
        if (client.getAge()>100 || client.getAge()<6) {
            errors.add("Возраст должен быть в пределах 6-100");
        }
        if (client.getAddress().length()>80) {
            errors.add("Длинна адреса превышает 80 символов");
        }
        if (client.getPhone().length()!=9) {
            errors.add("Длинна номера телефона должна быть 9 символов");
        }
        if (!client.getPhone().matches("^[0-9]+$")) {
            errors.add("Номер телефона должен содержать только символы");
        }

        return errors;
    }
    
    public Client getClientById(Long id) {
        return clientDao.read(id);
    }
    
    public List<Client> getClients(){
        List<Client> reverseClient = clientDao.findAll();
        Collections.reverse(reverseClient);
        return reverseClient;
    }
    
    public void deleteById(Long id) {
        clientDao.delete(id);
    }
    
    public void decoding(Client client) throws UnsupportedEncodingException {
        String name = new String(client.getFullName().getBytes("iso-8859-1"), "utf-8");
        client.setFullName(name);
        String address = new String(client.getAddress().getBytes("iso-8859-1"), "utf-8");
        client.setAddress(address);
    }
}
