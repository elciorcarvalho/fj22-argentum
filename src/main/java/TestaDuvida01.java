
package main.java;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author elcior.carvalho
 */
public class TestaDuvida01 {
    public static void main(String[] args) {
        Calendar hoje = Calendar.getInstance();
    
        Negociacao negociacaoPetrobras1 = new Negociacao(30, -10, hoje);

        List<Negociacao> negociacoes1 = Arrays.asList(negociacaoPetrobras1);

        CandlestickFactory fabrica1 = new CandlestickFactory();

        Candlestick candle1 = fabrica1.constroiCandleParaData(hoje, negociacoes1);

        System.out.println(candle1.getAbertura());
        System.out.println(candle1.getFechamento());
        System.out.println(candle1.getMinimo());
        System.out.println(candle1.getMaximo());
        System.out.println(candle1.getVolume());
        
        System.out.println("-------------------------------------------");
        
        Negociacao negociacaoPetrobras2 = new Negociacao(30, 0, hoje);

        List<Negociacao> negociacoes2 = Arrays.asList(negociacaoPetrobras2);

        CandlestickFactory fabrica2 = new CandlestickFactory();

        Candlestick candle2 = fabrica2.constroiCandleParaData(hoje, negociacoes2);

        System.out.println(candle2.getAbertura());
        System.out.println(candle2.getFechamento());
        System.out.println(candle2.getMinimo());
        System.out.println(candle2.getMaximo());
        System.out.println(candle2.getVolume());
    }
}
