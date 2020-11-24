import java.util.*;
import java.io.*;
 
class GFG { 
	public static class pair
	{
		int i;
		int s;
		int j;
		String psf;
		
		pair(int i, int s, int j, String psf)
		{
			this.i=i;
			this.s=s;
			this.j=j;
			
			this.psf = psf;
		}
	}
	public static void solution(int arr[])
	{
		Integer dp[] = new Integer[arr.length];
		dp[arr.length-1] = 0;
		int step;
		for(int i = arr.length-2;i>=0;i--)
		{
			 step = arr[i];
		
		int min = Integer.MAX_VALUE;
		for(int j=1;j<=step &&i + j < arr.length; j++)
		{
			if(dp[i+j] !=null && dp[i+j] < min)
			{
				min = dp[i+j];
			}
		}
		if(min != Integer.MAX_VALUE)
		{
			dp[i] = min + 1;
		}
		}
		System.out.println(dp[0]);
		ArrayDeque<pair> queue = new ArrayDeque<>();
		queue.add(new pair(0,arr[0], dp[0],0 +""));
		
		while(queue.size() > 0)
		{
			pair rem = queue.removeFirst();
			if(rem.j==0)
			{
				System.out.println(rem.psf);
			}
			for(int j=1;j<rem.s && rem.i + j< arr.length;j++)
			{
				int ci = rem.i + j;
				if(dp[ci] !=null && dp[ci] == rem.j-1)
				{
					queue.add(new pair(ci, arr[ci], dp[ci], rem.psf + " -> "+ ci));
				}
			}
		}
	}
	
	
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		solution(arr);
		sc.close();
	}
	
	
	
	
	
	
}
