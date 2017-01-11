import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception {
		FileReader in = new FileReader("input.txt");
		Scanner sc = new Scanner(in);
		FileWriter out = new FileWriter("output.txt");
		
		String temp;
		long salary=0;
		String[] details = new String[4];
		
		while(sc.hasNext()) {
			temp = sc.nextLine();
			details = temp.split(",");
			
			details[1] = details[1].trim();
			salary += Integer.parseInt(details[1]);
		}
		

		out.write(""+salary);
		in.close();
		out.close();
		
		//System.out.println("Done!!");
	}
}
