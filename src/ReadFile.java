import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
		public StringBuilder read(String filePath) throws IOException {
			StringBuilder contentBuilder = new StringBuilder();
		    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) 
		    {
		        String sCurrentLine;
		        while ((sCurrentLine = br.readLine()) != null) 
		        {
		            contentBuilder.append(sCurrentLine).append("\n");
		        }
		    } 
		    catch (IOException e) 
		    {
		        e.printStackTrace();
		    }
		    return contentBuilder;
		}
}
