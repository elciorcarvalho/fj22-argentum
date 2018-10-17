package main.java;

import java.util.Calendar;

/**
 *
 * @author elcior.carvalho
 */

public final class Negociacao implements Cloneable {
    private final double preco;
    private final int quantidade;
    private final Calendar data;

    /**
     * Constructor para Negociacao
     * @param preco
     * @param quantidade
     * @param data 
     */
    public Negociacao(double preco, int quantidade, Calendar data) {
        if(data == null)
            throw new IllegalArgumentException("A data não pode ser nula.");
        this.preco = preco;
        this.quantidade = quantidade;
        this.data = data;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Calendar getData() {        
        return (Calendar) this.data.clone();
        /* 
        Eh o mesmo que fazer:
            Calendar copia = Calendar.getInstance();
            copiar.setTimeInMillis(this.data.getTimeInMillis);
            return copia
        */
    }
    
    /**
     * Volume de dinheiro transferido pela negociação.
     * @return preco * quantidade
     */
    public double getVolume(){
        return preco * quantidade;
    }
    
    /**
     * Verifica se dois dias sao a mesma data
     * @param outraData
     * @return true se forem o mesmo dia, senao, false
     */
    public boolean isMesmoDia(Calendar outraData){
        return data.get(Calendar.DAY_OF_MONTH) == outraData.get(Calendar.DAY_OF_MONTH)
                && data.get(Calendar.MONTH) == outraData.get(Calendar.MONTH)
                && data.get(Calendar.YEAR) == outraData.get(Calendar.YEAR);
    }
}
