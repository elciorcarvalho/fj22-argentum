package main.java;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.Calendar;

/**
 *
 * @author elcior.carvalho
 */
public class TestaGerarXML {
    public static void main(String[] args) {
        Negociacao negociacao = new Negociacao(42.3, 100, Calendar.getInstance());
        
        XStream stream = new XStream(new DomDriver());
        stream.alias("negociacao", Negociacao.class);
        
        System.out.println(stream.toXML(negociacao));
    }
}
