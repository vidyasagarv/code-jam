import java.util.*;
import java.io.*;
public class Main {

	public static int countFlips(String stack){
        int numflips=0;
        
        char[] ch = stack.toCharArray();
        
        for (int i = 0; i < ch.length-1; i++) {
            if (ch[i]!=ch[i+1]){
                numflips++;
            }
        }
        if (ch[ch.length-1]== '-'){
            numflips++;
        }
        
        return numflips;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner( new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for (int i=0; i<t; ++i) {
			String stack = in.next();
			System.out.println("Case #" + i + ": " + countFlips(stack));
		}
	}
}