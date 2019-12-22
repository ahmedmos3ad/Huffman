import java.io.IOException;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {

		String filepath;
		char ch;
		Scanner scan=new Scanner(System.in);
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
	        	   Frequency frequency=new Frequency();
	       		   frequency.getFreqencies("test.txt");
	       		   HuffmanTree tree=new HuffmanTree();
	       		   Compression compress=new Compression();
	       		   compress.Compress(filepath);
	               break;                          
	           case 2 : 
	       		   //decompress.decompress(filepath);
	               break;                                          
	           default : 
	               System.out.println("Wrong Entry \n ");
	               break;    
	           }
	           System.out.println("\nDo you want to continue (Type y or n) \n");
	           ch = scan.next().charAt(0);                        
	       } while (ch == 'Y'|| ch == 'y');               
	    }
	
	
	
	}


