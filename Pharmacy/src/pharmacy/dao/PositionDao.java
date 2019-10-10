package pharmacy.dao;

import java.util.List;

import pharmacy.entity.Position;

public interface PositionDao extends CrudDao<Long, Position>{

    Position findPosition(Long id);
    
    List<Position> findAll();

}
