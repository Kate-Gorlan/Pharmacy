package pharmacy.service;

import java.util.Collections;
import java.util.List;

import pharmacy.dao.RecipeMedicamentDao;
import pharmacy.entity.RecipeMedicament;

public class RecipeMedicamentService {

    private RecipeMedicamentDao recipeMedicamentDao;

    public RecipeMedicamentDao getRecipeMedicamentDao() {
        return recipeMedicamentDao;
    }

    public void setRecipeMedicamentDao(RecipeMedicamentDao recipeMedicamentDao) {
        this.recipeMedicamentDao = recipeMedicamentDao;
    }
    
    public void add(RecipeMedicament obj) {
        if (obj.getId() == null) {
            recipeMedicamentDao.create(obj);
        } else {
            recipeMedicamentDao.update(obj);
        }
    }
    
    public RecipeMedicament getById(Long id) {
        return recipeMedicamentDao.read(id);
    }
    
    public List<RecipeMedicament> getAll(){
        List<RecipeMedicament> reverse = recipeMedicamentDao.findAll();
        Collections.reverse(reverse);
        return reverse;
    }
    
    public void deleteById(Long id) {
        recipeMedicamentDao.delete(id);
    }

}
