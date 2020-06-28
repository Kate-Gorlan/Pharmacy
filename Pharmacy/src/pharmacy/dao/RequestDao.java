package pharmacy.dao;

import java.util.List;

import pharmacy.entity.Request;

public interface RequestDao extends CrudDao<Long, Request> {

    List<Request> findAll();

    List<Request> findAllById(Long id);

    List<Request> findAllByStatus(String status);
}
