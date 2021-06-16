import Parser.DOMparser.DomParser;
import Parser.Parser;
import Parser.SAXParser.*;
import fileCreate.FileCreator;
import java.io.*;
import java.util.*;

public class Runner {

    public static File getFileXml;
    static Scanner input;

    public static void checkDir(String path) throws FileNotFoundException {
        //Check directory
        File file = new File(path);
        while (file.isDirectory()){
            Optional<File[]> temp = Optional.ofNullable(file.listFiles());
            if(temp.get().length==0) {
                throw new FileNotFoundException("Files not found");
            } else {
                if(temp.get().length>1){
                    throw new FileNotFoundException("Find 1 more files");
                } else {
                    file = temp.get()[0];
                }
            }
        }
        if(file.getName().endsWith(".xml")) {
            getFileXml = file;
        }
        else {
            throw new FileNotFoundException("Xml not found");
        }
    }

    public static void selectParser(){
        //Chose parser
        input = new Scanner(System.in);
        System.out.println("Chose method parsing");
        System.out.println("1 - Dom parser");
        System.out.println("2 - Sax parser");
        int in = input.nextInt();

        Parser parser;
        if(in == 1) {
            parser = new DomParser();
        } else {
            parser = new SaxParser();
        }

        parser.startParsing(getXml());

    }

    public static File getXml(){
        return getFileXml;
    }
    public static void main(String[] args) throws FileNotFoundException {

        input = new Scanner(System.in);
        System.out.print("Chose directory: ");
        String temp = input.nextLine();

        checkDir(temp);
        selectParser();
        FileCreator.writer();

    }
}
