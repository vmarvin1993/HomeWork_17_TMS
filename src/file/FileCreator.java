package file;

import Parser.Document;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {
    public static void writeToFile() {

        //Create new file when parsing is end.
        File outPutFile = new File(Document.getFirstname() + "_" + Document.getLastname() + "_" + Document.getTitle().replaceAll(" ", "_") + ".txt");
        try {
            if (outPutFile.createNewFile()) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(outPutFile))) {
                    bw.write(Document.getSb().toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
