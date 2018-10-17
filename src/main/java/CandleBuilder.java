package main.java;

import java.util.Calendar;

/**
 * Fluent Interface para substituir a longa chamada do contructor de Candlestick.
 * @author elcior.carvalho
 */
public class CandleBuilder {
    private double abertura = 0;
    private double fechamento = 0;
    private double minimo = 0;
    private double maximo = 0;
    private double volume = 0;
    private Calendar data = null;
    private boolean attrNulo = true;
    
    private boolean verificarAtributo(double attr){
        if(attr == 0)
            return true;
        else
            return false;
    }
    
    private boolean verificarAtributo(Calendar attr){
        if(attr == null)
            return true;
        else
            return false;
    }
    
    /**
     * Setter para abertura
     * @param abertura
     * @return obj CandleBuilder
     */
    public CandleBuilder comAbertura(double abertura){
        this.attrNulo = verificarAtributo(abertura);
        this.abertura = abertura;
        return this;
    }
    
    /**
     * Setter para fechamento
     * @param fechamento
     * @return obj CandleBuilder
     */
    public CandleBuilder comFechamento(double fechamento){
        this.attrNulo = verificarAtributo(fechamento);
        this.fechamento = fechamento;
        return this;
    }
    
    /**
     * Setter para minimo
     * @param minimo
     * @return obj CandleBuilder
     */
    public CandleBuilder comMinimo(double minimo){
        this.attrNulo = verificarAtributo(minimo);
        this.minimo = minimo;
        return this;
    }
    
    /**
     * Setter para maximo
     * @param maximo
     * @return obj CandleBuilder
     */
    public CandleBuilder comMaximo(double maximo){
        this.attrNulo = verificarAtributo(maximo);
        this.maximo = maximo;
        return this;
    }
    
    /**
     * Setter para volume
     * @param volume
     * @return obj CandleBuilder
     */
    public CandleBuilder comVolume(double volume){
        this.attrNulo = verificarAtributo(volume);
        this.volume = volume;
        return this;
    }
    
    /**
     * Setter para data
     * @param data
     * @return obj CandleBuilder
     */
    public CandleBuilder comData(Calendar data){
        this.attrNulo = verificarAtributo(data);
        this.data = data;
        return this;
    }
    
    /**
     * Gera um Candlestick populado pelos atributos deste CandleBuilder
     * @return Obj Candlestick populado
     */
    public Candlestick geraCandle(){
        if(this.attrNulo == true)
            throw new IllegalStateException("Algum atributo do builder encontra-se vazio.");
        return new Candlestick(this.abertura, 
                                this.fechamento, 
                                this.minimo, 
                                this.maximo, 
                                this.volume, 
                                this.data
        );
    }
    
}
