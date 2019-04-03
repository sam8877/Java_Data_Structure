package u4.stack;

public class Bracket {
	//括号匹配
	public static String isMached(String infix) {
		Stack<Character> stack = new SeqStack<Character>(infix.length());
		for(int i=0;i<infix.length();i++) {
			if( infix.charAt(i)=='(' ) {
				System.out.println("入栈--" + i);
				stack.push('(');
			}
			if( infix.charAt(i)==')' ) {
				System.out.println("出栈--" + i);
				if(stack.pop()==null)
					return "期待 \'(\'";
			}
		}
		if(stack.isEmpty()) {
			return "括号匹配";
		}else {
			return "期待 \')\' ";
		}
		
	}
	
	public static void main(String[] args) {
		String str = "(1+2)*(3+4)";
		System.out.println(Bracket.isMached(str));
		
	}
	
}
