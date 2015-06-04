/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacarapp_controller;

import java.util.Scanner;
import rentacarapp_model.Empresa;

/**
 *
 * @author Bessa
 */
public class AlteraClienteController {
    Empresa m_empresa;
    Scanner in = new Scanner(System.in);
    
    public AlteraClienteController(Empresa e) {
        m_empresa = e;
        alteraCliente();
    }

    private void alteraCliente() {
        System.out.println("Qual o ID?");
        int id = in.nextInt();
        m_empresa.getRegistoClientes().alterarID(id);
    }
    
}
