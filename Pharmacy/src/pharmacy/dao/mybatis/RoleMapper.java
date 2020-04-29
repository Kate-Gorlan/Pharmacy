package pharmacy.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import pharmacy.dao.RoleDao;
import pharmacy.entity.Role;

public class RoleMapper extends SqlSessionDaoSupport implements RoleDao{

    @Override
    public List<Role> findAll() {
        return getSqlSessionTemplate().selectList("pharmacy.dao.RoleDao.findAll");
    }

    @Override
    public void deleteUsersRoles(Long uid) {
        getSqlSessionTemplate().delete("pharmacy.dao.RoleDao.deleteAll", uid);        
    }

    @Override
    public void addUsersRoles(Long uid, Long rid) {
        Map<String, Object> map = new HashMap<>();
        map.put("uid", uid);
        map.put("rid", rid);
        getSqlSessionTemplate().insert("pharmacy.dao.RoleDao.addRole", map);
    }

}
