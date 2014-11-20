public class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode reverseList(ListNode head) {
		if(head == null){
			return null;
		}
		ListNode x = new ListNode(0);
		ListNode cur = head;
		ListNode tmp = null;

		while (cur != null) {
			tmp = cur.next;
			cur.next = x.next;
			x.next = cur;
			cur = tmp;
		}
		return x.next;
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode ret = reverseList(head);

		if(n == 1){
			ret = ret.next;
		}
		ListNode cur = ret;
		ListNode pre = null;
		for(int i = 1;i<n;i++){
			pre = cur;
			cur = cur.next;
			if(cur == null){
				return null;
			}			
		}
		if(pre != null){
			pre.next = cur.next;
		}
		return reverseList(ret);
	}

	public void run() {
		ListNode x0 = new ListNode(0);
		ListNode x1 = new ListNode(1);
		ListNode x2 = new ListNode(2);
		ListNode x3 = new ListNode(3);
		ListNode x4 = new ListNode(4);

		x0.next = null;
		x1.next = x2;
		x2.next = x3;
		x3.next = x4;
		
		printListNode(x0);
		ListNode l = removeNthFromEnd(x0,1);
		printListNode(l);
	}
	
	public void printListNode(ListNode ln){
		if(ln == null){
			System.out.println("null");
		}
		while(ln != null){
			System.out.print(ln.val + ",");
			ln = ln.next;
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		Solution x = new Solution();
		x.run();
	}
}

