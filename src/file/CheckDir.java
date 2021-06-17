package file;

import java.io.*;
import java.util.*;

public class CheckDir {

    public static File getFileXml;

    public static void checkDirectory(String path) throws FileNotFoundException {

        //Check directory
        File file = new File(path);
        while (file.isDirectory()) {
            Optional<File[]> temp = Optional.ofNullable(file.listFiles());
            if (temp.get().length == 0) {
                throw new FileNotFoundException("Files not found");
            } else {
                if (temp.get().length > 1) {
                    throw new FileNotFoundException("Find 1 more files");
                } else {
                    file = temp.get()[0];
                }
            }
        }
        if (file.getName().endsWith(".xml")) {
            getFileXml = file;
        } else {
            throw new FileNotFoundException("Xml not found");
        }
    }

    public static File getXml() {
        return getFileXml;
    }

}
