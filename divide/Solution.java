public class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor){
            return 1;
        }
    	boolean x = false;
		boolean flag = true;
		if(dividend < 0 ){
			flag = !flag;
			dividend = ~dividend + 1;
			if(dividend == Integer.MIN_VALUE){
				x = true;
				dividend = Integer.MAX_VALUE;
			}
		}
		
		if(divisor < 0){
			flag = !flag;
			divisor = ~divisor + 1;
		}
		if( dividend == 0 || dividend < divisor || divisor == Integer.MIN_VALUE){
			return 0;
		}
		
		
		
		int n = divisor;
		int m = 0;
		while(dividend >= n){
			if( n > n<<1){
				break;
			}
			n = n << 1;
			m++;
		}
		
		int pre = (m<1)?1:(1<<m-1);
		
		
		
		int ret = pre + divide(dividend - ((m == 0)? n:(n >> 1)) + ((x)?1:0), divisor);
		if(!flag){
			ret = ~ret + 1;
		}
		return ret;

    }
}
