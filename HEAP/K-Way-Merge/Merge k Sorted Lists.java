//leetcode => https://leetcode.com/problems/merge-k-sorted-lists
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
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> heap= new PriorityQueue<ListNode>(lists.length, (a,b)
        -> a.val-b.val);
        
        ListNode dummyNode = new ListNode(0);
        ListNode tailNode = dummyNode;

        for( ListNode node : lists) {
            if( node != null) {
                heap.add(node);
            }
        }
        while (!heap.isEmpty()){
            tailNode.next = heap.poll();
            tailNode = tailNode.next;

            if(tailNode.next != null){
                heap.add(tailNode.next);
            }
        }
        return dummyNode.next;
    }
}
