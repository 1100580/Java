package rentacarapp_model;

public class LinhaServicoAdicional
{
    ServicoAdicional m_servicoAdicional;
    int qtd;

    public LinhaServicoAdicional(ServicoAdicional sa, int qtd)
    {
        m_servicoAdicional = sa;
        setQtd(qtd);
    }

    public ServicoAdicional getServicoAdicional()
    {
        return m_servicoAdicional;
    }

    @Override
    public String toString()
    {
        return m_servicoAdicional.toString();
    }

    private void setQtd(int q) {
        qtd = q;
    }
    
    public int getQtd(){
        return qtd;
    }
}

