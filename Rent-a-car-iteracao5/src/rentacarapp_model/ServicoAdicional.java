/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacarapp_model;

/**
 *
 * @author Nuno Silva
 */
public class ServicoAdicional
{
    private String m_strServicoAdicional;
    private float valorD;
    private boolean acumulavel;
    private int max;
    
    public ServicoAdicional(String strServicoAdicional, float valorD, boolean ac, int max)
    {
        m_strServicoAdicional = strServicoAdicional;
        setValorD(valorD);
        setAcumulavel(ac);
    }
    
    public boolean isAcumulavel(){
        return acumulavel;
    }

    @Override
    public String toString()
    {
        return getM_strServicoAdicional();
    }

    /**
     * @return the m_strServicoAdicional
     */
    public String getM_strServicoAdicional() {
        return m_strServicoAdicional;
    }

    /**
     * @param m_strServicoAdicional the m_strServicoAdicional to set
     */
    public void setM_strServicoAdicional(String m_strServicoAdicional) {
        this.m_strServicoAdicional = m_strServicoAdicional;
    }

    /**
     * @return the valorD
     */
    public float getValorD() {
        return valorD;
    }

    /**
     * @param valorD the valorD to set
     */
    public void setValorD(float valorD) {
        this.valorD = valorD;
    }

    private void setAcumulavel(boolean ac) {
        acumulavel = ac;
    }

    /**
     * @return the max
     */
    public int getMax() {
        return max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(int max) {
        this.max = max;
    }
}
