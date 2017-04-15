import java.util.*;
import java.io.*;
public class CountingSheep {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));	
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