
package mx.itson.pastor.negocio;

import mx.itson.pastor.persistencia.ClienteDAO;

/**
 *
 * @author Aldrich Edsel Iberri Araiza
 */
public class ClienteNegocio {
    
    public static boolean guardar(String nombre, String direccion, String telefono, String email) {
        boolean resultado = false;
        try {
            resultado = ClienteDAO.guardar(nombre, direccion, telefono, email);
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }
        return resultado;
    }
    
}
