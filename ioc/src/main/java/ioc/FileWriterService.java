package ioc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("fileWriterService")
@PropertySource("classpath:file.properties")
public class FileWriterService {

    @Value("${filePath}")
    private String path;
    private FileWriter fileWriter;

    @PostConstruct
    public void init() throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        fileWriter = new FileWriter(file);
    }

    public void write(String content) throws IOException {
        fileWriter.write(content);
    }

    @PreDestroy
    public void destroy() throws IOException {
        System.out.println("bean destroy");
        if (fileWriter != null) {
            fileWriter.flush();
            fileWriter.close();
        }
    }
}