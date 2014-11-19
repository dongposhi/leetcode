
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
		if(head == null){
			return false;
		}
		
		ListNode fake = new ListNode(-1);
		fake.next = head;
		ListNode cur = head;
		ListNode flag = head;
		ListNode pre = null;
		while(cur != null){
			if(pre == null){
				pre = cur;
				cur = cur.next;
				continue;
			}
			pre.next = cur.next;
			cur.next = fake.next;
			fake.next = cur;

			cur = pre.next;
			
			if(fake.next == flag){
				break;
			}
		}
		return !(cur == null);		
    }
}
