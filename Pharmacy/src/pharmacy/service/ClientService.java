package pharmacy.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import pharmacy.common.ClientMed;
import pharmacy.common.ClientNotTakenOrder;
import pharmacy.common.ClientsPendingOrder;
import pharmacy.common.TopClientsMed;
import pharmacy.dao.ClientDao;
import pharmacy.entity.Client;
import pharmacy.mvc.formvalidation.FormClient;

public class ClientService {

    private final Long[] ROLE_USER_ID = { 2L };

    private ClientDao clientDao;

    public ClientDao getClientDao() {
        return clientDao;
    }

    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public void add(Client obj) {
        if (obj.getId() == null) {
            if (obj.getUser() == null) {
            clientDao.createNotUser(obj);
            } else {
            clientDao.create(obj);
            }
        } else {
            if (obj.getUser() == null) {
                clientDao.updateNotUser(obj);
                } else {
                clientDao.update(obj);
                }
        }
    }

    public ArrayList<String> check(Client client) {
        ArrayList<String> errors = new ArrayList<String>();
        if (client.getFullName().length() > 80) {
            errors.add("Длина ФИО не может быть больше 80 символов");
        }
        if (client.getAge() > 100 || client.getAge() < 6) {
            errors.add("Возраст должен быть в рамках 6-100");
        }
        if (client.getAddress().length() > 80) {
            errors.add("Длина адреса не может быть больше 80 символов");
        }
        if (client.getPhone().length() != 9) {
            errors.add("Длина телефона должна быть 9 символов");
        }
        if (!client.getPhone().matches("^[0-9]+$")) {
            errors.add("Номер телефона должен состоять из цифр");
        }

        return errors;
    }

    public Client getClientById(Long id) {
        return clientDao.read(id);
    }

    public List<Client> getClients() {
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

    public List<ClientNotTakenOrder> getNotTakeOrderClient() {
        return clientDao.getNotTakeOrderClient();
    }

    public int getNumberOfNotTakeOrderClient() {
        return clientDao.getNumberOfNotTakeOrderClient();
    }

    public List<ClientsPendingOrder> getClientsPendingOrder() {
        return clientDao.getClientsPendingOrder();
    }

    public List<ClientsPendingOrder> getCPOMedicament(String name) {
        return clientDao.getCPOMedicament(name);
    }

    public int getNCPOMedicament(String name) {
        return clientDao.getNCPOMedicament(name);
    }

    public int getNumberOfClientsPendingOrder() {
        return clientDao.getNumberOfClientsPendingOrder();
    }

    public List<ClientMed> getClientMedPeriod(HashMap<String, Object> values) {
        return clientDao.getClientMedPeriod(values);
    }

    public List<ClientMed> getClientMedTypePeriod(HashMap<String, Object> values) {
        return clientDao.getClientMedTypePeriod(values);
    }

    public int getNumberOfClientMedTypePeriod(HashMap<String, Object> values) {
        return clientDao.getNumberOfClientMedTypePeriod(values);
    }

    public int getNumberOfClientMedPeriod(HashMap<String, Object> values) {
        return clientDao.getNumberOfClientMedPeriod(values);
    }

    public List<TopClientsMed> getClientsMedByName(String name) {
        return clientDao.getClientsMedByName(name);
    }

    public List<TopClientsMed> getClientsMedByType(String type) {
        return clientDao.getClientsMedByType(type);
    }

    public void saveCient(UserService us, FormClient fc) {
        us.saveUser(fc.getUser(), ROLE_USER_ID);
        Client client = fc.getClient();
        client.setUser(fc.getUser());
        add(client);
    }

    public Client getClientByUserId(Long id) {
        return clientDao.getClientByUserId(id);
    }
}
