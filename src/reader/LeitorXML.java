package reader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.InputStream;
import java.util.List;
import main.java.Negociacao;

/**
 * Responsavel pela leitura dos XML
 * @author elcior.carvalho
 */
public class LeitorXML {
    public List<Negociacao> carrega(InputStream inputStream){
        XStream stream = new XStream(new DomDriver());
        stream.alias("negociacao", Negociacao.class);
        return (List<Negociacao>) stream.fromXML(inputStream);
    }
}
