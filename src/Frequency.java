import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Frequency {
	static Map<Character,Integer> Frequencies=new HashMap<>();
	static StringBuilder sb=new StringBuilder();
	ReadFile read=new ReadFile();
	int pointer=0;
	int count;
	char la;
	public void getFreqencies(String filePath)
	{
		try {
			sb=read.read(filePath);
		} catch (IOException e) {
			System.out.println("Error reading file");
			e.printStackTrace();
		}
		sb.append('$');
		la = Character.toLowerCase(sb.charAt(pointer++));
		while (la!='$')
		{
			count = Frequencies.containsKey(la) ? Frequencies.get(la) : 0;
			Frequencies.put(la, count + 1);
			System.out.println(la+""+(count+1)+"\n");
			la = Character.toLowerCase(sb.charAt(pointer++));
		}
	}
	public static int getMapSize()
	{
		return Frequencies.size();
	}
}
