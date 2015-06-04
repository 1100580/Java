package rentacarapp_model;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import terceiros.AutorizacaoDebitoCartaoCredito;

public class ContratoAluguer {

    Automovel m_automovel;
    Date m_dataDevolucaoPrevista;
    List<LinhaServicoAdicional> m_listLinhaServicoAdicional;
    LocalDevolucao m_localDevolucao;
    List<CondutorAutorizado> m_listCondutorAutorizado;
    String m_strNomeCliente;
    String m_strEnderecoCliente;
    String m_strTelefoneCliente;
    String m_strEmailCliente;
    String m_strObservacoesCliente;
    AutorizacaoDebitoCartaoCredito m_autorizacaoDebitoCartaoCredito;
    int IDCliente;
    private boolean pago = false;

    public ContratoAluguer() {
        m_listLinhaServicoAdicional = new ArrayList<LinhaServicoAdicional>();
        m_listCondutorAutorizado = new ArrayList<CondutorAutorizado>();
    }

    public void setAutomovel(Automovel a) {
        m_automovel = a;
    }

    public void setLocalDevolucao(LocalDevolucao ld) {
        m_localDevolucao = ld;
    }

    public void setDataDevolucaoPrevista(Date ddp) {
        m_dataDevolucaoPrevista = ddp;
    }

    public void setDadosCliente(String strNome, String strEndereco, String strTelefone, String strEmail, String strObservacoes) {
        setNomeCliente(strNome);
        setEnderecoCliente(strEndereco);
        setTelefoneCliente(strTelefone);
        setEmailCliente(strEmail);
        setObservacoesCliente(strObservacoes);
    }

    private void setNomeCliente(String m_strNome) {
        m_strNomeCliente = m_strNome;
    }

    private void setEnderecoCliente(String m_strEndereco) {
        m_strEnderecoCliente = m_strEndereco;
    }

    private void setTelefoneCliente(String m_strTelefone) {
        m_strTelefoneCliente = m_strTelefone;
    }

    public void setEmailCliente(String m_strEmail) {
        this.m_strEmailCliente = m_strEmail;
    }

    private void setObservacoesCliente(String m_strObservacoes) {
        m_strObservacoesCliente = m_strObservacoes;
    }

    public void addServicoAdicional(ServicoAdicional sa, int qtd) {
        LinhaServicoAdicional lsa = new LinhaServicoAdicional(sa, qtd);
        m_listLinhaServicoAdicional.add(lsa);
    }

    public Automovel getAutomovel() {
        return m_automovel;
    }

    public Date getDataDevolucaoPrevista() {
        return m_dataDevolucaoPrevista;
    }

    public List<LinhaServicoAdicional> getListLinhaServicoAdicional() {
        return m_listLinhaServicoAdicional;
    }

    public LocalDevolucao getLocalDevolucao() {
        return m_localDevolucao;
    }

    public float getValorTotal() {
        float totalD, total;
        int dias;
        totalD = m_automovel.getGA().getM_valorDiario();
        int top = m_listLinhaServicoAdicional.size();
        for (int i = 0; i < top; i++) {
            totalD += ((ServicoAdicional) m_listLinhaServicoAdicional.get(i).getServicoAdicional()).getValorD();
        }
        Calendar now = Calendar.getInstance();
        dias = (((int) (m_dataDevolucaoPrevista.getTime() - now.getTime().getTime())) / 86400000) + 1;
        total = totalD * dias;
        return total;
    }

    public List<CondutorAutorizado> getListCondutorAutorizado() {
        return m_listCondutorAutorizado;
    }

    public void addCondutorAutorizado(String strNome, String strEndereco, String strNumero, String strValidade) {
        CondutorAutorizado ca = new CondutorAutorizado(strNome, strEndereco, strNumero, strValidade);

        m_listCondutorAutorizado.add(ca);
    }

    public float getValorAutorizacaoDebito() {
        Logger.getLogger("Rent-a-car").log(Level.WARNING, "Valor autorização de débito não calculado/definido. É necessário clarificar processo com o cliente.");
        return 0f;
    }

    public void setAutorizacaoCartaoCredito(AutorizacaoDebitoCartaoCredito adcc) {
        m_autorizacaoDebitoCartaoCredito = adcc;
    }

    public AutorizacaoDebitoCartaoCredito getAutorizacaoDebitoCartaoCredito() {
        return m_autorizacaoDebitoCartaoCredito;
    }

    @Override
    public String toString() {
        String str = "Automóvel: " + getAutomovel().toString() + "\n";
        str += "Data de devolução prevista: " + getDataDevolucaoPrevista().toString() + "\n";
        str += "Local de devolucao: " + getLocalDevolucao() + "\n";

        str += "Serviços Adicionais:\n";
        for (Iterator<LinhaServicoAdicional> i = getListLinhaServicoAdicional().iterator(); i.hasNext();) {
            LinhaServicoAdicional lsa = i.next();
            str += "\t" + lsa.toString() + "\n";
        }

        str += "Cliente:\n";
        str += "\tNome: " + this.m_strNomeCliente + "\n";
        str += "\tEndereço: " + this.m_strEnderecoCliente + "\n";
        str += "\tEmail: " + this.m_strEmailCliente + "\n";
        str += "\tTelefone: " + this.m_strTelefoneCliente + "\n";
        str += "\tObservações: " + this.m_strObservacoesCliente + "\n";

        str += "Condutores Autorizados:\n";
        for (Iterator<CondutorAutorizado> i = getListCondutorAutorizado().iterator(); i.hasNext();) {
            CondutorAutorizado ca = i.next();
            str += "\tNome: " + ca.getNome() + "\n";
            str += "\tEndereço: " + ca.getEndereco() + "\n";
            str += "\tNúmero de carta de condução: " + ca.getNumeroCartaConducao() + "\n";
            str += "\tValidade de carta de condução: " + ca.getValidadeCartaConducao() + "\n";
        }

        str += "Autorização Débito em Cartão de Crédito:\n";
        str += "\tCartão nº: " + this.m_autorizacaoDebitoCartaoCredito.getNumeroCartao() + "\n";
        str += "\tValidade: " + this.m_autorizacaoDebitoCartaoCredito.getValidadeCartao() + "\n";
        str += "\tValor autorizado de débito: " + this.m_autorizacaoDebitoCartaoCredito.getValorAutorizado() + "\n";

        return str;
    }

    public void setIDCliente(int id) {
        IDCliente = id;
    }

    public int getIDCliente() {
        return IDCliente;
    }

    public void setPago() {
        pago = true;
    }

    public boolean exists(ServicoAdicional sa) {
        for (int i = 0; i < m_listLinhaServicoAdicional.size(); i++) {
            if (sa == m_listLinhaServicoAdicional.get(i).getServicoAdicional()) {
                return true;
            }
        }
        return false;
    }
}
