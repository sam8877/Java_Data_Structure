package u9.dp;

/*
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 */
public class MinimumCostForTickets {
	public static int dp(int[] days,int[] costs) {
		int len = 367;
		int[] tmp =new int[len];
		for(int j = 0;j<days.length;j++) {
			tmp[days[j]] = -1;
		}
		for(int k=0;k<len;k++)
			System.out.print(" "+tmp[k]);
		System.out.println();
		
		for(int i=0;i<len;i++) {
			if(tmp[i]==-1) {	//如果有旅行计划
				tmp[i] = min(tmp[(i+len-1)%len]+costs[0],tmp[(i+len-7)%len]+costs[1],tmp[(i+len-30)%len]+costs[2]);
			}else {			//没有旅行计划
				tmp[i] = tmp[(i+len-1)%len];
			}
			System.out.println("tmp["+i+"] = "+ tmp[i]);
		}
		return tmp[len-1];
	}
	
	public static int min(int a,int b,int c) {
		int t = a<b?a:b;
		return t<c?t:c;
	}
	
	public static void main(String[] args) {
		int res = 0;
		int[] days = {1,4,6,7,8,365};
		int[] costs = {2,7,15};
		res = MinimumCostForTickets.dp(days,costs);
		System.out.println(res);
		
	}
}
