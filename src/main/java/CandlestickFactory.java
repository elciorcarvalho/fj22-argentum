package main.java;

import java.util.ArrayList;
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
        if(negociacoes == null)
            throw new IllegalArgumentException("A lista de negociacoes nao pode ser nula.");
        double maximo = 0;
        double minimo = negociacoes.isEmpty() ? 0 : Double.MAX_VALUE; //Valor maximo para um tipo double
        double volume = 0;
        
        for(Negociacao negociacao : negociacoes){
            volume += negociacao.getVolume();
            
            if(negociacao.getPreco() > maximo)
                maximo = negociacao.getPreco();
            if(negociacao.getPreco() < minimo)
                minimo = negociacao.getPreco();
        }
        
        double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
        double fechamento = negociacoes.isEmpty() ? 0 : negociacoes.get(negociacoes.size() - 1).getPreco();
        
        return new CandleBuilder().comAbertura(abertura).comFechamento(fechamento).comMinimo(minimo)
                .comMaximo(maximo).comVolume(volume).comData(data).geraCandle();
    }

    public List<Candlestick> constroiCandles(List<Negociacao> todasNegociacoes) {
        List<Candlestick> candles = new ArrayList<Candlestick>();
        
        List<Negociacao> negociacoesDoDia = new ArrayList<Negociacao>();
        Calendar dataAtual = todasNegociacoes.get(0).getData();
        
        for(Negociacao negociacao : todasNegociacoes){
            // se não for mesmo dia, fechar candle e reiniciar variaveis
            if(!negociacao.isMesmoDia(dataAtual)){
                Candlestick candleDoDia = constroiCandleParaData(dataAtual, negociacoesDoDia);
                candles.add(candleDoDia);
                negociacoesDoDia = new ArrayList<Negociacao>();
                dataAtual = negociacao.getData();
            }
            negociacoesDoDia.add(negociacao);
        }
        // adiciona ultimo candle
        Candlestick candleDoDia = constroiCandleParaData(dataAtual, negociacoesDoDia);
        candles.add(candleDoDia);
        
        return candles;
    }
}
