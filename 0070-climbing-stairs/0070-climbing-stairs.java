class Solution {
    public int climbStairs(int steps){
			int arr[] =new int[steps];
		for(int i=0;i<steps;i++) {
			arr[i]=-1;
		}

        return count(steps,0,arr);
    }
		static int count(int n,int current,int[] arr) {
		if(current<arr.length&&arr[current]>-1) return arr[current];
		int a=0;
		if(current==n) {
			a++;
		}
		if(current+1<=n) {
			a+=count(n,current+1,arr);
		}
		if(current+2<=n) {
			a+=count(n,current+2,arr);
		}
		if(current<arr.length) {
			arr[current]=a;
		}
		return a;
	}
}