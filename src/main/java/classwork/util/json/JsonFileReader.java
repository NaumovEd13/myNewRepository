package classwork.util.json;

import classwork.util.AbstractFileReader;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class JsonFileReader extends AbstractFileReader implements Serializable {
	
	public JsonFileReader(ObjectMapper mapper, String fileName) {
		super(mapper, fileName);
	}
	
	@Override
	public void readFile()  {

		try {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
			Object obj=inputStream.readObject();
		}
		catch (Exception e){
			e.getMessage();
		}
	}
}
