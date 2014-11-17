public class Solution {
    public static void main(String[] args){
    	Solution s = new Solution();

    	int[] nums = new int[]{2,6,7,11};
    	int[] ret = s.twoSum(nums,9);

    	System.out.println("result is : " + ret[0] + ", " + ret[1]);
    }

	public int[] twoSum(int[] numbers, int target) {

		int[] ret = new int[]{-1,-1};
		int[] left = new int[numbers.length];
        for ( int i = 1;i<numbers.length;i++){
        	left[i-1] = numbers[i-1];
        	for(int j =0;j<i;j++){
        		if(numbers[i] + numbers[j] == target){
        			ret[0] = j + 1;
        			ret[1] = i + 1;
        			return ret;
        		}
        	}
        }
        return ret;
	}
}
