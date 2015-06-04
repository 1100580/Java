package rentacarapp_ui;

import rentacarapp_controller.ElaborarContratoController;
import rentacarapp_model.*;
import utils.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nuno Silva
 */
public class ElaborarContratoUI
{
    private Empresa m_empresa;
    private ElaborarContratoController m_controllerEC;
    private Scanner in = new Scanner(System.in);

    public ElaborarContratoUI( Empresa empresa )
    {
        m_empresa = empresa;
        m_controllerEC = new ElaborarContratoController(m_empresa);
    }

    public void run()
    {
        iniciaContratoAluguer();

        GrupoAutomovel ga = seleccionaGrupoAutomovel();

        // especificar o automóvel
        Automovel auto = seleccionaAutomovel(ga);
        m_controllerEC.setAutomovel(auto);

        // especificar a data de devolução
        Date ddp = indicaDataDevolucaoPrevista();
        m_controllerEC.setDataDevolucaoPrevista(ddp);

        // especificar os serviços adicionais
        seleccionaServicosAdicionais();

        // especificar o local de devolução
        LocalDevolucao ld = seleccionaLocalDevolucao();
        m_controllerEC.setLocalDevolucao(ld);

        float fTotal = m_controllerEC.getValorTotalContrato();
        System.out.println("Valor total do contrato: " + fTotal);
        System.out.println("Valor do ADCC: " + fTotal/4);

        // identificar cliente manualmente
        //introduzDadosCliente();
        
        //indentifica cliente
        defineClienteID();
        
        //introduz cliente autorizado manualmente
        //introduzCondutoresAutorizados();
        if (clienteECondutor()) {
            introduzRestantesDadosCA();
            System.out.println("Inserir mais condutores?(S/N)");
            if (in.next().equals("S")) {
                introduzCondutoresAutorizados();
            }
        }else{
            introduzCondutoresAutorizados();
        }

        introduzDadosCartaoCredito();

        imprimeAutorizacaoDebitoCartaoCredito();

        imprimeContrato();

        imprimeComprovativoEntrega();
        
        pagarContrato();

        terminaElaboracaoContratoAluguer();
    }

    private void iniciaContratoAluguer()
    {
        m_controllerEC.iniciaContratoAluguer();
    }

    private GrupoAutomovel seleccionaGrupoAutomovel()
    {
        int index = 0;
        List<GrupoAutomovel> listGA = m_controllerEC.getCatalogoGrupoAutomovel();

        System.out.println("Catálogo Grupo Automóvel:");
        System.out.println("Grupo, Nº portas, Classe, Combustivel, AC(S/N)");
        for (Iterator<GrupoAutomovel> i = listGA.iterator(); i.hasNext();)
        {
            GrupoAutomovel ga = i.next();
            index++;

            System.out.println(index + ". " + ga.toString());
        }

        String opcao;
        int nOpcao;
        do
        {
            opcao = Utils.readLineFromConsole("Introduza opção: ");
            nOpcao = new Integer(opcao);
        } while (nOpcao < 1 || nOpcao > listGA.size());

        return listGA.get(nOpcao - 1);
    }

    private Automovel seleccionaAutomovel(GrupoAutomovel ga)
    {
        int index = 0;
        List<Automovel> listFrotaByGA = m_controllerEC.getFrotaByGrupoAutomovel(ga);

        System.out.println("Automóveis do Grupo Automóvel " + ga.getNome());

        for (Iterator<Automovel> i = listFrotaByGA.iterator(); i.hasNext();)
        {
            Automovel auto = i.next();
            index++;

            System.out.println(index + ". " + auto.toString());
        }

        String opcao;
        int nOpcao;
        do
        {
            opcao = Utils.readLineFromConsole("Introduza opção: ");
            nOpcao = new Integer(opcao);
        } while (nOpcao < 1 || nOpcao > listFrotaByGA.size());

        return listFrotaByGA.get(nOpcao - 1);
    }

    private Date indicaDataDevolucaoPrevista()
    {
        Date today = new Date();
        Date ddp;

        do
        {
            ddp = Utils.readDateFromConsole("Introduza a data de devolução prevista (dd-mm-aaaa): ");
        } while (ddp.before(today));

        return ddp;
    }

    private void seleccionaServicosAdicionais()
    {
        int qtd = 1;
        ServicoAdicional sa;
        do
        {
            sa = seleccionaServicoAdicional();
            if (sa != null)
            {
                if (sa.isAcumulavel()) {
                    System.out.println("Quantidade?");
                    qtd = in.nextInt();
                }
                m_controllerEC.addServicoAdicional(sa, qtd);
            }
        } while (sa != null);
    }

    private ServicoAdicional seleccionaServicoAdicional()
    {
        int index = 0;
        List<ServicoAdicional> listServicoAdicional = m_controllerEC.getCatalogoServicoAdicional();

        System.out.println("Serviços Adicionais:");

        for (Iterator<ServicoAdicional> i = listServicoAdicional.iterator(); i.hasNext();)
        {
            ServicoAdicional sa = i.next();
            index++;

            System.out.println(index + ". " + sa.toString());
        }
        System.out.println("0. mais nenhum");

        String opcao;
        int nOpcao;
        do
        {
            opcao = Utils.readLineFromConsole("Introduza opção: ");
            nOpcao = new Integer(opcao);
        } while (nOpcao < 0 || nOpcao > listServicoAdicional.size());

        if (nOpcao == 0)
        {
            return null;
        } else
        {
            return listServicoAdicional.get(nOpcao - 1);
        }
    }

