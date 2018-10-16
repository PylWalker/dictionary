package dictionary.ConnectDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author chinh
 */
public class MySQLConnUtils {
    public static Connection getMySQLConnection() throws SQLException, ClassNotFoundException{
        String hostName = "localhost";
        String dbName = "dictionary";
        String userName = "root";
        String password = "";
        return getMySQLConnection(hostName, dbName, userName, password);
    }
    public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName + "?useUnicode=true&characterEncoding=UTF-8";
        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;
    }
}
