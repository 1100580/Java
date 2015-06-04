package rentacarapp_ui;

import rentacarapp_controller.AlteraClienteController;
import rentacarapp_model.*;
import java.io.IOException;
import rentacarapp_controller.CriaClienteController;
import utils.*;

/**
 *
 * @author Nuno Silva
 */
public class MenuUI {

    private Empresa m_empresa;
    private String opcao;

    public MenuUI(Empresa empresa) {
        m_empresa = empresa;
    }

    public void run() throws IOException {
        do {
            opcao = "1";

            System.out.println("1. Elaborar Contrato");
            System.out.println("2. Entregar Automóvel");
            System.out.println("3. Devolver Automóvel");
            System.out.println("4. Cria Cliente");
            System.out.println("5. Altera Cliente");
            System.out.println("0. Sair");

            opcao = Utils.readLineFromConsole("Introduza opção: ");

            if (opcao.equals("1")) {
                ElaborarContratoUI uiEC = new ElaborarContratoUI(m_empresa);
                uiEC.run();
            }
            if (opcao.equals("2") || opcao.equals("3")) {
                System.out.println("Opção não implementada.");
            }
            if (opcao.equals("4")) {
                CriaClienteUI uiCC = new CriaClienteUI(m_empresa);
            }
            if (opcao.equals("5")) {
                AlteraClienteController ac = new AlteraClienteController(m_empresa);
            }
        } while (!opcao.equals("0"));
    }
}
