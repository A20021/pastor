
package mx.itson.pastor.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.itson.pastor.entidades.Cliente;
import mx.itson.pastor.negocio.Cuenta;

/**
 *
 * @author Aldrich Edsel Iberri Araiza
 */
public class CuentaDAO {
    
    public static List<Cuenta> obtenerTodos () {
        List<Cuenta> cuentas = new ArrayList<>();
        try{
            Connection connection = Conexion.obtener();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT cu.id, cu.numero, cl.id, cl.nombre, cl.direccion, cl.telefono, cl.email FROM cuenta cu INNER JOIN cliente cl ON cu.idCliente = cl.id");
            while (resultSet.next()){
                    Cuenta cuenta = new Cuenta();
                    cuenta.setId(resultSet.getInt(1));
                    cuenta.setNumero(resultSet.getString(2));
                    
                    Cliente c = new Cliente();
                    c.setId(resultSet.getInt(3));
                    c.setNombre(resultSet.getString(4));
                    c.setDireccion(resultSet.getString(5));
                    c.setTelefono(resultSet.getString(6));
                    c.setEmail(resultSet.getString(7));
                    
                    cuenta.setCliente(c);
                    
                    cuentas.add(cuenta);
            }
        } catch (Exception ex) {
            System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return cuentas;
    }
    
}
