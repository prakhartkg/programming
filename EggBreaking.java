package programming;

public class EggBreaking {

	public static int eggDrop(int n, int k) {
		
		if(k==1 || k==0) return k;
		if(n==1) return k;
		int min = Integer.MAX_VALUE;
		int res;
		for(int x=1;x<=k;x++) {
			res = Math.max(eggDrop(n-1, x-1),eggDrop(n,k-x));
			if(res<min) {
				min=res;
			}
		}
		
		return 1+min;
	}
	public static void main(String[] args) {
		System.out.print(eggDrop(2,100));
	}

}
