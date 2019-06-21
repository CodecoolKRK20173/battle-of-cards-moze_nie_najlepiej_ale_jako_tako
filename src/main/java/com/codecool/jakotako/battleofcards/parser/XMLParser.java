package com.codecool.jakotako.battleofcards.parser;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

abstract class XMLParser{
    Document document;

    public void loadXmlDocument(String xmlPath) {
        try {
            File xmlFile = new File(xmlPath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(xmlFile);
            document.getDocumentElement().normalize(); //change XML element in more human friendly way like Element foo not <foo>
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Failed read attempt");
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}

