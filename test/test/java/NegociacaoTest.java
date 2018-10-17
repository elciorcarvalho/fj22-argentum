package test.java;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Calendar;
import java.util.GregorianCalendar;
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
    
    // Inicio TDD
    @Test
    public void mesmoMilissegundoEhDoMesmoDia(){
        Calendar agora = Calendar.getInstance();
        Calendar mesmoMomento = (Calendar) agora.clone();
        
        Negociacao negocio = new Negociacao(40.0, 100, agora);
        assertTrue(negocio.isMesmoDia(mesmoMomento));
    }
    
    @Test
    public void comHorariosDiferentesEhNoMesmoDia(){
        // usando GregorianCalendar(ano, mes, dia, gira, minuto)
        Calendar manha = new GregorianCalendar(2018, 10, 17, 9, 20);
        Calendar tarde = new GregorianCalendar(2018, 10, 17, 16, 4);
        
        Negociacao negociacao = new Negociacao(40.0, 100, manha);
        assertTrue(negociacao.isMesmoDia(tarde));
    }
    
    @Test
    public void mesmoDiaMasMesesDiferentesNaoSaoDoMesmoDia(){
        // usando GregorianCalendar(ano, mes, dia, gira, minuto)
        Calendar esteDiaEsteMes = new GregorianCalendar(2018, 10, 17, 9, 20);
        Calendar esteDiaMesPassado = new GregorianCalendar(2018, 9, 17, 16, 4);
        
        Negociacao negociacao = new Negociacao(40.0, 100, esteDiaEsteMes);
        assertFalse(negociacao.isMesmoDia(esteDiaMesPassado));
    }
    
    @Test
    public void mesmoDiaEMesMasAnosDiferentesNaoSaoDoMesmoDia(){
        // usando GregorianCalendar(ano, mes, dia, gira, minuto)
        Calendar esteDiaEsteAno = new GregorianCalendar(2018, 10, 17, 9, 20);
        Calendar esteDiaOutroAno = new GregorianCalendar(2008, 10, 17, 16, 4);
        
        Negociacao negociacao = new Negociacao(40.0, 100, esteDiaEsteAno);
        assertFalse(negociacao.isMesmoDia(esteDiaOutroAno));
    }
}
