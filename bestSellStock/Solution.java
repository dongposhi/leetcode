public class Solution{
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length <=1){
			return 0;
		}        
		int ret = 0;

		int max = prices[0];
		int pre = 0;
		int min = prices[0];
		
		int maxpos = 0;		
		int preRet = 0;

		int trend = 1; // 0:down, 1:up
		for (int i = 0; i <= prices.length; i++) {
			int cur = 0;
			if (i != prices.length) {
				cur = prices[i];
			}

			if (pre > cur) {
				if (trend == 1) {// touch the top
					// end last cycle
					if (max <= pre) {//出现新的高点
						max = pre;
						maxpos = i -1;
						
						ret = max - min;
					}
					ret = Math.max(preRet, ret);
				}
				trend = 0;
			} else if (pre == cur) {
			} else {// pre < cur
				if(trend ==0){//touch the bottom
					if(min >= pre){//出现新的低点						
						if(i-1 > maxpos){//新的低点在最高点之后，要开始重新统计了。preRet = max - min
							preRet = ret;
						}
						min = pre;
						max = min;
					}
				}
				trend = 1;
			}			
			pre = cur;
		}

		return ret;
	}
    

}
