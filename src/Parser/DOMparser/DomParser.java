package Parser.DOMparser;

import Parser.Parser;
import Parser.Document;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

public class DomParser implements Parser {
    @Override
    public void startParsing(File file) {

        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            org.w3c.dom.Document document = db.parse(file);
            document.getDocumentElement();

            NodeList nl = document.getElementsByTagName("firstName");
            Node node = nl.item(0);
            Element e = (Element) node;
            Document.setFirstname(e.getTextContent());

            nl = document.getElementsByTagName("lastName");
            node = nl.item(0);
            e = (Element) node;
            Document.setLastname(e.getTextContent());

            nl = document.getElementsByTagName("yearOfBirth");
            node = nl.item(0);
            e = (Element) node;
            Document.setYearOfBirth(e.getTextContent());

            nl = document.getElementsByTagName("yearOfDeath");
            node = nl.item(0);
            e = (Element) node;
            Document.setYearOfDeath(e.getTextContent());

            nl = document.getElementsByTagName("title");
            node = nl.item(0);
            e = (Element) node;
            Document.setTitle(e.getTextContent());

            nl = document.getElementsByTagName("line");
            for (int i = 0; i < nl.getLength(); i++) {
                node = nl.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    e = (Element) node;
                    Document.addToSb(e.getTextContent().replaceAll("\n", "") + "\n");

                }
            }
            System.out.println("Complete");

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
