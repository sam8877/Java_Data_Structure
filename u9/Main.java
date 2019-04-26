package u9;

import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		HashMap<Character,Integer> map = new HashMap<Character, Integer>(8);
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		String str = "VII";
		int res = 0;
		res+=map.get(str.charAt(str.length()-1));
		int tmp1,tmp2;
		for(int i=0;i<str.length()-1;i++) {
			tmp1 = map.get(str.charAt(i));
			tmp2 = map.get(str.charAt(i+1));
			if(tmp1>=tmp2) {
				res+=tmp1;
			}else {
				res-=tmp1;
			}
		}
		System.out.println(res);
		
	}
}
