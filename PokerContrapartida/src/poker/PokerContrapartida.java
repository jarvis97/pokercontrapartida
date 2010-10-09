package poker;

/**
 * Poker de Contrapartida.
 * @author Taras
 * @version 7.10.2010
 */
public class PokerContrapartida {

    private Baraja baraja;
    private int dinero;
    private int apuestaInicial;

    public PokerContrapartida(Baraja baraja, int dinero){
        this.baraja = baraja;
        this.dinero = dinero;
    }

    public int actualizarDinero(int dineroInicial, Mano mano, Mano crupier){
        if(mano.comparar(crupier)==0){
            return dineroInicial;
        }
        if(mano.comparar(crupier)==2){
            return dineroInicial - 3*apuestaInicial;
        }
        if(crupier.valorNumericoMano()<1){
            return dineroInicial + apuestaInicial;
        }
        if(mano.comparar(crupier)==1){
            if(mano.esEscaleraReal()){
                return dineroInicial + 300*apuestaInicial;
            }
            if(mano.esEscaleraColor()){
                return dineroInicial + 75*apuestaInicial;
            }
            if(mano.esPoker()){
                return dineroInicial + 60*apuestaInicial;
            }
            if(mano.esFull()){
                return dineroInicial + 21*apuestaInicial;
            }
            if(mano.esColor()){
                return dineroInicial +15*apuestaInicial;
            }
            if(mano.esEscalera()){
                return dineroInicial + 12*apuestaInicial;
            }
            if(mano.esTrio()){
                return dineroInicial + 9*apuestaInicial;
            }
            if(mano.esDoblePareja()){
                return dineroInicial + 6*apuestaInicial;
            }
            if(mano.esPareja()){
                return dineroInicial + 3*apuestaInicial;
            }
        }
        return dineroInicial;
    }
}
