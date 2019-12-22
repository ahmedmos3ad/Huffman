
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class Compression {
	StringBuilder builder=new StringBuilder();
	char cd;
	List<Integer> Binaries=new ArrayList<>();
	int loopsize;
	int EightBinaries=0;
	char x;
	StringBuilder b=new StringBuilder();
	StringBuilder bin=new StringBuilder(); 
	String BinaryShit;
	int binarypointer=0;
	int decimalValue;
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
	    writer.write("$$");
	    writer.write("\n");
	    while (la!='$')
	    {
	    	//check for space as we replaced it with capital S in the hash map
	    	if (Character.isWhitespace(la))
	    		la='S';
	    	write=HuffmanTree.code.get(la);
	    	builder.append(write);
	    	la = Character.toLowerCase(Frequency.sb.charAt(pointer++));
	    }
	    builder.append('$');
	    pointer=0;
	    la=builder.charAt(pointer++);
	    while (la!='$')
	    {
	    	if (la=='1')
	    		Binaries.add(1);
	    	else if (la=='0')
	    		Binaries.add(0);
	    	la=builder.charAt(pointer++);
	    }
	    loopsize=Binaries.size();
	    for (int i=0;i<loopsize;i++)
	    {
	    	bin.append(Binaries.get(i));
	    	EightBinaries++;
	    	if (EightBinaries==8)
	    	{
	    		BinaryShit=bin.toString();
	    		decimalValue=Integer.parseInt(BinaryShit, 2);
	    		x=(char)decimalValue;
	    		EightBinaries=0;
	    		b.append(x);
	    		//System.out.println(x);
	    		bin=new StringBuilder();
	    	}
	    }
	    pointer=0;
	    la=b.charAt(pointer++);
	    while(pointer<b.length())
	    {
	    	writer.write(la);
	    	la=b.charAt(pointer++);
	    }	    
	    writer.close();
	}
}