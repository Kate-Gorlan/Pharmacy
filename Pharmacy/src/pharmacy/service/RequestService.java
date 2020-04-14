package pharmacy.service;

import java.util.Collections;
import java.util.List;

import pharmacy.dao.RequestDao;
import pharmacy.entity.OrderMedicament;
import pharmacy.entity.Request;

public class RequestService {

    private RequestDao requestDao;

    public RequestDao getRequestDao() {
        return requestDao;
    }

    public void setRequestDao(RequestDao requestDao) {
        this.requestDao = requestDao;
    }

    public void add(Request obj) {
        if (obj.getId() == null) {
            requestDao.create(obj);
        } else {
            requestDao.update(obj);
        }
    }
    
    public Request getById(Long id) {
        return requestDao.read(id);
    }
    
    public List<Request> getAll(){
        List<Request> req = requestDao.findAll();
        return req;
    }
    
    public void deleteById(Long id) {
        requestDao.delete(id);
    }
}
