
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map.Entry;

public class Compression {
	StringBuilder builder=new StringBuilder();
	char cd;
	int pointer2=0;
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
	    	builder.append(write);
	    	la = Character.toLowerCase(Frequency.sb.charAt(pointer++));
	    }
	    builder.append('$');
	    writer.close();
	    bitStream(filepath);
	}
	
	public void bitStream(String filepath) throws IOException
	{
	BufferedWriter writer = new BufferedWriter(new FileWriter("Testing.txt"));
	int currentByte=0;
	int numOfBitsInCurrentByte=0;
	int byte1;
	cd=builder.charAt(pointer2++);
	File file=new File("Testing.txt");
	OutputStream output = new BufferedOutputStream(new FileOutputStream(file));
	for (Entry<Character, String> entry : HuffmanTree.code.entrySet())
	{
    	writer.write(entry.getKey());
    	writer.write('=');
    	writer.write(entry.getValue());
    	writer.write("\n");
	}
	writer.write("$$\n");
	while (cd!='$')
	{
		if (cd=='1')
			byte1=1;
		else byte1=0;
		currentByte = currentByte >> 1|byte1;
		//System.out.println(currentByte);
		numOfBitsInCurrentByte++;
		if (numOfBitsInCurrentByte==8) {
			output.write(currentByte);
		    numOfBitsInCurrentByte = 0;
		}
		cd=builder.charAt(pointer2++);
	}
	output.close();
	writer.close();
	}
}