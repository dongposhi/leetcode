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
    public ListNode insertionSortList(ListNode head) {
        ListNode fake = new ListNode(0);
	        fake.next = head;

	        ListNode i = head;
	        
	        while(i != null){
	        	ListNode tmp = i.next;
	        	ListNode j = fake.next;
	        	ListNode jpre = fake;
	        	while(j != i){
	        		if(j.val <= i.val){
	        			jpre = j;
	        			j = j.next;
	        		}
	        		else{
	        			jpre.next = i;
	        			i.next = j;
	        			
	        			while(j.next != i){
	        				j = j.next;
	        			}
	        			j.next = tmp;
	        			break;
	        		}
	        	}	 
	        	i = tmp;
	        }
	        
	        return fake.next;
    }
}
