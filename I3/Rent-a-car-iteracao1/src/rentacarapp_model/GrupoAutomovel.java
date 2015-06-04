package rentacarapp_model;

public class GrupoAutomovel
{

    private String m_strNome;
    private int m_nPortas;
    private String m_strClasse;
    private String m_strCombustivel;
    private boolean m_bArCondicionado;
    private float m_valorDiario;

    public GrupoAutomovel(String strNome, int nPortas, String strClasse, String strCombustivel, boolean bArCondicionado, float valD)
    {
        setNome(strNome);
        setPortas(nPortas);
        setClasse(strClasse);
        setCombustivel(strCombustivel);
        setArCondicionado(bArCondicionado);
        setM_valorDiario(valD);
    }

    public boolean isArCondicionado()
    {
        return this.m_bArCondicionado;
    }

    public void setArCondicionado(boolean bArCondicionado)
    {
        this.m_bArCondicionado = bArCondicionado;
    }

    public int getPortas()
    {
        return m_nPortas;
    }

    public void setPortas(int nPortas)
    {
        this.m_nPortas = nPortas;
    }

    public String getClasse()
    {
        return m_strClasse;
    }

    public void setClasse(String strClasse)
    {
        this.m_strClasse = strClasse;
    }

    public String getCombustivel()
    {
        return m_strCombustivel;
    }

    public void setCombustivel(String strCombustivel)
    {
        this.m_strCombustivel = strCombustivel;
    }

    public String getNome()
    {
        return m_strNome;
    }

    public void setNome(String strNome)
    {
        this.m_strNome = strNome;
    }

    @Override
    public String toString()
    {
        return getNome() + ", " + getPortas() + ", " + getClasse() + ", " + getCombustivel() + ", " + isArCondicionado();
    }

    /**
     * @return the m_valorDiario
     */
    public float getM_valorDiario() {
        return m_valorDiario;
    }

    /**
     * @param m_valorDiario the m_valorDiario to set
     */
    public void setM_valorDiario(float m_valorDiario) {
        this.m_valorDiario = m_valorDiario;
    }
}

