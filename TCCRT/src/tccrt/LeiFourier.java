package tccrt;

public class LeiFourier {
    float Q, espessura, temp, area;
    
    public LeiFourier(float e, float t, float a, Material m){
        espessura = e;
        temp = t;
        area = a;
        escreveExp(m);
    }

    private void escreveExp(Material m) {
        System.out.println("Lei de Fourier - Cálculo de transferência de calor.");
        System.out.println("ΔQ/Δt = κA (ΔT/Δx)\n");
        System.out.println("ΔQ/Δt - Transferência de calor por unidade de tempo.");
        System.out.println("κ - Condutividade térmica do material " + m.getNome() + ".");
        System.out.println("A - Área.");
        System.out.println("ΔT - Diferênça de temperatura.");
        System.out.println("Δx - Espessura dada para o material.\n");
        System.out.println("ΔQ/Δt = " + m.getK()*area*(temp/espessura));
    }
}