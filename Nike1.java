package programming;

public class Nike1 {

	public static void main(String[] args) {

		int[] nums = {1,1,1,1,1,1,1,1};
		int target = 11;
		int min_length = Integer.MAX_VALUE;
		
		for(int i=0; i<nums.length;i++) {
			int sum = nums[i];
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]>=target) 
					sum = nums[i];
				else 
					if(i==j) j++;
					sum = sum + nums[j];
				if(sum>=target) {
					min_length = Math.min(min_length,j-i+1);
					break;
				}
			}
			if(i==nums.length-1) {
				if(nums[i]>=target) {
					min_length=Math.min(min_length,1);
				}
			}
		}
		System.out.println(min_length==Integer.MAX_VALUE?0:min_length);
		//System.out.println(minSubArrayLen(4, nums));
	}

	/**
	 * 
	 *  target = 7, nums = [2,3,1,2,4,3]  // 6-0 
	 *  
	 *  target = 4, nums = [1,4,4]
	 *  
	 *  target = 4, nums = [4,1,1]
	 *  
	 *  target = 11, nums = [1,1,1,1,1,1,1,1]
	 * 
	 */
	public static int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = i+1;
        int length = nums.length;
        int min_size = Integer.MAX_VALUE;
        int sum = 0;
        while (i<length && j<length) {
			if(nums[i]>=target) 
				sum= nums[i];
			else 
				sum = nums[i] + nums[j];
			
			if(sum>=target) {
				int len = j-i;
				i++;
				j=i+1;
				sum = 0;
				min_size = Math.min(min_size, len);
			}else {
				j++;
			}	
		}
        return min_size==Integer.MAX_VALUE?0:min_size;
    }
}
