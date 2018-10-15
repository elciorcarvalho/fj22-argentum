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

    public Candlestick(double abertura, double fechamento, double minimo, double maximo, double volume, Calendar data) {
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
        return this.abertura < this.fechamento;
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
