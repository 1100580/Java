package rentacarapp_model;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import credito.AutorizacaoDebitoCartaoCredito;
import credito.InterfaceADCC;
import descontos.IDesc;

public class ContratoAluguer extends Observable {

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
    InterfaceADCC m_autorizacaoDebitoCartaoCredito;
    int IDCliente;
    IDesc desconto;
    ValContrato vc;
    private boolean pago = false;
    private float valorAcumulado;

    public ContratoAluguer() {
        m_listLinhaServicoAdicional = new ArrayList<LinhaServicoAdicional>();
        m_listCondutorAutorizado = new ArrayList<CondutorAutorizado>();
        vc = new ValContrato();
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
        calculaValorTotal();
        setChanged();
        notifyObservers();
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

    public void calculaValorTotal() {
        float totSA = 0;
        vc.setValDiario(m_automovel.getGA().getM_valorDiario());

        int top = m_listLinhaServicoAdicional.size();
        for (int i = 0; i < top; i++) {
            totSA += ((ServicoAdicional) m_listLinhaServicoAdicional.get(i).getServicoAdicional()).getValorD();
        }
        vc.setValSA(totSA);

        Calendar now = Calendar.getInstance();
        vc.setDias((((long) (m_dataDevolucaoPrevista.getTime() - now.getTime().getTime())) / 86400000) + 1);
        
        vc.calculateValTotal();
    }

    public List<CondutorAutorizado> getListCondutorAutorizado() {
        return m_listCondutorAutorizado;
    }

    public float getValSA() {
        return vc.getValSA();
    }

    public float getValDiario() {
        return vc.getValDiario();
    }

    public long getDias() {
        return vc.getDias();
    }
    
    
    public void addCondutorAutorizado(String strNome, String strEndereco, String strNumero, String strValidade) {
        CondutorAutorizado ca = new CondutorAutorizado(strNome, strEndereco, strNumero, strValidade);

        m_listCondutorAutorizado.add(ca);
    }

    public float getValorAutorizacaoDebito() {
        return getValorTotal() / 4;
    }

    public void setAutorizacaoCartaoCredito(InterfaceADCC adcc) {
        m_autorizacaoDebitoCartaoCredito = adcc;
    }

    public InterfaceADCC getAutorizacaoDebitoCartaoCredito() {
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
        str += "\tCartão nº: " + this.m_autorizacaoDebitoCartaoCredito.getAdcc().getNumeroCartao() + "\n";
        str += "\tValidade: " + this.m_autorizacaoDebitoCartaoCredito.getAdcc().getValidadeCartao() + "\n";
        str += "\tValor autorizado de débito: " + this.m_autorizacaoDebitoCartaoCredito.getAdcc().getValorAutorizado() + "\n";

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
    
    public void desconta() {
        vc.desconta(vc.getIDesc().getValorDesconto());
    }

    public void setDesconto(IDesc id) {
        vc.setDesconto(id);
    }

    /**
     * @return the valorAcumulado
     */
    public float getValorAcumulado() {
        return valorAcumulado;
    }

    /**
     * @param valorAcumulado the valorAcumulado to set
     */
    public void setValorAcumulado(float valorAcumulado) {
        this.valorAcumulado = valorAcumulado;
    }

    public float getValorTotal() {
        return vc.getValTotal();
    }
    
    public void setValorTotal(float nvt){
        vc.setValTotal(nvt);
    }
}
