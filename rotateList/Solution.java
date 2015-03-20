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
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null){
            return null;
        }        

        if( n == 0)
            return head;

        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode cur = head;
        ListNode pre = null;

        int len = 0;
        while(cur != null){
            cur = cur.next;
            len++;
        }

        if( n % len == 0)
            return head;
        else{
            n = n % len;
        }

        cur = head;
        int i = 0;
        while(cur != null && i++ < len -n){
            pre = cur;
            cur = cur.next;
        }

        // printList(cur);
        if(pre != null){
            pre.next = null;
            fake.next = cur;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = head;
        }
        return fake.next;

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



}
