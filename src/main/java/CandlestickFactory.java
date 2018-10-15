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
    public Candlestick constroiCandlestick(Calendar data, List<Negociacao> negociacoes){
        double maximo = negociacoes.get(0).getPreco();
        double minimo = negociacoes.get(0).getPreco();
        double volume = 0;
        
        for(Negociacao negociacao : negociacoes){
            volume += negociacao.getVolume();
            
            if(negociacao.getPreco() > maximo)
                maximo = negociacao.getPreco();
            else if(negociacao.getPreco() < minimo)
                minimo = negociacao.getPreco();
        }
        
        double abertura = negociacoes.get(0).getPreco();
        double fechamento = negociacoes.get(negociacoes.size() - 1).getPreco();
        
        return new CandleBuilder().comAbertura(abertura).comFechamento(fechamento).comMinimo(minimo)
                .comMaximo(maximo).comVolume(volume).comData(data).geraCandle();
    }
}
