package app;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Render {
    protected String renderContent(String htmlFile) {
    	String resp;
        try {
            // If you are using maven then your files
            // will be in a folder called resources.
            // getResource() gets that folder
            // and any files you specify.
            URL url = getClass().getResource(htmlFile);
            System.out.println("URL "+url);
            // Return a String which has all
            // the contents of the file.
            Path path = Paths.get(url.toURI());
            resp = new String(Files.readAllBytes(path), Charset.defaultCharset());
            return resp;
        } catch (IOException | URISyntaxException e) {
            System.out.println(e);
            resp = "<html><head><title>Error</title></head><body>Erro...</body></html>";
        }
        return resp;
    }

}
