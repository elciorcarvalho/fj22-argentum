/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author elcior.carvalho
 */
public class TestaCandlestickFactorySemNegociacoes {
    public static void main(String[] args) {
        Calendar hoje = Calendar.getInstance();
        
        List<Negociacao> negociacoes = Arrays.asList();
        
        CandlestickFactory fabrica = new CandlestickFactory();
        Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
        
        System.out.println(candle.getAbertura());
        System.out.println(candle.getFechamento());
        System.out.println(candle.getMinimo());
        System.out.println(candle.getMaximo());
        System.out.println(candle.getVolume());
    }
}
