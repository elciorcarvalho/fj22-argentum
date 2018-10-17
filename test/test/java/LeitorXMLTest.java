package test.java;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import main.java.Negociacao;
import static org.junit.Assert.*;
import org.junit.Test;
import reader.LeitorXML;

/**
 *
 * @author elcior.carvalho
 */

public class LeitorXMLTest {
    
    @Test
    public void carregarxmlComUmaNegociacaoEmListaUnitaria(){
        String xmlDeTeste = "<list>" +
                                "<negociacao>" +
                                    "<preco>43.5</preco>" +
                                    "<quantidade>1000</quantidade>" +
                                    "<data>" +
                                        "<time>1322233344455</time>" +
                                    "</data>" +
                                "</negociacao>" +
                            "</list>";

        LeitorXML leitor = new LeitorXML();

        InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());

        List<Negociacao> negociacoes = leitor.carrega(xml);
        
        assertEquals(1, negociacoes.size());
    }

}
