package rentacarapp_controller;

import rentacarapp_model.*;
import java.util.*;
import terceiros.AutorizacaoDebitoCartaoCredito;
import terceiros.SistemaAutorizacaoCartaoCredito;

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

    public void setDadosCartaoCredito(String strNumero, String strValidade)
    {
        float fValorCaucao = m_contratoAluguer.getValorAutorizacaoDebito();

        AutorizacaoDebitoCartaoCredito adcc = SistemaAutorizacaoCartaoCredito.autorizacaoDebito(strNumero, strValidade, fValorCaucao);

        m_contratoAluguer.setAutorizacaoCartaoCredito(adcc);
    }

    public void terminaElaboracaoContratoAluguer()
    {
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
    }
}

