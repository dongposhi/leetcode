public class Solution{
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length <=1){
			return 0;
		}
		int pre = 0;
		int min = prices[0];
		
		int total = 0;
		int trend = 1; // 0:down, 1:up
		for (int i = 0; i <= prices.length; i++) {
			int cur = 0;
			if (i != prices.length) {
				cur = prices[i];
			}

			if (pre > cur) {
				if (trend == 1) {// touch the top
					total = total + pre - min;
					min = pre;
				}
				trend = 0;
			} else if (pre == cur) {
			} else {// pre < cur
				if(trend ==0){//touch the bottom
					min = pre;
				}
				trend = 1;
			}			
			pre = cur;
		}

		return total;
	}

}
