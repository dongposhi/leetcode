public class Solution {
    /**
     * 本题的思路是从左到右走一遍，再从右到左走一遍
     * 每一遍都挑选出后边更高的峡谷来计算填水量（这样好计算）。
     * 其中一遍计算后边等高的情况即可。
     *
     * 每一遍都要保证下一个峡谷的右侧比本峡谷的右侧更高。这样就把一些中间的小突起搞定了。不用费心去计算了。
     *
     * /
    public int trap(int[] A) {
    		return trapA(A,true) + trapA(A,false);
	}
	public  int trapA(int[] A, boolean flag){
		int ret = 0;
		
		int left = 0;
		int pre = 0;

		int trend = 1; // 0:down, 1:up
		int total = 0;
		for (int i = 0; i <= A.length; i++) {			
			int cur = 0;
			if(i != A.length){
				cur = flag?A[i]:A[A.length-i-1];
			}

			if (pre > cur) {
				if (trend == 1) {//touch the top
					// end last cycle
					if(left<pre || (left == pre && flag)){
						ret = ret + total; // add last cycle to final result.
						total = 0;
					}
					//start new cycle
					if(pre>left || (pre== left && flag))
					    left = pre;
				} 
				trend = 0;
			} else if (pre == cur) {
			} else {// pre < cur
				trend = 1;
			}
			total = total + ((left - cur) > 0?left-cur:0);
			pre = cur;
		}

		return ret;
	}
}
