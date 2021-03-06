package main.java;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author elcior.carvalho
 */
public final class Candlestick {
    private final double abertura;
    private final double fechamento;
    private final double minimo;
    private final double maximo;
    private final double volume;
    private final Calendar data;

    /**
     * Constructor para Candlestick
     * @param abertura
     * @param fechamento
     * @param minimo
     * @param maximo
     * @param volume
     * @param data 
     */
    public Candlestick(double abertura, double fechamento, double minimo, double maximo, double volume, Calendar data) {
        if(minimo > maximo)
            throw new IllegalArgumentException("Nao é permitido preco minimo maior que preco maximo.");
        if(data == null)
            throw new IllegalArgumentException("Não é permitido um candle de data nula.");
        if(abertura < 0 || fechamento < 0 || minimo < 0 || maximo < 0 || volume < 0)
            throw new IllegalArgumentException("Não é permitido passar valores negativos.");
        this.abertura = abertura;
        this.fechamento = fechamento;
        this.minimo = minimo;
        this.maximo = maximo;
        this.volume = volume;
        this.data = data;
    }

    public double getAbertura() {
        return abertura;
    }

    public double getFechamento() {
        return fechamento;
    }

    public double getMinimo() {
        return minimo;
    }

    public double getMaximo() {
        return maximo;
    }

    public double getVolume() {
        return volume;
    }

    public Calendar getData() {
        return data;
    }
    
    /**
     * Verifica se o Candlestick é de alta
     * @return Se abertura menor que fechamento True, senão, False
     */
    public boolean isAlta(){
        return this.abertura <= this.fechamento;
    }
    
    /**
     * Verifica se o Candlestick é de baixa
     * @return Se abertura maior que fechamento True, senão, False
     */
    public boolean isBaixa(){
        return this.abertura > this.fechamento;
    }

    @Override
    public String toString() {
        //Cria o padrão SimpleDateFormat para a data.
        SimpleDateFormat dataNatural = new SimpleDateFormat("dd/MM/yyyy");
        return "Abertura " + this.abertura + ", Fechamento " + this.fechamento + ", Mínimo " + this.minimo
                + ", Máximo " + this.maximo + ", Volume " + this.volume + ", Data " + dataNatural.format(this.data.getTime());
    }
    
}
