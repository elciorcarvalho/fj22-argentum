package test.java;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Calendar;
import main.java.Negociacao;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author elcior.carvalho
 */
public class NegociacaoTest {
    
    @Test
    public void dataDaNegociacaoEhImutavel(){
        // Criamos uma negociacao dia 15
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, 15);
        Negociacao n = new Negociacao(10, 5, c);
        
        // Tentar mudar data para dia 20
        n.getData().set(Calendar.DAY_OF_MONTH, 20);
        
        // Data deverá continuar dia 15. Objeto deve ser imutavel
        assertEquals(15, n.getData().get(Calendar.DAY_OF_MONTH));
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void naoCriaNegociacaoComDataNula(){
        new Negociacao(10, 5, null);
    }
}
