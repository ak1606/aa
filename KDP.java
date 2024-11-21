package daa;
import java.util.Scanner;
public class KDP {
	public static int knap(int W,int n,int[] weights,int[] values) {
		int[][] dp = new int[n+1][W+1];
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=W;j++) {
				if(i==0||j==0) {
					dp[i][j]=0;
				} else if(weights[i-1]<=j) {
					dp[i][j]=Math.max(values[i-1]+dp[i-1][j-weights[i-1]], dp[i-1][j]);
				} else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[n][W];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The capacity");
		int W = sc.nextInt();
		System.out.println("Enter The No weigths");
		int n = sc.nextInt();
		System.out.print("Enter the Wieghts values");
		int[] weights = new int[n];
		
		for(int i=0;i<n;i++) {
			weights[i]=sc.nextInt();
		}
		System.out.print("Enter the Profits values");
		int[] profits = new int[n];
		
		for(int j=0;j<n;j++) {
			profits[j]=sc.nextInt();
	    }
		System.out.print("the Wieghts values");
		for(int num:weights) {
			System.out.print(num+" ");
		}
		System.out.print("the profits values");
		for(int num:profits) {
			System.out.print(num+" ");
		}
		System.out.print("The MAX VALUE is "+knap(W,n,weights,profits));
		
	}
}
