package test.java;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import main.java.Candlestick;
import main.java.CandlestickFactory;
import main.java.Negociacao;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author elcior.carvalho
 */
public class CandlestickFactoryTest {
    
    @Test
    public void sequenciaSimplesDeNegociacoes(){
        Calendar hoje = Calendar.getInstance();
        
        Negociacao n1 = new Negociacao(40.5, 100, hoje);
        Negociacao n2 = new Negociacao(45.0, 100, hoje);
        Negociacao n3 = new Negociacao(39.8, 100, hoje);
        Negociacao n4 = new Negociacao(42.3, 100, hoje);
        
        List<Negociacao> negociacoes = Arrays.asList(n1, n2, n3, n4);
        
        CandlestickFactory fabrica = new CandlestickFactory();
        Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
        
        assertEquals(40.5, candle.getAbertura(), 0.00001);
        assertEquals(42.3, candle.getFechamento(), 0.00001);
        assertEquals(39.8, candle.getMinimo(), 0.00001);
        assertEquals(45.0, candle.getMaximo(), 0.00001);
        assertEquals(16760.0, candle.getVolume(), 0.00001);
    }
    
    @Test
    public void semNegociacoesGeraCandleComZeros(){
        Calendar hoje = Calendar.getInstance();
        
        List<Negociacao> negociacoes = Arrays.asList();
        
        CandlestickFactory fabrica = new CandlestickFactory();
        Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
        
        assertEquals(0.0, candle.getAbertura(), 0.00001);        
        assertEquals(0.0, candle.getFechamento(), 0.00001);        
        assertEquals(0.0, candle.getMinimo(), 0.00001);
        assertEquals(0.0, candle.getMaximo(), 0.00001);        
        assertEquals(0.0, candle.getVolume(), 0.00001);        
    }

    @Test
    public void apenasUmaNegociacaoGeraCandleComValoresIguais(){
        Calendar hoje = Calendar.getInstance();
        
        Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
        
        List<Negociacao> negociacoes = Arrays.asList(negociacao1);
        
        CandlestickFactory fabrica = new CandlestickFactory();
        Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
        
        assertEquals(40.5, candle.getAbertura(), 0.00001);
        assertEquals(40.5, candle.getFechamento(), 0.00001);
        assertEquals(40.5, candle.getMinimo(), 0.00001);
        assertEquals(40.5, candle.getMaximo(), 0.00001);
        assertEquals(4050.0, candle.getVolume(), 0.00001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void naoEhPermitidoPassarListaDeNegociacoesNula(){
        Calendar hoje = Calendar.getInstance();
        
        List<Negociacao> negociacoes = null;
        
        CandlestickFactory fabrica = new CandlestickFactory();
        Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
    }
    
    @Test
    public void negociacoesEmOrdemCrescenteDeValor(){
         Calendar hoje = Calendar.getInstance();
        
        Negociacao n1 = new Negociacao(10, 1, hoje);
        Negociacao n2 = new Negociacao(20, 1, hoje);
        Negociacao n3 = new Negociacao(30, 1, hoje);
        Negociacao n4 = new Negociacao(40, 1, hoje);
        
        List<Negociacao> negociacoes = Arrays.asList(n1, n2, n3, n4);
        
        CandlestickFactory fabrica = new CandlestickFactory();
        Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
        
        assertEquals(10, candle.getAbertura(), 0.00001);
        assertEquals(40, candle.getFechamento(), 0.00001);
        assertEquals(10, candle.getMinimo(), 0.00001);
        assertEquals(40, candle.getMaximo(), 0.00001);
        assertEquals(100, candle.getVolume(), 0.00001);
    }
    
    @Test
    public void negociacoesEmOrdemDecrescenteDeValor(){
        Calendar hoje = Calendar.getInstance();
        
        Negociacao n1 = new Negociacao(40, 1, hoje);
        Negociacao n2 = new Negociacao(30, 1, hoje);
        Negociacao n3 = new Negociacao(20, 1, hoje);
        Negociacao n4 = new Negociacao(10, 1, hoje);
        
        List<Negociacao> negociacoes = Arrays.asList(n1, n2, n3, n4);
        
        CandlestickFactory fabrica = new CandlestickFactory();
        Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
        
        assertEquals(40, candle.getAbertura(), 0.00001);
        assertEquals(10, candle.getFechamento(), 0.00001);
        assertEquals(10, candle.getMinimo(), 0.00001);
        assertEquals(40, candle.getMaximo(), 0.00001);
        assertEquals(100, candle.getVolume(), 0.00001);
    }
    
    // Iniciando TDD
    @Test
    public void paraNegociacoesDeTresDiasDistitosGeraTresCandles(){
        Calendar hoje = Calendar.getInstance();
        
        Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
        Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
        Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
        Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);
        
        Calendar amanha = (Calendar) hoje.clone();
        amanha.add(Calendar.DAY_OF_MONTH, 1);
        
        Negociacao negociacao5 = new Negociacao(48.8, 100, amanha);
        Negociacao negociacao6 = new Negociacao(49.3, 100, amanha);
        
        Calendar depois = (Calendar) amanha.clone();
        depois.add(Calendar.DAY_OF_MONTH, 1);
        
        Negociacao negociacao7 = new Negociacao(51.8, 100, depois);
        Negociacao negociacao8 = new Negociacao(52.3, 100, depois);
        
        List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, 
                negociacao3, negociacao4, negociacao5, negociacao6, 
                negociacao7, negociacao8);
        
        CandlestickFactory fabrica = new CandlestickFactory();
        
        List<Candlestick> candles = fabrica.constroiCandles(negociacoes);
        
        assertEquals(3, candles.size());
        assertEquals(40.5, candles.get(0).getAbertura(), 0.00001);        
        assertEquals(42.3, candles.get(0).getFechamento(), 0.00001);        
        assertEquals(48.8, candles.get(1).getAbertura(), 0.00001);        
        assertEquals(49.3, candles.get(1).getFechamento(), 0.00001);        
        assertEquals(51.8, candles.get(2).getAbertura(), 0.00001);        
        assertEquals(52.3, candles.get(2).getFechamento(), 0.00001);        
    }
}
