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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i=0;i<lists.length;i++){
            ListNode temp=lists[i];

            while(temp!=null){
                pq.add(temp.val);
                temp=temp.next;
            }
        }
        ListNode newhead=new ListNode();
        ListNode temp=newhead;
        temp.next=null;

        while(!pq.isEmpty()){
            ListNode node= new ListNode(pq.poll());
            temp.next=node;
            temp=node;
        }
        temp.next=null;

        return newhead.next;
    }
}