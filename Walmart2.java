package programming;

public class Walmart2 {

	public static int getMaxHops(int[] stops,int k, int dest) {
		int hops = 0;
		int i=0;
		while(i<dest-k) {     //0    // 3
			int j = i+k;
			while(j>i && stops[j]==0) {
				j--;
			}
			if(i==j) return -1;
			
			hops++;
			i=j;
		}
		
		return hops;
	}
	public static void main(String[] args) {
		int[] stops = {1,0,0,1,1,1,1,1,1};
		System.out.println(getMaxHops(stops, 3, 8));
	}

}
