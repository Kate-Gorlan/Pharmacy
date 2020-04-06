package pharmacy.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import pharmacy.common.Connect;
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
    
    public void addlogin(String login, String pass) throws SQLException {
        Connection con = null;
        CallableStatement proc = null;

        try
        {
          con  = Connect.connectStart();
          proc = con.prepareCall("execute addlogin1 @login_ = '"+login+"', @password1 = '"+pass+"'");
          proc.execute();
        }
        finally
        {
          try
          {
            proc.close();
          }
          catch (SQLException e) {}
          con.close();
        }
    }
    
    public void deletelogin(String login) throws SQLException {
        Connection con = null;
        CallableStatement proc = null;

        try
        {
          con  = Connect.connectStart();
          proc = con.prepareCall("execute deletelogin1 @login_ = '"+login+"'");
          proc.execute();
        }
        finally
        {
          try
          {
            proc.close();
          }
          catch (SQLException e) {}
          con.close();
        }
    }
    
    public void grantlogin(String func, String table, String login) throws SQLException {
        Connection con = null;
        CallableStatement proc = null;
        String textParam = "GRANT " + func + " ON " + table + " TO " + login;

        try
        {
          con  = Connect.connectStart();
          proc = con.prepareCall("execute grantlogin @text1 = '"+textParam+"'");
          proc.execute();
        }
        finally
        {
          try
          {
            proc.close();
          }
          catch (SQLException e) {}
          con.close();
        }
    }
    
    public void revokelogin(String func, String table, String login) throws SQLException {
        Connection con = null;
        CallableStatement proc = null;
        String textParam = "REVOKE " + func + " ON " + table + " TO " + login;

        try
        {
          con  = Connect.connectStart();
          proc = con.prepareCall("execute grantlogin @text1 = '"+textParam+"'");
          proc.execute();
        }
        finally
        {
          try
          {
            proc.close();
          }
          catch (SQLException e) {}
          con.close();
        }
    }
}
