package poker;

/**
 * Representa la mano de poker.
 * @author Taras
 * @version 7.10.2010
 */
public class Mano {
    /**
     * Array que contiene nuestra mano.
     */
    private Carta[] mano;
    /**
     * Constantes que representan la combinacion de la mano.
     */
    public static final int  ESCALERA_REAL = 10,
                             ESCALERA_COLOR = 9,
                             POKER = 8,
                             FULL = 7,
                             COLOR = 6,
                             ESCALERA = 5,
                             TRIO = 4,
                             DOBLE_PAREJA =3,
                             PAREJA=2,
                             AK =1,
                             CARTA_ALTA =0;
    /**
     * Constructor.
     */
    public Mano(){
        this.mano = new Carta[5];
    }
    /**
     * Modifica o pone una carta determinada en nuestra mano.
     * @param i posicion de la carta.
     * @param c carta a poner.
     */
    public void setCarta(int i, Carta c){
        mano[i]= c;
    }
    /**
     * Getter.
     * @return la mano
     */
    public Carta[] getMano(){
        return this.mano;
    }
    /**
     * Comprueba si la combinación de la mano es un color.
     * @return true si la combinacion de la mano es un Color
     */
    public boolean esColor(){
        String palo = mano[0].getPaloString();
        for (int i = 1; i<mano.length; i++){
            if(!(mano[i].getPaloString().equals(palo))){
                return false;
            }
        }
        return true;
    }
    /**
     * Comprobacion si la mano es una pareja.
     * @return true si la combinacion de la mano es Pareja.
     */
    public boolean esPareja(){
        if (esTrio() || esFull() || esPoker()){
            return false;
        }
        return auxCartasIguales(2);
    }
    /**
     * Comprobacion si la mano es un trio (tres cartas iguales).
     * @return true si la combinacion de la mano es Trio.
     */
    public boolean esTrio(){
        if(esFull() || esPoker()){
            return false;
        }
        return auxCartasIguales(3);
    }
    /**
     * Comprobacion si la mano es 4 cartas iguales, poker.
     * @return true si la combinacion de la mano, es Poker.
     */
    public boolean esPoker(){
        return auxCartasIguales(4);
    }
    /**
     * Metodo auxiliar para ver si hay parejas, trio o poker.
     * @param cartasIgualValor entero(2, 3 o 4) para comprobar si hay parejas.
     * @return true si hay parejas, trios, o poker, segun lo que se buscaba.
     */
    private boolean auxCartasIguales(int cartasIgualValor){
        String[] values = new String[5];
        int contador = 0;

        for(int i=0; i<mano.length; i++){
            values[i] = mano[i].getValorString();
        }

        for(int x = 0; x<values.length; x++){
            for(int y = 0; y< mano.length; y++){
                if(values[x].equals(mano[y].getValorString())){
                    contador++;
                }
                if(contador==cartasIgualValor){
                    return true;
                }
            }
            contador =0;
        }
        return false;
    }
    /**
     * Comprobacion si la combinacion de la mano es escalera
     * @return true si la combinacion es una escalera.
     */
    public boolean esEscalera(){
        if(esEscaleraAlta()||esEscaleraBaja()){
            return true;
        }
        return false;
    }
    /**
     * Metodo auxiliar para la comprobacion de la combinacion escalera
     * @param as 14 si se toma As como carta alta, 1 si se toma como baja.
     * @return true si la combinacion la mano es una escalera.
     */
    private boolean auxEscalera(int as){
        int [] values = new int[5];
        int pos;
        int temp;
        for(int i = 0; i< mano.length; i++){
            values[i] = mano[i].getValor();
            if(values[i] == 1){
                values[i] = as;
            }
        }
        for (int i =1; i< values.length; i++){
            pos = i;
            while(pos != 0){
                if(values[pos] < values[pos-1]){
                    temp = values[pos];
                    values[pos] = values[pos-1];
                    values[pos-1] = temp;
                }
                pos--;
            }
        }
        for(int i = 0; i< values.length -1; i++){
            if(values[i] != values[i+1] -1){
                return false;
            }
        }
        return true;
    }
    /**
     * Metodo auxiliar para la comprobacion de escalera.
     * @return true si es escalera en casos que el As se toma como carta alta
     */
    private boolean esEscaleraAlta(){
        return auxEscalera(14);
    }
    /**
     * Metodo auxiliar para la comprobacion de escalera.
     * @return true si es escalera en casos que el As se toma como carta baja
     */
    private boolean esEscaleraBaja(){
        return auxEscalera(1);
    }
    /**
     * Comprueba si la mano es una Escalera de color.
     * @return true si la combinacion de la mano es Escalera de color.
     */
    public boolean esEscaleraColor(){
        if(esEscalera() == true && esColor() == true){
            return true;
        }
        return false;
    }
    /**
     * Comprueba si la mano es una Esclera real.
     * @return true si la combinacion de la mano es Escalera Real.
     */
    public boolean esEscaleraReal(){
        if(esColor() == false || esEscalera() == false){
            return false;
        }
        int [] values = new int[5];
        int pos;
        int temp;

        for(int i = 0; i< mano.length; i++){
            values[i] = mano[i].getValor();
            if(values[i] == 1){
                values[i] = 14;
            }
        }

        for (int i =1; i< values.length; i++){
            pos = i;
            while(pos != 0){
                if(values[pos] < values[pos-1]){
                    temp = values[pos];
                    values[pos] = values[pos-1];
                    values[pos-1] = temp;
                }
                pos--;
            }
        }
        if(values[0] == 10){
            return true;
        }
        return false;
    }
    /**
     * Comprueba si la mano es una doble pareja.
     * @return true si la combinacion de la mano es una doble pareja.
     */
    public boolean esDoblePareja(){
        String[] values = new String[5];
        int contador = 0;
        int sum = 0;

        if(esPoker() == true){
            return false;
        }
        for(int i = 0; i< mano.length; i++){
            values[i] = mano[i].getValorString();
        }
        for(int x = 0; x < values.length; x++){
            for (int y=0; y< mano.length; y++){
                if (values[x].equals(mano[y].getValorString())){
                    contador++;
                }
            }
            if(contador > 1){
                sum++;
            }
            contador = 0;
        }
        if (sum ==4){
            return true;
        }
        return false;
    }
    /**
     * Comprueba si nuestra manos es un Full House.
     * @return true si la combinacion de la mano es un full.
     */
    public boolean esFull(){
        String[] values = new String[5];
        int contador = 0;
        int sum = 0;

        if(esPoker() == true){
            return false;
        }
        for(int i = 0; i< mano.length; i++){
            values[i] = mano[i].getValorString();
        }
        for(int x=0; x < values.length; x++){
            for(int y = 0; y< mano.length; y++){
                if(values[x].equals(mano[y].getValorString())){
                    contador++;
                }
            }
            if(contador > 1){
                sum++;
            }
            contador = 0;
        }
        if (sum == 5){
            return true;
        }
        return false;
    }
    /**
     * Comprueba si la mano es un AKxxx, carta alta.
     * @return true si la mano es AKxxx.
     */
    public boolean esAK(){
        if( esPareja() || esDoblePareja()  || esTrio() ||
            esColor()  || esEscalera()     || esFull() ||
            esPoker()  || esEscaleraColor()|| esEscaleraReal()){
            return false;
        }
        int contador = 0;
        for(int i = 0; i< mano.length; i++){
            if(mano[i].getValorString().equals("A")){
                contador++;
            }
            if(mano[i].getValorString().equals("K")){
                contador++;
            }
        }
        if(contador == 2){
            return true;
        }
        return false;

    }
    /**
     * Metodo para descartase de una carta.
     * @param baraja baraja a usar.
     * @param carta poscion de la carta que queremos descartar.
     */
    public void descartarse(Baraja baraja, int carta){
        setCarta(carta, baraja.repartirCarta());
    }
    /**
     * Entero que representa el valor de la mano de mayor a menor.
     * @return entero con el valor de la mano.
     */
    public int valorNumericoMano(){
        if(esEscaleraReal())
            return 10;
        else if(esEscaleraColor())
            return 9;
        else if(esPoker())
            return 8;
        else if (esFull())
            return 7;
        else if (esColor())
            return 6;
        else if (esEscalera())
            return 5;
        else if (esTrio())
            return 4;
        else if (esDoblePareja())
            return 3;
        else if (esPareja())
            return 2;
        else if (esAK())
            return 1;
        else
            return 0;
    }
    /**
     * Muestra el valor de la mano en forma de string
     * @return string con el valor de la mano.
     */
    public String valorMano(){
        if(esEscaleraReal())
            return "Escalera Real";
        else if(esEscaleraColor())
            return "Escalera de color";
        else if(esPoker())
            return "Poker";
        else if (esFull())
            return "Full House";
        else if (esColor())
            return "Color";
        else if (esEscalera())
            return "Escalera";
        else if (esTrio())
            return "Trio";
        else if (esDoblePareja())
            return "Doble pareja";
        else if (esPareja())
            return "Pareja";
        else if (esAK())
            return "AK";
        else
            return "Carta alta";
    }
    /**
     * Compara cual de las dos manos es mejor.
     * @param m mano con la que comparar.
     * @return 0, si las manos tienen igual valor
     *         1, si la mano actual es mejor.
     *         2, si la mano m es mejor.
     */
    public int comparar(Mano m){
        int valor1 = valorNumericoMano();
        int valor2 = m.valorNumericoMano();
        if (valor1 > valor2){
            return 1;
        }
        else if(valor1 == valor2){
            if (valor1 == 10){
                return 0;
            }
            if(valor1 == 9 || valor1 == 5){
                int maximo1 = 0;
                for(int i =0; i<mano.length; i++){
                    int parcial = mano[i].getValor();
                    if (parcial > maximo1){
                        maximo1 = parcial;
                    }
                }
                int maximo2 = 0;
                for(int j =0; j<mano.length; j++){
                    int parcial2 = m.getMano()[j].getValor();
                    if(parcial2>maximo2)
                        maximo2 = parcial2;
                }
                //problema escalera
                if(maximo1>maximo2)
                    return 1;
                if(maximo2>maximo1)
                    return 2;
                return 0;
            }

            return 0;
        }
        else{
          return 2;
        }
    }
    /**
     * Representacion de la mano en forma de string.
     * @return string que representa la mano.
     */
    @Override
    public String toString(){
	String str = "";
	for(int i = 0; i < mano.length; i++){
		str += "\t" + (i+1) + ": ";
		str += mano[i] + "\n";
	}
	return str;
    }

}
