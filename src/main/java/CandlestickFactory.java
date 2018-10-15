package main.java;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author elcior.carvalho
 */
public class CandlestickFactory {
    /**
     * Factory para criação de um candlestick atraves de uma lista de negociações de uma data especifica
     * @param data
     * @param negociacoes
     * @return new Candlestick
     */
    public Candlestick constroiCandleParaData(Calendar data, List<Negociacao> negociacoes){
        double maximo = 0;
        double minimo = Double.MAX_VALUE; //Valor maximo para um tipo double
        double volume = 0;
        
        for(Negociacao negociacao : negociacoes){
            volume += negociacao.getVolume();
            
            if(negociacao.getPreco() > maximo)
                maximo = negociacao.getPreco();
            else if(negociacao.getPreco() < minimo)
                minimo = negociacao.getPreco();
        }
        
        double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
        double fechamento = negociacoes.isEmpty() ? 0 : negociacoes.get(negociacoes.size() - 1).getPreco();
        
        return new CandleBuilder().comAbertura(abertura).comFechamento(fechamento).comMinimo(minimo)
                .comMaximo(maximo).comVolume(volume).comData(data).geraCandle();
    }
}
