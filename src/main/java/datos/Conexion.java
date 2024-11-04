package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 * @author tonym
 */
public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost";
    private static final String DATABASE = "appmvc";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static final String URLFINAL = JDBC_URL + "/" + DATABASE + "?useSSL=false&allowPublicKeyRetrieval=true";
    private static BasicDataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(URLFINAL);
            dataSource.setUsername(USER);
            dataSource.setPassword(PASS);
            dataSource.setInitialSize(50);
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt) {
        try {
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
