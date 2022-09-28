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
         if(head==null||head.next==null){
        return null;
    }
    ListNode x=head;
    int count=0;
    while(x!=null){
        count++;
        x=x.next;
        
    }
    if(count==n){
        ListNode temp=head;
        temp.val=temp.next.val;
        temp.next=temp.next.next;
    }
    else{
    int c=count-n;
    ListNode temp=head;
    while(c>1){
        c--;
        temp=temp.next;
    }
    temp.next=temp.next.next;
    }
    
    return head;
        
        
        
    }
}