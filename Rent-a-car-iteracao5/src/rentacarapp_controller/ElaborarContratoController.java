package rentacarapp_controller;

import credito.SistACCAAdapter;
import rentacarapp_model.*;
import java.util.*;
import credito.*;
import descontos.DescFactory;
import descontos.IDesc;
import rentacarapp_ui.ElaborarContratoUI;

public class ElaborarContratoController
{
    private Empresa m_empresa;
    private ContratoAluguer m_contratoAluguer;

    public ElaborarContratoController(Empresa empresa)
    {
        m_empresa = empresa;
    }

    public void iniciaContratoAluguer()
    {
        m_contratoAluguer = m_empresa.criaContratoAluguer();
    }

    public List<GrupoAutomovel> getCatalogoGrupoAutomovel()
    {
        return m_empresa.getCatalogoGrupoAutomovel();
    }

    public List<Automovel> getFrotaByGrupoAutomovel(GrupoAutomovel ga)
    {
        return m_empresa.getFrota().getFrotaByGrupoAutomovel(ga);
    }

    public void setAutomovel(Automovel auto)
    {
        m_contratoAluguer.setAutomovel(auto);
    }

    public void setDataDevolucaoPrevista(Date ddp)
    {
        m_contratoAluguer.setDataDevolucaoPrevista(ddp);
    }

    public void setDadosCliente(String strNome, String strEndereco,
            String strTelefone, String strEmail, String strObservacoes)
    {
        m_contratoAluguer.setDadosCliente(strNome, strEndereco, strTelefone, strEmail, strObservacoes);
    }

    public List<ServicoAdicional> getCatalogoServicoAdicional()
    {
        return m_empresa.getCatalogoServicoAdicional();
    }

    public void addServicoAdicional(ServicoAdicional sa, int qtd)
    {
        if (!(m_contratoAluguer.exists(sa))) {
            m_contratoAluguer.addServicoAdicional(sa, qtd);
        }else{
            System.out.println("Serviço adicional já existe.");
        }
    }

    public List<LocalDevolucao> getCatalogoLocalDevolucao()
    {
        return m_empresa.getCatalogoLocalDevolucao();
    }

    public void setLocalDevolucao(LocalDevolucao ld)
    {
        m_contratoAluguer.setLocalDevolucao(ld);
    }

    public float getValorTotalContrato()
    {
        return m_contratoAluguer.getValorTotal();
    }

    public void addCondutorAutorizado(String strNome, String strEndereco, String strNumero, String strValidade)
    {
        m_contratoAluguer.addCondutorAutorizado(strNome, strEndereco, strNumero, strValidade);
    }

    public void setDadosCartaoCredito(Date dataValidade,String strNumCC, Date dataLimite)
    {
        float fValorADCC = m_contratoAluguer.getValorAutorizacaoDebito();
        
        SistACCFactory sf = SistACCFactory.getInstance();
        
        SistACCAAdapter sACC = sf.getSistAutorizacaoCartaoCredito();
        
        InterfaceADCC adcc = sACC.autorizacaoDebito(dataValidade, strNumCC,fValorADCC, dataLimite);

        m_contratoAluguer.setAutorizacaoCartaoCredito(adcc);
    }

    public void terminaElaboracaoContratoAluguer()
    {
        int idc = getContratoAluguer().getIDCliente();
        int index = m_empresa.getRegistoClientes().procurarID(idc);
        m_empresa.getRegistoClientes().getIndex(index).addValAc(getContratoAluguer().getValorTotal());
        m_empresa.addContratoAluguer(m_contratoAluguer);
    }

    public void attachCliente(int id) {
        m_contratoAluguer.setIDCliente(id);
    }

    public int procuraClienteID(int id) {
        return m_empresa.getRegistoClientes().procurarID(id);
    }

    public void printDadosCliente(int idC) {
        int index = m_empresa.getRegistoClientes().procurarID(idC);
        m_empresa.getRegistoClientes().printIndex(index);
    }

    public void addRestantesDadosCA(String strNumero, String strValidade) {
        int index = procuraClienteID(m_contratoAluguer.getIDCliente());
        String strNome = m_empresa.getRegistoClientes().getIndex(index).getNome();
        String strEndereco = m_empresa.getRegistoClientes().getIndex(index).getMorada().toString();
        m_contratoAluguer.addCondutorAutorizado(strNome, strEndereco, strNumero, strValidade);
    }

    public void pagar() {
        m_contratoAluguer.setPago();
        m_empresa.addContratoAluguer(m_contratoAluguer);
    }

    public float getValorADCC() {
        return m_contratoAluguer.getValorAutorizacaoDebito();
    }

    public void calculaTotalContrato() {
        m_contratoAluguer.calculaValorTotal();
    }

    public boolean getStatusAutorizacaoDebito() {
        if (m_contratoAluguer.getAutorizacaoDebitoCartaoCredito().getStatus().equals("OK")) {
            return true;
        }
        return false;
    }

    public Date getDataDevolucaoPrevista() {
        return m_contratoAluguer.getDataDevolucaoPrevista();
    }

    public String imprimeADCC() {
        return m_contratoAluguer.getAutorizacaoDebitoCartaoCredito().toString();
    }
    
    public ContratoAluguer getContratoAluguer(){
        return m_contratoAluguer;
    }

    public void retiraValorDesconto() {
        IDesc id = DescFactory.getInstance().getDesconto();
        m_contratoAluguer.setDesconto(id);
        m_contratoAluguer.desconta();
    }

    public void setAsObserver(Observer o) {
        m_contratoAluguer.addObserver(o);
    }
}

