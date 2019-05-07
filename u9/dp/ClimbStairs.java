package u9.dp;

/*
 * 	走台阶问题
 */
public class ClimbStairs {
	public static int dp(int n) {
		if(n<3) return n;
		int tmp1=1,tmp2=2,res=0;
		for(int i=3;i<=n;i++) {
			res = tmp1+tmp2;
			tmp1 = tmp2;
			tmp2 = res;
			//System.out.println("res:"+res+",tmp1:"+tmp1+",tmp2:"+tmp2);
		}
		return res;
	}
	
	public static void main(String[] args) {
		for(int i=0;i<10;i++) {
			System.out.println("i:" + i +"-->:"+ ClimbStairs.dp(i));
		}
	}
}
