
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
	public ListNode reverseList(ListNode head) {
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

	/*worked but time exceed*/
	public void func1(ListNode head) {		
        if(head == null || head.next == null){
			return;
		}
		ListNode last = head;
		ListNode pre = null;
		while(last.next!=null){
			pre = last; 
			last=last.next;
		}
		if(pre == head){
			return;
		}
		ListNode tmp = head.next;
		head.next = last; 
		last.next = tmp;
		pre.next = null;
		
		func1(tmp);
	}
	
	void split(ListNode head){
		if(head == null || head.next ==null){
			return;
		}
		int n = 0;
		ListNode pre1 = null;
		ListNode pre2 = null;
		
		ListNode f = head;
		ListNode s = head.next;
				
		ListNode cur = head;
		while(cur != null){
			if(pre2 != null){
				pre2.next = cur;
			}
			pre2 = pre1;
			pre1 = cur;		
			cur = cur.next;
		}
		pre2.next = null;
		printRecord(f);
		System.out.println("");
		printRecord(s);
		System.out.println("");
		
	}
	
	/*worked but time exceed*/
	void func(ListNode root){	
		if(root == null || root.next == null){
			return;
		}
		
		ListNode head = root;
		ListNode cur = root;
		ListNode tmp =null,pre = null;
		while(head!=null){
			cur = head;			
			while(cur.next != null){
				pre = cur;
				cur = cur.next;
			}			
			if(pre == head){
				break;
			}
			tmp = head.next;
			head.next = cur;
			cur.next = tmp;
			pre.next = null;
			head = tmp;
		}
	}

	/*final solution*/
	void reorderList(ListNode root){	
		if(root == null || root.next == null){
			return;
		}
		
		ListNode tmp = root;
		int n = 0;
		while(tmp!=null){
			n++;
			tmp = tmp.next;
		}
		tmp = root;
		int m = 0;
		ListNode se = null;
		while(tmp!=null){
			m++;
			if(m == (n+1)/2){				
				se = tmp.next;
				tmp.next = null;
				break;
			}
			tmp = tmp.next;
		}
		
		ListNode x = reverseList(se);
		
		printRecord(root);
		System.out.println("");
		printRecord(x);
		System.out.println("");

		
		ListNode head1 = root;
		ListNode head2 = x;
		
		ListNode tail = head1;
		while(tail != null){
			tmp = tail.next;
			
			if(tail == head1){
				tail.next = head2;
				head1 = tmp;
			}
			else{
				tail.next = head1;
				head2 = tmp;
			}
			tail = tail.next;
		}
		printRecord(root);
		System.out.println("");
	}
	void printRecord(ListNode node) {
		do {
			System.out.print(node.val + ",");
			node = node.next;
		} while (node != null);
	}

	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		ListNode ln = root;
		ln.next = new ListNode(2);
		ln = ln.next;
		ln.next = new ListNode(3);
		ln = ln.next;
		ln.next = new ListNode(4);
		ln = ln.next;
		ln.next = new ListNode(5);
		ln = ln.next;
		ln.next = new ListNode(6);
		ln = ln.next;
		Solution r = new Solution();

	//	r.printRecord(root);
	//	System.out.println("");
	//	r.reorder(root);
	//	r.printRecord(root);
	//	System.out.println("");
	//	r.split(root);
		r.reorderList(root);
			//r.printRecord(root);
			//System.out.println("");
	}
}
