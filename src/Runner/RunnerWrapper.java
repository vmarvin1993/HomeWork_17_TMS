package Runner;

import Parser.DOMparser.DomParser;
import Parser.Parser;
import Parser.SAXParser.SaxParser;
import file.FileCreator;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static file.CheckDir.*;

public class RunnerWrapper {
    static Scanner input;

    public static void main(String[] args) throws FileNotFoundException {
        input = new Scanner(System.in);

        System.out.print("Chose directory: ");
        String temp = input.nextLine();

        checkDirectory(temp);

        System.out.println("Chose method parsing");
        System.out.println("1 - Dom parser");
        System.out.println("2 - Sax parser");
        int in = input.nextInt();

        Parser parser = null;
        if (in == 1) {
            parser = new DomParser();
        } else if (in == 2) {
            parser = new SaxParser();
        }

        parser.startParsing(getXml());
        FileCreator.writeToFile();


    }
}
