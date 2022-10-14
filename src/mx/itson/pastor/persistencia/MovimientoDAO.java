
package mx.itson.pastor.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.itson.pastor.negocio.Cuenta;
import mx.itson.pastor.negocio.Movimiento;

/**
 *
 * @author Aldrich Edsel Iberri Araiza
 */
public class MovimientoDAO {
    
    public static List<Movimiento> obtenerTodos () {
        List<Movimiento> movimientos = new ArrayList<>();
        try{
            Connection connection = Conexion.obtener();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT mo.idCuenta, cu.numero, mo.concepto, mo.fecha, mo.importe FROM movimiento mo INNER JOIN cuenta cu ON mo.idCuenta = cu.id;");
            while (resultSet.next()){
                    Movimiento mo = new Movimiento();
                    Cuenta cu = new Cuenta();
                    cu.setId(resultSet.getInt(1));
                    cu.setNumero(resultSet.getString(2));
                    mo.setConcepto(resultSet.getString(3));
                    mo.setFecha(resultSet.getDate(4));
                    mo.setImporte(resultSet.getDouble(5));
                    
                    mo.setCuenta(cu);
                    
                    movimientos.add(mo);
            }
        } catch (Exception ex) {
            System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return movimientos;
    }
    
    public static List<Movimiento> obtenerPorCuenta (String numero) {
        List<Movimiento> movimientos = new ArrayList<>();
        try{
            Connection connection = Conexion.obtener();
            PreparedStatement movimiento = connection.prepareStatement("SELECT mo.idCuenta, cu.numero, mo.concepto, mo.fecha, mo.importe FROM movimiento mo INNER JOIN cuenta cu ON mo.idCuenta = cu.id WHERE cu.numero = ?");
            movimiento.setString(1, numero);
            ResultSet resultSet = movimiento.executeQuery();
            while (resultSet.next()){
                    Movimiento mo = new Movimiento();
                    Cuenta cu = new Cuenta();
                    cu.setId(resultSet.getInt(1));
                    cu.setNumero(resultSet.getString(2));
                    mo.setConcepto(resultSet.getString(3));
                    mo.setFecha(resultSet.getDate(4));
                    mo.setImporte(resultSet.getDouble(5));
                    
                    mo.setCuenta(cu);
                    
                    movimientos.add(mo);
            }
        } catch (Exception ex) {
            System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return movimientos;
    }

    
}
