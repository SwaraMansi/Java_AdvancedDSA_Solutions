/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        int count=0;
        ListNode curr=head;
        while(curr!=null){
            count++;
            curr=curr.next;
        }
        if (n == count) {
            return head.next;
        }
        ListNode temp=head;
        int delete= count-n;
        for(int i=1;i<delete;i++){
         temp=temp.next;   
        }
        temp.next=temp.next.next;
        return head;
    }
}