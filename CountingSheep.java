import java.util.*;
import java.io.*;
public class CountingSheep {
	private static Scanner sc;
	private static PrintWriter out;
	public static boolean SUBMIT = false;
  	public static final String NAME = "A-small-attempt0";

	public static void main(String[] args) {
		// if (SUBMIT) {
		// 	sc = new Scanner(new File(NAME + ".in"));
		// 	out = new PrintWriter(new BufferedWriter(new FileWriter(NAME + ".out")));
		// } else {
		// 	sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		// 	out = new PrintWriter(System.out, true);
		// }
		sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));	
		int t = sc.nextInt();
		for (int i=0; i<t; ++i) {
			int number = in.nextInt();
			int[] found = new int[10];
			String default = "INSOMNIA";
			int last = 0;
			boolean sleepNow = false;
			while(sleepNow){
				int next = last + number;
				last = next;
				while(next>0){
					found[next%10] = 1;
					next = next/10;
				}
				sleepNow = true;
				for (int j=0; j< 10; ++j) {
					if(!found[j]){
						sleepNow = false;
						break;
					}
				}
			}
			if(last == 0)
				System.out.println("Case #" + i + ": " + default);
			else
				System.out.println("Case #" + i + ": " + last);
		}
	}
}