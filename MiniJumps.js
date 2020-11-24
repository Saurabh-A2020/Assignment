/**
 * 
 */
class GFG
{
	class pair
	{
	var i;
	var s;
	var j
	var psf;
	
	function pair(i, s, j, psf)
	{
		this.i = i;
		this.s = s;
		this.j = j;
		this.psf = psf;
	}
}

function solution(arr[])
{
	Integer dp[] = new Integer[arr.length];
	dp[arr.length-1] = 0;
	var step;
	for(var i = arr.length-2;i>=0;i--)
		{
		step = arr[i];
		var min = Integer.MAX_VALUE;
		for(var j=1;j<=step &&i + j < arr.length; j++)
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
	console.log(dp[0]);
	ArrayDeque<pair> queue = new ArrayDeque<>();
	queue.add(new pair(0,arr[0], dp[0],0 +""));
	while(queue.size() > 0)
	{
		pair rem = queue.removeFirst();
		if(rem.j==0)
		{
			console.log(rem.psf);
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

function main()
{
	var arr = [];
	var size = promt();
	for(var i=0;i<size;i++)
		{
		arr[i] = prompt(i+1);
		}
}
console.log(solution(arr));
}