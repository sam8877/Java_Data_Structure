package u3;

import java.util.Arrays;

public class MyString {
	
	private final char[] value;
	
	public MyString() {
		this.value = new char[0];
	}
	public MyString(String str) {
		this.value = new char[str.length()];
		for(int i = 0; i < this.length(); i++)
			this.value[i] = str.charAt(i);
	}
	public MyString(char[] value, int i, int n) {
		if(i>=0 && n>=0 && i+n <=value.length) {
			this.value = new char[n];
			for(int j=0; j<n; j++)
				this.value[i] = value[i+j];
		}else
			throw new StringIndexOutOfBoundsException();
	}
	public MyString(char[] value) {
		this(value, 0, value.length);
	}
	public MyString(MyString str) {
		this(str.value);
	}
	
	public int length() {
		return this.value.length;
	}
	public char charAt(int i) {
		if(i>=0&&i<this.length()) {
			return this.value[i];
		}else
			throw new StringIndexOutOfBoundsException();
	}
	@Override
	public String toString() {
		return "MyString [value=" + Arrays.toString(value) + "]";
	}
	
	public int indexOf(MyString pattern) {
		return this.indexOf(pattern, 0);
	}
	
	public int indexOf(MyString pattern, int begin) {
		
		//容错处理
		int n = this.length();
		int m = pattern.length();
		if (begin<0) begin = 0;
		if (n==0||n<m||begin>n) return -1;
		
		//i为被匹配的字符串下标，j为匹配字符串下标
		int i = begin,j=0;
		while(i<n && j<m) {
			if (this.charAt(i)==pattern.charAt(j)) {
				i++;j++;//相同则将下标向后拨
			}else {
				i=i-j+1;//不相同则将i拨到下次匹配的地方
				j=0;
				if (i>n-m) break; //长度不够则不再处理
			}
			if (j==m) return i-j;
		}
		
		return -1;
	}
	
	
}
