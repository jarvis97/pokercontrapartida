package poker;

/**
 * Representa una carta de la baraja de poker.
 *
 * @author Taras
 * @version 7.10.2010
 */
public class Carta {

    /**
     * Constantes que defienen los palos.
     */
    public final static int TREBOLES = 0,
                            CORAZONES = 1,
                            PICAS = 2,
                            DIAMANTES = 3;
    /**
     * Constantes que definen las cartas que no tienen valor numerico.
     */
    public final static int AS = 1,
                            JACK = 11,
                            QUEEN = 12,
                            KING = 13;
    /**
     * Palo de la carta.
     */
    private int palo;
    /**
     * Valor numerico de la carta.
     */
    private int valor;

    /**
     * Contructor.
     * @param valor valor numero de la carta.
     * @param palo palo de la carta.
     */
    public Carta(int palo, int valor){
        this.valor = valor;
        this.palo = palo;
    }
    /**
     * Getter.
     * @return el valor numerico del palo de la carta
     */
    public int getPalo(){
        return this.palo;
    }
    /**
     * Setter.
     * @param palo palo de la carta.
     */
    public void setPalo(int palo){
        this.palo = palo;
    }
    /**
     * Getter.
     * @return el valor numerico de la carta.
     */
    public int getValor(){
        return this.valor;
    }
    /**
     * Setter.
     * @param valor valor de la carta.
     */
    public void setValor(int valor){
        this.valor = valor;
    }
    /**
     * Devuelve el palo de la carta.
     * @return string del palo de la carta.
     */
    public String getPaloString(){
        switch(palo){
            case 0: return "Treboles";
            case 1: return "Corazones";
            case 2: return "Picas";
            case 3: return "Diamantes";
            default: return "?";
        }
    }
    /**
     * Devuelve el valor de la carta
     * @return string con el valor de la carta.
     */
    public String getValorString(){
        switch ( valor ) {
            case 1: return "A";
            case 2: return "2";
            case 3: return "3";
            case 4: return "4";
            case 5: return "5";
            case 6: return "6";
            case 7: return "7";
            case 8: return "8";
            case 9: return "9";
            case 10: return "10";
            case 11: return "J";
            case 12: return "Q";
            case 13: return "K";
            default: return "?";
        }
    }
    /**
     * String que representa la carta.
     * @return string de la carta.
     */
    @Override
    public String toString(){
        return "" + getValorString() + " de " + getPaloString();
    }
}
