package test.java;

import java.util.Calendar;
import main.java.Candlestick;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author elcior.carvalho
 */
public class CandlestickTest {
    
    @Test(expected = IllegalArgumentException.class)
    public void precoMaximoNaoPodeSerMenorQueMinimo(){
        new Candlestick(45.5, 39.8, 58, 36.7, 3000.0, Calendar.getInstance());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void dataNaoPodeSerNula(){
        new Candlestick(10, 50, 10, 50, 3000.0, null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void valoresPassadosNaoPodemSerNegativos(){
        new Candlestick(-10, 50, 10, 50, 3000.0, Calendar.getInstance());
        new Candlestick(10, -50, 10, 50, 3000.0, Calendar.getInstance());
        new Candlestick(10, 50, -10, 50, 3000.0, Calendar.getInstance());
        new Candlestick(10, 50, -50, -10, 3000.0, Calendar.getInstance());
        new Candlestick(10, 50, 10, 50, -3000.0, Calendar.getInstance());
    }
    
    @Test
    public void quandoAberturaIgualFechamentoEhAlta(){
        Candlestick c = new Candlestick(10, 10, 5, 15, 40, Calendar.getInstance());
        
        assertEquals(true, c.isAlta());
        assertEquals(false, c.isBaixa());
    }    
}
