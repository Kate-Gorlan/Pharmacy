package pharmacy.service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pharmacy.dao.IngredientDao;
import pharmacy.dao.MedicamentDao;
import pharmacy.dao.RecipeMedicamentDao;
import pharmacy.entity.Medicament;
import pharmacy.entity.RecipeMedicament;

public class RecipeMedicamentService {

    private MedicamentDao medicamentDao;
    
    private IngredientDao ingredientDao;

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
    
    public void decoding(RecipeMedicament obj) throws UnsupportedEncodingException {
        String technology = new String(obj.getTechnology().getBytes("iso-8859-1"), "utf-8");
        obj.setTechnology(technology);
    }

    public ArrayList<String> check(RecipeMedicament recipe) throws UnsupportedEncodingException {
        this.decoding(recipe);
        ArrayList<String> errors = new ArrayList<String>();
        Long id = recipe.getMedicament().getId();
        Medicament med = medicamentDao.read(id);
        if (med == null) {
            errors.add("Запись о медикаменте не найдена");
        }
        if (recipe.getQuantity() <= 0) {
            errors.add("Количество медикамента не может быть нулем или меньше нуля");
        }
        if (recipe.getSettlingTime() <= 0) {
            errors.add("Время изготовления не может быть нулем или меньше нуля");
        }

        return errors;
    }

    public RecipeMedicament getById(Long id) {
        return recipeMedicamentDao.read(id);
    }
    
    public RecipeMedicament getByName(String name) {
        return recipeMedicamentDao.findByMedName(name);
    }

    public List<RecipeMedicament> getAll() {
        List<RecipeMedicament> reverse = recipeMedicamentDao.findAll();
        Collections.reverse(reverse);
        return reverse;
    }

    public void deleteById(Long id) {
        recipeMedicamentDao.delete(id);
    }

    public BigDecimal getPrice(String name) {
        return recipeMedicamentDao.getPrice(name);
    }

    public MedicamentDao getMedicamentDao() {
        return medicamentDao;
    }

    public void setMedicamentDao(MedicamentDao medicamentDao) {
        this.medicamentDao = medicamentDao;
    }

    public IngredientDao getIngredientDao() {
        return ingredientDao;
    }

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

}
