package com.arishenk;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XmlSax {
    private static ArrayList<Msg> msgs = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLHandler handler = new XMLHandler();
        parser.parse(new File("src/main/resources/file.xml"), handler);

        for (Msg msg : msgs)
            System.out.println(msg.getTitle());
    }

    private static class XMLHandler extends DefaultHandler {

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("msg")) {
            String to = attributes.getValue("to");
            String from = attributes.getValue("from");
            String title = attributes.getValue("title");
            msgs.add(new Msg(to, from, title));
        }
    }
    }
}
