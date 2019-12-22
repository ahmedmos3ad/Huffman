
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Decompression {

	String [] split;
	StringBuilder sb=new StringBuilder();
	StringBuilder weirdChars=new StringBuilder();
	StringBuilder Decompressed=new StringBuilder();
	int pointer=0;
	char la;
	int number;
	String BinaryNo;
	String Binaries;
	int j=1;
	int iterator;
	Map<String,String> decode=new HashMap<>();
	public void read(String filepath) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader(filepath));
		String line;
		boolean found=false;
        // read line
       line = br.readLine();
        //check if it is a comment line
        while (line.charAt(0) >= 'a' && line.charAt(0) <= 'z' || line.charAt(0) >= 'A' && line.charAt(0) <= 'Z')
        {
        	decode.put(line.substring(0,1),line.substring(2));
        	line = br.readLine();
        }
        line=br.readLine();
        while (line!=null)
        {
        weirdChars.append(line);
        line=br.readLine();
        }
        br.close();
        weirdChars.append('$');
    	pointer=0;
    	la=weirdChars.charAt(pointer++);
    	while (la!='$')
    	{
    		number=(int)la;
    		BinaryNo=Integer.toBinaryString(number);
    		while (BinaryNo.length()<8)
    			 BinaryNo = '0' + BinaryNo;
    		sb.append(BinaryNo);
    		la=weirdChars.charAt(pointer++);
    	}
    	String print=sb.toString();
    	System.out.println(print);
    	for (int i=0;i<sb.length();i++)
    	{
    		for (j=i+1;j<sb.length();i++)
    		{
    			found=false;
    			Binaries=sb.substring(i,j);
    				for (Map.Entry<String,String> entry : decode.entrySet()) {
    					if (entry.getValue().equals(Binaries)) 
    					 {
    						Decompressed.append(entry.getKey());
    						i=j;
    						j=i+1;
    						System.out.println("found\n");
    						found=true;
    						break;
    					 }
    			}
    		if (found=true)
    			break;
    		}	
	 }
	Decompressed.append('$');
	}	
	public void decompress(String filepath) throws IOException
	{
	read(filepath);
	BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
	pointer=0;
	la = Decompressed.charAt(pointer++);
	while (la!='$')
	  {
		writer.write(la);
		la = Decompressed.charAt(pointer++);
	  }
	writer.close();
	}
}
