import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Decompression {
	private InputStream input;
	private int nextBits; //used to read bits from file
	private int numofBitsRemaining=0; //Always between 0 and 7 as BYTE is 8 bits
	private boolean EOF=false;
	String [] split;
	StringBuilder sb=new StringBuilder();
	int pointer=0;
	char la;
	Map<String,String> decode=new HashMap<>();
	public void read(String filepath) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader(filepath));
		input = new BufferedInputStream(new FileInputStream(filepath));
		String line;
        // read line
       /* line = br.readLine();
        //check if it is a comment line
        while (line.charAt(0) >= 'a' && line.charAt(0) <= 'z')
        {
        	decode.put(line.substring(0,1),line.substring(2));
        	System.out.println("a7a");
        	line = br.readLine();
        }
        br.close();*/
	while(!EOF)
	{
		if (EOF)
			break;
		if (numofBitsRemaining == 0) {
			nextBits = input.read();
			if (nextBits == -1) {
				EOF = true;
				break;
			}
			//reset to 1 byte
			numofBitsRemaining = 8;
		}
		numofBitsRemaining--;
		//logical shift right the bits we read with number of bits remaining
		//we shift to get the right most bit and compare it to 1 to return 1 or 0
		//System.out.println((nextBits >>> numofBitsRemaining) & 1);
		sb.append((nextBits >>> numofBitsRemaining) & 1);
	}
  sb.append('$');
	}
	public void decompress(String filepath) throws IOException
	{
	read(filepath);
	BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
	la = sb.charAt(pointer++);
	while (la!='$')
	  {
		writer.write(la);
		la = sb.charAt(pointer++);
	  }
	writer.close();
	}
}
