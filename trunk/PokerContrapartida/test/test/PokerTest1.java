package test;

import junit.framework.TestCase;
import poker.Baraja;
import poker.Carta;
import poker.Mano;

/**
 * Clase de pruebas.
 * @author Taras
 * @version 7.10.2010
 */
public class PokerTest1 extends TestCase {

    private static Baraja baraja;
    private static Mano mimano;

    public PokerTest1(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        baraja = new Baraja();
        baraja.barajar();
        mimano = new Mano();
        for(int i =0; i<mimano.getMano().length ; i++){
            mimano.setCarta(i, baraja.repartirCarta());
        }
    }
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testFullHouseVsEscalera(){
        
        mimano.setCarta(0, new Carta(0,1));
        mimano.setCarta(1, new Carta(1,1));
        mimano.setCarta(2, new Carta(2,1));
        mimano.setCarta(3, new Carta(0,2));
        mimano.setCarta(4, new Carta(1,2));


        System.out.println(mimano.valorMano());
        System.out.println(mimano.toString());

        assertTrue(mimano.esFull());
        assertFalse(mimano.esDoblePareja());
        assertFalse(mimano.esPoker());
        assertFalse(mimano.esColor());
        assertFalse(mimano.esTrio());
        assertFalse(mimano.esPareja());
        assertFalse(mimano.esAK());

        Mano mano2 = new Mano();
        mano2.setCarta(0, new Carta(0,Carta.QUEEN));
        mano2.setCarta(1, new Carta(2,Carta.JACK));
        mano2.setCarta(2, new Carta(3,10));
        mano2.setCarta(3, new Carta(2,9));
        mano2.setCarta(4, new Carta(3,8));

        System.out.println(mano2.valorMano());
        System.out.println(mano2.toString());

        assertTrue(mano2.esEscalera());
        assertEquals(1, mimano.comparar(mano2));
        assertEquals(2, mano2.comparar(mimano));
    }

    public void testAK(){
        mimano.setCarta(0, new Carta(2, 3));
        mimano.setCarta(1, new Carta(1, 5));
        mimano.setCarta(2, new Carta(1, 1));
        mimano.setCarta(3, new Carta(3, 13));
        mimano.setCarta(4, new Carta(0, 8));

        System.out.println(mimano.valorMano());
        System.out.println(mimano.toString());

        assertTrue(mimano.esAK());
    }
    public void testEscaleraA5(){
        mimano.setCarta(0, new Carta(2, 1));
        mimano.setCarta(1, new Carta(1, 2));
        mimano.setCarta(2, new Carta(1, 3));
        mimano.setCarta(3, new Carta(3, 5));
        mimano.setCarta(4, new Carta(0, 4));

        System.out.println(mimano.valorMano());
        System.out.println(mimano.toString());

        assertTrue(mimano.esEscalera());
    }

}
