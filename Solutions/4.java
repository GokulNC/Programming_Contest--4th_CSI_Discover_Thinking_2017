import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class Main {
	
	
	
	public static void main(String args[]) throws Exception {
		FileReader in = new FileReader("input.txt");
		Scanner sc = new Scanner(in);
		FileWriter out = new FileWriter("output.txt");
		
		HashMap<String, Integer> CEOs = new HashMap<String, Integer>();
		HashMap<String, String> emp_map = new HashMap<String, String>(); //map all emps to a CEO, irrespective of cadre for now
		
		String temp, lastCEO="";
		String[] details = new String[3];
		
		while(sc.hasNext()) {
			temp = sc.nextLine();
			details = temp.split(",");
			
			details[0] = details[0].trim();
			details[2] = details[2].trim();
			
			if(details[2].equals("NOBODY")) {
				CEOs.put(details[0], 1);
				lastCEO = details[0];
			} else {
				String CEO = emp_map.get(details[2]);
				if(CEO==null) CEO = details[2];
				if(!emp_map.containsKey(details[0])) {
					emp_map.put(details[0], CEO);
				}
				CEOs.put(CEO, CEOs.getOrDefault(CEO, 0)+1);
			}
			
		}
		
		if(!lastCEO.isEmpty()) out.write(""+CEOs.getOrDefault(lastCEO, 0));
		
		
		sc.close();
		in.close();
		out.close();
		
		//System.out.println("Done!!");
	}
}
