package main.java;

import java.util.Calendar;

/**
 * Fluent Interface para substituir a longa chamada do contructor de Candlestick.
 * @author elcior.carvalho
 */
public class CandleBuilder {
    private double abertura;
    private double fechamento;
    private double minimo;
    private double maximo;
    private double volume;
    private Calendar data;
    
    /**
     * Setter para abertura
     * @param abertura
     * @return obj CandleBuilder
     */
    public CandleBuilder comAbertura(double abertura){
        this.abertura = abertura;
        return this;
    }
    
    /**
     * Setter para fechamento
     * @param fechamento
     * @return obj CandleBuilder
     */
    public CandleBuilder comFechamento(double fechamento){
        this.fechamento = fechamento;
        return this;
    }
    
    /**
     * Setter para minimo
     * @param minimo
     * @return obj CandleBuilder
     */
    public CandleBuilder comMinimo(double minimo){
        this.minimo = minimo;
        return this;
    }
    
    /**
     * Setter para maximo
     * @param maximo
     * @return obj CandleBuilder
     */
    public CandleBuilder comMaximo(double maximo){
        this.maximo = maximo;
        return this;
    }
    
    /**
     * Setter para volume
     * @param volume
     * @return obj CandleBuilder
     */
    public CandleBuilder comVolume(double volume){
        this.volume = volume;
        return this;
    }
    
    /**
     * Setter para data
     * @param data
     * @return obj CandleBuilder
     */
    public CandleBuilder comData(Calendar data){
        this.data = data;
        return this;
    }
    
    /**
     * Gera um Candlestick populado pelos atributos deste CandleBuilder
     * @return Obj Candlestick populado
     */
    public Candlestick geraCandle(){
        return new Candlestick(this.abertura, 
                                this.fechamento, 
                                this.minimo, 
                                this.maximo, 
                                this.volume, 
                                this.data
        );
    }
    
}
