package pharmacy.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import java.util.Arrays;
import java.util.Properties;

public class Connect
{
    public static Statement stmt = null;
    public static Connection conn = null;
    
    public static Connection connectStart() {
        
        String dbName = "pharmacyBD";
        String serverip="127.0.0.1";
        String serverport="51637";
        String url = "jdbc:sqlserver://"+serverip+"\\SQLEXPRESS:"+serverport+";databaseName="+dbName+";integratedSecurity=true";
        ResultSet result = null;
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return conn;
    }

    public static void connectClose ()
    {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

}

