package programming;


public class walmart {

	
	public static void main(String[] args) {
		int[] arr = {0,0,0,1,1,1};
		
		for(int i =0; i<arr.length;i++) {
			
			if(i%2!=0) arr[i]=0;
			
			else arr[i]=1;
		}
		
		for(int i : arr) {
			System.out.print(arr[i]+" ");
		}
		
	}
}
