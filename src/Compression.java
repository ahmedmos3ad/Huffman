import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Compression {
	
	public void Compress(String filepath) throws IOException 
	{
	    BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
	    int pointer=0;
	    char la;
	    String write;
	    la = Character.toLowerCase(Frequency.sb.charAt(pointer++));
	    while (la!='$')
	    {
	    	write=HuffmanTree.code.get(la);
	    	writer.write(write);
	    	la = Character.toLowerCase(Frequency.sb.charAt(pointer++));
	    }
	    writer.close();
	}
}
