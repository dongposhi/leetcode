public class Solution{
    public int reverse(int x){
    	int n = 0;
    	int z = 0;
    	int y = 0;
    	do{
    		y = x%10;
    		z = x / 10;   
    		if (n * 10L + y > Integer.MAX_VALUE || n*10L + y < Integer.MIN_VALUE){
    			return -1;
    		} 		
    		n = n *10 + y;
    		x = z;
    	}while(z != 0);

    	return n;
    }


    public static void main(String[] args){
    	Solution s = new Solution();

    	int n = Integer.parseInt(args[0]);
    	System.out.println(s.reverse(n));
    }
}
