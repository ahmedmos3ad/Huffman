import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;

public class Compression {
	
	public void Compress(String filepath) throws IOException 
	{
	    BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
	    int pointer=0;
	    char la;
	    String write;
	    la = Character.toLowerCase(Frequency.sb.charAt(pointer++));
	    
	    for (Entry<Character, String> entry : HuffmanTree.code.entrySet())
		{
	    	writer.write(entry.getKey());
	    	writer.write('=');
	    	writer.write(entry.getValue());
	    	writer.write("\n");
		}
	    
	    
	    while (la!='$')
	    {
	    	//check for space as we replaced it with capital S in the hash map
	    	if (Character.isWhitespace(la))
				la='S';
	    	write=HuffmanTree.code.get(la);
	    	writer.write(write);
	    	la = Character.toLowerCase(Frequency.sb.charAt(pointer++));
	    }
	    writer.close();
	}
}
