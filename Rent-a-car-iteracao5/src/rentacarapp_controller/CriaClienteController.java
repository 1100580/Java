/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacarapp_controller;

import java.util.Scanner;
import rentacarapp_model.*;

public class CriaClienteController {

    private Empresa m_empresa;

    public CriaClienteController(Empresa e) {
        m_empresa = e;
        
    }
    
    public void CriaCliente(int id, String nome, int telefone, String rua, int numero){
        m_empresa.getRegistoClientes().criaCliente(id, telefone, nome, rua, numero);
    }

    public int procurarID(int id) {
        return m_empresa.getRegistoClientes().procurarID(id);
    }
}
