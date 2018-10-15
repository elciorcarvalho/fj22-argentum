
package main.java;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author elcior.carvalho
 */
public class TestaCandlestickFactoryComUmaNegociacaoApenas {
    public static void main(String[] args) {
        Calendar hoje = Calendar.getInstance();
        
        Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
        
        List<Negociacao> negociacoes = Arrays.asList(negociacao1);
        
        CandlestickFactory fabrica = new CandlestickFactory();
        
        Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
        
        System.out.println(candle.getAbertura());
        System.out.println(candle.getFechamento());
        System.out.println(candle.getMinimo());
        System.out.println(candle.getMaximo());
        System.out.println(candle.getVolume());
    }
}
