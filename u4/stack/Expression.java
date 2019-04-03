package u4.stack;

public class Expression {
	public static String toPostfix(String infix) {
		Stack<Character> stack = new SeqStack<Character>();
		StringBuffer postfix = new StringBuffer(infix.length()*2);
		int i = 0;
		while(i<infix.length()) {
			
		}
		
		return null;
	}
	
	public static int toValue(String postfix) {
		Stack<Integer> stack = new SeqStack<Integer>();
		for(int i=0; i<postfix.length();i++) {
			char ch = postfix.charAt(i);
			System.out.println("charAt("+ i +")=" + ch);
			//数字则压入栈
			if(ch>='0'||ch<='9') {
				stack.push(ch-'0');
				System.out.println(ch + "入栈" );
			}else {
				//否则取出两个数字运算，运算后的结果压入栈
				int n = stack.pop();
				int m = stack.pop();
				
				switch (ch) {
					//运算符则运算，空格跳过
					case '+':
						stack.push(m+n);
						System.out.println("计算"+n+ch+m);
						break;
					case '-':
						stack.push(m-n);
						System.out.println("计算"+n+ch+m);
						break;
					case '*':
						stack.push(m*n);
						System.out.println("计算"+n+ch+m);
						break;
					case '/':
						stack.push(m/n);
						System.out.println("计算"+n+ch+m);
						break;
	
					default:
						break;
				}
			}
			
		}
		return stack.peek();
	}
	
	public static void main(String[] args) {
		String str = "1 2 3 4 - * + 5 +";
		String str1 = "12+";
		
		System.out.println(Expression.toValue(str1));
	}
}
