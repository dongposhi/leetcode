public class Solution
{
	 public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
	 }
	
	 public ListNode swapPairs(ListNode head) {
		 if(head == null || head.next == null){
			 return head;
		 }
	     int i = 0;
	     ListNode preII = null;
	     ListNode pre = null;
	     ListNode cur = head;
	     
	     ListNode fake = new ListNode(0);
	     ListNode tmp = null;
	     ListNode tmp2 = null;
	     fake.next = head;
	     
	     while(true){
	    	 if( i% 2 ==1){
    			 pre.next = cur.next;
	    		 if(preII != null){
	    			 preII.next = cur;	    			 
	    		 }
	    		 else{
	    			 fake.next = cur;
	    		 }

    			 cur.next = pre;
    			 tmp = cur;
    			 tmp2 = pre;
    			 
    			 cur = tmp2;
    			 pre = tmp;
	    	 }
	    	 preII = pre;
	    	 pre = cur;
	    	 cur = cur.next;
	    	 i++;
	    	 if(cur == null){
	    		 break;
	    	 }
	     }
	     
	     return fake.next;
	 }
}
