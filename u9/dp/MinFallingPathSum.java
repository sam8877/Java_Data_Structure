package u9.dp;

/*
 * https://leetcode.com/problems/minimum-falling-path-sum
 */

public class MinFallingPathSum {
	
	private static int getmin(int a,int b) {
		return a<b?a:b;
	}
	private static int getmin(int a,int b, int c) {
		int temp = a<b?a:b;
		return temp<c?temp:c;
	}
	
	public static int dp(int[][] array) {
		int[][] tmp = new int[array.length][array[0].length];
		for(int m=0;m<array[0].length;m++)
			tmp[0][m] = array[0][m];
		for(int i=1;i<tmp.length;i++) {
			for(int j=0;j<tmp[i].length;j++) {//取出上一层最短的路径
				if(j==0) {
					tmp[i][j] = getmin(tmp[i-1][j],tmp[i-1][j+1])+array[i][j];
				}else if (j==array[i].length-1) {
					tmp[i][j] = getmin(tmp[i-1][j],tmp[i-1][j-1])+array[i][j];
				}else {
					tmp[i][j] = getmin(tmp[i-1][j-1],tmp[i-1][j],tmp[i-1][j+1])+array[i][j];
				}
				//System.out.print(" "+tmp[i][j]);
			}
			//System.out.println();
		}
		
		int min = Integer.MAX_VALUE;
		for(int k=0;k<tmp[tmp.length-1].length;k++) {
			if (tmp[tmp.length-1][k]<min)
				min = tmp[tmp.length-1][k];
		}
		return min;
	}
	
	public static void main(String[] args) {
		int[][] array = {{-80,-13,22},{83,94,-5},{73,-48,61}};
		System.out.println(MinFallingPathSum.dp(array));
	}
}