    private LocalDevolucao seleccionaLocalDevolucao()
    {
        int index = 0;
        List<LocalDevolucao> listLD = m_controllerEC.getCatalogoLocalDevolucao();

        System.out.println("Catálogo Local de Devolução:");
        for (Iterator<LocalDevolucao> i = listLD.iterator(); i.hasNext();)
        {
            LocalDevolucao ld = i.next();
            index++;

            System.out.println(index + ". " + ld.toString());
        }

        String opcao;
        int nOpcao;
        do
        {
            opcao = Utils.readLineFromConsole("Introduza opção: ");
            nOpcao = new Integer(opcao);
        } while (nOpcao < 1 || nOpcao > listLD.size());

        return listLD.get(nOpcao - 1);
    }

    private void introduzDadosCliente()
    {
        String strNome = Utils.readLineFromConsole("Introduza Nome do cliente: ");

        String strEndereco = Utils.readLineFromConsole("Introduza Endereço do cliente: ");

        String strTelefone = Utils.readLineFromConsole("Introduza Telefone do cliente: ");

        String strEmail = Utils.readLineFromConsole("Introduza Email do cliente: ");

        String strObservacoes = Utils.readLineFromConsole("Introduza Observações do cliente: ");

        m_controllerEC.setDadosCliente(strNome, strEndereco, strTelefone, strEmail, strObservacoes);
    }

    private void introduzCondutoresAutorizados()
    {
        String strResposta;
        do
        {
            String strNome = Utils.readLineFromConsole("Introduza Nome do condutor: ");
            String strEndereco = Utils.readLineFromConsole("Introduza Endereço do condutor: ");
            String strNumero = Utils.readLineFromConsole("Introduza Número da carta de condução: ");
            String strValidade = Utils.readLineFromConsole("Introduza Validade da carta de condução: ");

            m_controllerEC.addCondutorAutorizado(strNome,strEndereco,strNumero,strValidade);

            strResposta = Utils.readLineFromConsole("Introduzir outro condutor autorizado (S/N)? ");
        } while (strResposta.equalsIgnoreCase("S"));
    }

    private void introduzDadosCartaoCredito()
    {
        String strNumero = Utils.readLineFromConsole("Introduza Número do cartão de crédito: ");
        String strValidade = Utils.readLineFromConsole("Introduza Validade do cartão de crédito: ");
        m_controllerEC.setDadosCartaoCredito(strNumero,strValidade);
    }

    private void imprimeAutorizacaoDebitoCartaoCredito()
    {
        System.out.println("Imprimindo autorização de débito em cartão de crédito...");
        
        Logger.getLogger("Rent-a-car").log(Level.WARNING, "Autorização de débito em cartão de crédito não impresso. É necessário clarificar processo com o cliente.");
    }

    private void imprimeContrato()
    {
        System.out.println("Imprimindo 2 cópias do Contrato de Aluguer...");

        Logger.getLogger("Rent-a-car").log(Level.WARNING, "Contrato de Aluguer não impresso. É necessário clarificar processo com o cliente.");
    }

    private void imprimeComprovativoEntrega()
    {
        System.out.println("Imprimindo 2 cópias do comprovativo de entrega...");

        Logger.getLogger("Rent-a-car").log(Level.WARNING, "Comprovativo de entrega não impresso. É necessário clarificar processo com o cliente.");
    }

    private void terminaElaboracaoContratoAluguer()
    {
        m_controllerEC.terminaElaboracaoContratoAluguer();
    }

    private void defineClienteID() {
        System.out.println("Qual o id do cliente?");
        int idC = in.nextInt();
        
        if (m_controllerEC.procuraClienteID(idC) != -1) {
            
            m_controllerEC.printDadosCliente(idC);
            System.out.println("Confirma estes dados?(S/N)");
            String verif = in.next();
            
            if (verif.equals("S")) {
                m_controllerEC.attachCliente(idC);
            }else{
                defineClienteID();
            }
        }else{
            System.out.println("Cliente não existe, criando novo...");
            CriaClienteUI uicc = new CriaClienteUI(m_empresa);
            defineClienteID();
        }
    }

    private boolean clienteECondutor() {
        System.out.println("Este cliente é um condutor autorizado?(S/N)");
        if (in.next().equals("S")) {
            return true;
        }else{
            return false;
        }
    }

    private void introduzRestantesDadosCA() {
            String strNumero = Utils.readLineFromConsole("Introduza Número da carta de condução: ");
            String strValidade = Utils.readLineFromConsole("Introduza Validade da carta de condução: ");
            m_controllerEC.addRestantesDadosCA(strNumero,strValidade);
    }

    private void pagarContrato() {
        System.out.println("Contrato já foi pago?(S/N)");
        if (in.next().equals("S")) {
            m_controllerEC.pagar();
        }
    }
}