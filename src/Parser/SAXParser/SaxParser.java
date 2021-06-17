package Parser.SAXParser;

import Parser.Parser;
import Parser.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import java.io.*;

public class SaxParser extends DefaultHandler implements Parser {
    private StringBuilder data = new StringBuilder();
    String lastName;

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Complete");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        lastName = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String temp = new String(ch, start, length);

        if (!temp.isEmpty() && !temp.startsWith("\n")) {
            switch (lastName) {
                case "lastName" -> Document.setLastname(temp);
                case "firstName" -> Document.setFirstname(temp);
                case "nationality" -> Document.setNationality(temp);
                case "yearOfBirth" -> Document.setYearOfBirth(temp);
                case "yearOfDeath" -> Document.setYearOfDeath(temp);
                case "title" -> Document.setTitle(temp);
                case "line" -> Document.addToSb(temp.replaceAll("\n", "") + "\n");
            }
        }
    }

    public void startParsing(File file) {

        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            saxParser.parse(file, new SaxParser());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
