package rentacarapp_ui;

import java.util.Scanner;
import rentacarapp_controller.CriaClienteController;
import rentacarapp_model.Empresa;

public class CriaClienteUI {

    private Empresa m_empresa;
    private CriaClienteController m_criaClienteC;

    public CriaClienteUI(Empresa empresa) {
        m_empresa = empresa;
        m_criaClienteC = new CriaClienteController(m_empresa);
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        System.out.println("Qual o id?(BI ou Passaporte)");
        int id = in.nextInt();
        if (m_criaClienteC.procurarID(id) == -1) {
            System.out.println("Qual o nome?");
            String nome = in.next();

            System.out.println("Qual o telefone?");
            int telefone = in.nextInt();

            System.out.println("Qual a rua?");
            String rua = in.next();

            System.out.println("Qual o numero da porta?");
            int numero = in.nextInt();
            
            m_criaClienteC.CriaCliente(id, nome, telefone, rua, numero);
        }
    }
}
