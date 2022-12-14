
package mx.itson.pastor.negocio;

import java.util.List;
import mx.itson.pastor.entidades.Cliente;
import mx.itson.pastor.persistencia.CuentaDAO;

/**
 *
 * @author Aldrich Edsel Iberri Araiza
 */
public class Cuenta {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the movimientos
     */
    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    /**
     * @param movimientos the movimientos to set
     */
    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
    
    private int id;
    private Cliente cliente;
    private String numero;
    private List<Movimiento> movimientos;
    
    public static boolean guardar(String numero, int idCliente) {
        boolean resultado = false;
        try {
            if (!CuentaDAO.verificarExistencia(numero)){
                resultado = CuentaDAO.guardar(numero, idCliente);
            }
            resultado = CuentaDAO.guardar(numero, idCliente);
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }
        return resultado;
    }
    
}
