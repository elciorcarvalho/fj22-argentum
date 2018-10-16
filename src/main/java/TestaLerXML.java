/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 *
 * @author elcior.carvalho
 */
public class TestaLerXML {
    public static void main(String[] args) {
        XStream stream = new XStream(new DomDriver());
        stream.alias("negociacao", Negociacao.class);
        Negociacao n = (Negociacao) stream.fromXML("<negociacao>" + 
                                                "<preco>42.3</preco>" + 
                                                "<quantidade>100</quantidade>" +
                                            "</negociacao>");
        System.out.println(n.getPreco());
    }
}
