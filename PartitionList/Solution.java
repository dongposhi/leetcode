/**
 * Definition for singly-linked list.
 */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode fake = new ListNode(0);
		fake.next = head;
        ListNode pre = fake;
		
		ListNode cur = fake.next;
		ListNode first = null;
		boolean flag = false;
		while(cur != null){
			if(cur.val < x){
				if(flag){
					ListNode tmp = first.next;
					pre.next = cur.next;
					first.next = cur;
					first = cur;
					cur.next = tmp;
					cur = pre;
				}
			}
			else{
				if(!flag){
					first = pre;
					flag = true;
				}
			}
			pre = cur;
			cur = cur.next;
		}
				
		return fake.next;
    }
}
