
package mx.itson.pastor.persistencia;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Aldrich Edsel Iberri Araiza
 */
public class Conexion {
    
    public static Connection obtener(){
        Connection conexion = null;
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pastordb?user=root&password=47400Ibe**");
        } catch(Exception e) {
            System.err.print(e.getMessage());
        }
        return conexion;
    }
    
}
