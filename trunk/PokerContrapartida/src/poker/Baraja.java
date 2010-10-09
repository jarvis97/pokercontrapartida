package poker;

/**
 * Baraja de 52 cartas.
 *
 * @author Taras
 * @version 6.10.2010
 */
public class Baraja {
    /**
     * Array que representa la baraja.
     */
    private static Carta[] baraja;
    /**
     * Numero de cartas sacadas de la baraja.
     */
    private int cartasUsadas;
    /**
     * Contructor de la baraja de 52 cartas.
     */
    public Baraja(){
        baraja = new Carta[52];
        int cr = 0;
        for(int palo=0; palo<=3; palo++){
            for(int valor=0; valor<=12; valor++){
                baraja[cr] = new Carta(palo, valor);
                cr++;
            }
        }
        this.cartasUsadas = 0;
    }
    /**
     * Ordenar la baraja en orden aleatorio.
     */
    public void barajar(){
        for (int i = 51; i>0; i--){
            int rand = (int)(Math.random()*(i+1));
            Carta temp = baraja[i];
            baraja[i] = baraja[rand];
            baraja[rand] = temp;
        }
        cartasUsadas = 0;
    }
    /**
     * Indica el numero restante de cartas en la baraja.
     * @return numero de cartas restantes.
     */
    public int restantes(){
        return (52 - cartasUsadas);
    }
    /**
     * Reparte una carta de la baraja.
     * @return una carta.
     */
    public Carta repartirCarta(){
        if (cartasUsadas == 52){
            barajar();
        }
        cartasUsadas++;
        return baraja[cartasUsadas-1];
    }
}
