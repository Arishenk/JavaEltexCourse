package com.arishenk;

import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlDom {

    private static ArrayList<Msg> msgs = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("src/main/resources/file.xml"));
        NodeList msgElements = document.getDocumentElement().getElementsByTagName("msgs");

        for (int i = 0; i < msgElements.getLength(); i++) {
            Node msg = msgElements.item(i);
            NamedNodeMap attributes = msg.getAttributes();
            msgs.add(new Msg(attributes.getNamedItem("to").getTextContent(),
                             attributes.getNamedItem("from").getTextContent(),
                             attributes.getNamedItem("title").getTextContent()));
        }

        for (Msg msg : msgs)
            System.out.println(msg);

    }

}