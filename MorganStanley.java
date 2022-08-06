package programming;

public class MorganStanley {

	/**
	 * 
	 * Max and Second Max from an array
	 */
	public static void main(String[] args) {
		int nums[] = {1,2,5,3,7,6};
		int max = nums[0];
		int sec_max = max;
		for(int i : nums) {
			if(i>max) {
				sec_max = max;
				max = i;
			}else if(i>sec_max) {
				sec_max = i;
			}
			
		}

		System.out.println(max);
		System.out.println(sec_max);
	}

}
