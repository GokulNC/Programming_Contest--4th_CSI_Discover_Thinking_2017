import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;



public class Main {
	
	public static int max(int a, int b) {
		return a>b?a:b;
	}
	
	public static void main(String args[]) throws Exception {
		FileReader in = new FileReader("input.txt");
		Scanner sc = new Scanner(in);
		FileWriter out = new FileWriter("output.txt");
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		String temp;
		long salary=0;
		String[] details = new String[4];
		
		while(sc.hasNext()) {
			temp = sc.nextLine();
			details = temp.split(",");
			
			details[1] = details[1].trim();
			details[2] = details[2].trim();
			if(!map.containsKey(details[2])) map.put(details[2], Integer.parseInt(details[1]));
			else {
				map.put(details[2], max(map.get(details[2]),Integer.parseInt(details[1])));
			}
		}
		
		for(String company: map.keySet()) {
			out.write(company+" "+map.get(company)+"\n");
		}

		in.close();
		out.close();
		
		//System.out.println("Done!!");
	}
}
