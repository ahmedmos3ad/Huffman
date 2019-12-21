import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Frequency frequency=new Frequency();
		frequency.getFreqencies("test.txt");
		HuffmanTree tree=new HuffmanTree();
		Compression compress=new Compression();
		compress.Compress("test.txt");
		
	
	
	
	}
}

