package figurasgeometricas;

import java.util.ArrayList;
import java.util.Collections;

public class TesteFiguras {

    public static void main(String[] args) throws Exception {
        Rectangulo r1 = new Rectangulo(3, 2, Cor.BRANCO);
        Rectangulo r2 = new Rectangulo(1, 2, Cor.ENCARNADO);
        Paralelepipedo p1 = new Paralelepipedo();
        Quadrado q1 = new Quadrado(6, Cor.AMARELO);
        Circulo c1 = new Circulo(3, Cor.AZUL);
        Esfera e1 = new Esfera(2.5f, Cor.BRANCO);

        ArrayList figs = new ArrayList();
        figs.add(r1);
        figs.add(r2);
        figs.add(p1);
        figs.add(q1);
        figs.add(c1);
        figs.add(e1);

        for (int i = 0; i < figs.size(); i++) {
            System.out.println(figs.get(i) + " - area: " + ((Figura) figs.get(i)).area());
            if (figs.get(i) instanceof Figura3D)
                System.out.println("Volume: " + ((Figura3D) figs.get(i)).volume());
        }
        System.out.println("----------------------------------------------------");
        for (Object obj : figs) {
            System.out.println(obj + " - area: " + ((Figura) obj).area());
            if (obj instanceof Figura3D)
                System.out.println("Volume: " + ((Figura3D)obj).volume());
        }

        System.out.println("-------------------Listagem de Figuras Azuis-------------------");
        for(Object obj : figs) {
            if (((Figura) obj).getCor() == Cor.AZUL) {
                System.out.println(obj);
            }
        }
        System.out.println("-------------------Listagem de Cores Não Usadas-------------------");
        for (Cor cor : Cor.values()) {
            boolean existe = false;
            for (Object obj : figs) {
                if (((Figura) obj).getCor() == cor) {
                    existe = true;
                    break;
                }
            }
            if (!existe)
                System.out.println(cor);
        }

        System.out.println("------------------------------------------------");
        ArrayList<Figura> figs2 = new ArrayList<Figura>();
        figs2.add(r1);
        figs2.add(r2);
        figs2.add(p1);
        figs2.add(q1);
        figs2.add(c1);
        figs2.add(e1);

        Collections.sort(figs2);

        for (Figura fig : figs2) {
            System.out.println(fig + " - Area: " + fig.area());
            if (fig instanceof Figura3D)
                System.out.println("Volume: " + ((Figura3D) fig).volume());
        }

        try{
            Circulo c2 = Circulo.lerCirculo();
            System.out.println(c2);
        } catch(NumberFormatException nfe){
            System.out.println("Insira um raio válido");
        } catch(IllegalArgumentException iae){
            System.out.println("Insira uma cor válida");
        } catch(ValorNuloOuNegativoException exc){
            System.out.println(exc.getMessage());
        }
    }
}
