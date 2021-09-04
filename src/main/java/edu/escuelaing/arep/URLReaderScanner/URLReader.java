package edu.escuelaing.arep.URLReaderScanner;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class URLReader {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL(args[0]);
        FileWriter file = null;
        PrintWriter pw;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String inputLine;
            file = new FileWriter("resultado.html");
            pw = new PrintWriter(file);
            while ((inputLine = reader.readLine()) != null) {
                pw.println(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x.getMessage());
        } finally {
            try {
                if(null != file){
                    file.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
