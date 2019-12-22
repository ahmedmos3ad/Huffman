
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {

		String filepath;
		char ch;
		Scanner scan=new Scanner(System.in);
		double presize;
		double postsize;
		double CompressionRatio;
		System.out.println("Please Enter the file you Want to Compress/Decompress");
		do    
	       {
	           System.out.println("\nHuffman Compression and Decompression\n");
	           System.out.println("1. Compress ");
	           System.out.println("2. Decompress");
	           
	           int choice = scan.nextInt();            
	           switch (choice)
	           {
	           case 1 : 
	        	   System.out.println("Please Enter the file you Want to Compress\n");
	        	   filepath=scan.next();
	        	   File file=new File(filepath);
	        	   presize=(double) file.length()/1024;
	        	   Frequency frequency=new Frequency();
	       		   frequency.getFreqencies(filepath);
	       		   HuffmanTree tree=new HuffmanTree();
	       		   Compression compress=new Compression();
	       		   compress.Compress(filepath);
	       		   postsize=(double) file.length()/1024;
	       		   CompressionRatio=postsize/presize *100;
	       		   System.out.println("Compression Ratio Equals "+(int)CompressionRatio +"%");
	               break;                          
	           case 2 : 
	       		   Decompression decompress=new Decompression();
	       		   System.out.println("Please Enter the file you Want to Deompress\n");
	        	   filepath=scan.next();
	        	   decompress.decompress(filepath);
	               break;                                          
	           default : 
	               System.out.println("Wrong Entry \n ");
	               break;    
	           }
	           System.out.println("\nDo you want to continue (Type y or n) \n");
	           ch = scan.next().charAt(0);                        
	       } while (ch == 'Y'|| ch == 'y');               
	scan.close();    
	}
}


