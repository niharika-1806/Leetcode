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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[]result=new int[2];
        
        ListNode prev=head;
        ListNode curr=head.next;

        int first=-1;
        int last=-1;

        int pos=1;

        int mindist=Integer.MAX_VALUE;

        while(curr.next!=null){
            if((curr.val> prev.val && curr.val > curr.next.val )
            || (curr.val< prev.val && curr.val < curr.next.val)){

                if(first==-1){
                    first=pos;
                }
                else{
                    mindist=Math.min(mindist,pos-last);
                }
                last=pos;
            }
            prev=curr;
            curr=curr.next;
            pos++;
        }
        if(first==last){
            return new int[]{-1,-1};
        }

        result[0]=mindist;
        result[1]=last-first;

        return result;
    }
}