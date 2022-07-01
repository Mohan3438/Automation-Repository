package testing;

import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name = "xcxxxxyyyxxxzzz";
//		xcyyyxzzz
		
		Set<Character> set = new HashSet<Character>();
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<name.length(); i++) {
			
			Character ch = name.charAt(i);
			
			if(!set.contains(ch)) {
				set.add(ch);
				sb.append(ch);
			}
		}
     System.out.println(sb); 
		
		

	}

}
