package pharmacy.dao;

import java.util.List;

import pharmacy.entity.Role;

public interface RoleDao extends Dao<Role>{

    Role findRole(Long id);

    List<Role> findAll();

    void deleteUsersRoles(Long uid);

    void addUsersRoles(Long uid, Long rid);
}
