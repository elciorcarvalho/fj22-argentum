package test.java;

import main.java.CandleBuilder;
import main.java.Candlestick;
import org.junit.Test;

/**
 *
 * @author elcior.carvalho
 */
public class CandleBuilderTest {
    
    @Test(expected = IllegalStateException.class)
    public void geracaoDeCandleDeveTerTodosOsDadosNecessarios(){
        CandleBuilder cb = new CandleBuilder();
        
        Candlestick c = cb.geraCandle();
     }
}
