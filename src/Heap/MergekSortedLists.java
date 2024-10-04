package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * You are given a k size array of head of k sorted linkedlist, merge all linkedlist to form a sorted list
 * */
public class MergekSortedLists {
    // Same concept as merge two sorted arrays, usme 2 pointer hote the
    // Yaha merge k sorted list mai k, pointers banao fir unka min nikalo and use ans mai daalo and usko ++ kro, toh min nikaalne ka way heap hai, baaki sab same
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> priorityQueue=new PriorityQueue<>(new NodeComparator());

        // to create a new list , create a dummy node
        ListNode dummy= new ListNode(-1);
        // jab new node banegi toh vo previous node ka next hoga, toh previous node hoga tabhi toh uska next ko newNode mai assign kroge
        ListNode lastNode=dummy;

        // iterate over heads of all linked list, if they are not null, put them in heap
        for (int i = 0; i < lists.length; i++) {
            if(lists[i]!=null){priorityQueue.add(lists[i]);}
        }

        while (!priorityQueue.isEmpty()){
            // get the min element
            ListNode curr=priorityQueue.poll();
            // since it is the min element toh new node banao
            ListNode newNode=new ListNode(curr.val);
            // and is newnode ko jodo ans linkedlist mai
            lastNode.next=newNode;
            // update the last node
            lastNode=newNode;

            // jo min tha uska next ko daalo heap mai if it is not null
            if(curr.next!=null){priorityQueue.add(curr.next);}
        }


        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class NodeComparator implements Comparator<ListNode> {
    @Override
    public int compare(ListNode o1, ListNode o2) {
        return o1.val-o2.val;
    }
}
