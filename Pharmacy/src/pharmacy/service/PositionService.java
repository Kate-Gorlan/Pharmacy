package pharmacy.service;

import java.util.Collections;
import java.util.List;

import pharmacy.dao.PositionDao;
import pharmacy.entity.Position;

public class PositionService {

    private PositionDao positionDao;

    public PositionDao getPositionDao() {
        return positionDao;
    }

    public void setPositionDao(PositionDao positionDao) {
        this.positionDao = positionDao;
    }
    
    public void add(Position obj) {
        if (obj.getId() == null) {
            positionDao.create(obj);
        } else {
            positionDao.update(obj);
        }
    }
    
    public boolean check(Position position) {
        boolean check = true ;
        String title = position.getTitle();
        if (title.length()>50) {
            check = false;
        }
        return check;
    }
    
    public Position getPositionById(Long id) {
        return positionDao.read(id);
    }
    
    public List<Position> getPositions(){
        List<Position> reversePosition = positionDao.findAll();
        Collections.reverse(reversePosition);
        return reversePosition;
    }
    
    public void deleteById(Long id) {
        positionDao.delete(id);
    }
}
