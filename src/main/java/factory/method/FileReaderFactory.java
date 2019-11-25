package factory.method;

import classwork.params.entity.template.Fallback;
import classwork.util.AbstractFileReader;
import classwork.util.AbstractFileWriter;
import classwork.util.json.JsonFileReader;
import classwork.util.json.JsonFileWriter;
import classwork.util.xml.XmlFileReader;
import classwork.util.xml.XmlFileWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.codehaus.jackson.map.ObjectMapper;

public class FileReaderFactory {
    protected String fileName;
    protected Fallback fallback;

    private FileReaderFactory(String fileName, Fallback fallback) {
        this.fileName = fileName;
        this.fallback = fallback;
    }

    public AbstractFileReader fileReader(String typeFile){
        switch (typeFile){
            case "json":
                return new JsonFileReader(new ObjectMapper(), fileName + typeFile);
            default:
                return new XmlFileReader(new ObjectMapper(), fileName + typeFile);
        }
    }

    public static final FileReaderFactory newFileReaderFactory(String fileName, Fallback fallback){
        return new FileReaderFactory(fileName, fallback);
    }
}
