public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        long m = 1L *x ;
        long y = 0;
        while ( m > 0){
            y = y*10 + m%10;
            m = m/10;
        }

        return x == y;
    }

    public static void main(String[] args){

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    	int x = Integer.parseInt(args[0]);
    	Solution s = new Solution();

    	System.out.println(s.isPalindrome(x));
    }
}
