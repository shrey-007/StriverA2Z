package LinkedList.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

class CustomNode implements Comparable<CustomNode>{
    int value;
    CustomNode next;
    CustomNode bottom;

    public CustomNode(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(CustomNode o) {
        return this.value-o.value;
    }
}


/**
 *  Mehtod 1 is ki simply saare nodes pr traverse kro and unhe ek arralylist mai daalte jaao fir arraylist ko sort krdo
 *  for sorted array list ke elements se vaapis se LL banao
 */

public class FlatteningLL {

    /**
     *  Method 2 maine khud socha hai-:
     *  ek min heap banao and usme first node daalo
     *  fir ye steps follow kr
     *  1) remove top of minHeap
     *  2) Since it is smallest toh ise answer mai add kro(New ll mai add kro and new LL banane ke liye hamesha dummy pointer and currOfNewLL use kra kro)
     *  3) Since ye answer mai add ho gya hai toh iske neighbours i.e iske next and bottom ko minHeap mai daal do and repeat this process untill minHeap is not empty
     * */


    public static CustomNode flatten(CustomNode root) {

        PriorityQueue<CustomNode> priorityQueue=new PriorityQueue<>();

        // add first element in minheap
        priorityQueue.add(root);

        // dummyNode.bottom always points to the head of the new LL
        CustomNode dummyNode=new CustomNode(0);
        // It points to the current tail of the new list toh jab bhi new element add krna hoga toh currOfNewLL.next ko usko point kra denge
        CustomNode currOfNewLL=dummyNode;

        while (priorityQueue.size()!=0){
            // remove the top of priorityQueue
            CustomNode temp=priorityQueue.poll();

            // add it to ans
            CustomNode newNode=new CustomNode(temp.value);
            currOfNewLL.bottom=newNode;
            currOfNewLL=newNode;

            // add new nodes to the priorityQueue
            if(temp.next!=null){priorityQueue.add(temp.next);}
            if(temp.bottom!=null){priorityQueue.add(temp.bottom);}
        }

        return dummyNode.bottom;
    }

    /**
     *  Method 3 is merging sorted list using recursion
     *
     *
     * */

    public static CustomNode merge(CustomNode list1, CustomNode list2) {
        // Create a dummy node as a
        // placeholder for the result
        CustomNode dummyNode = new CustomNode(-1);
        CustomNode res = dummyNode;

        // Merge the lists based on data values
        while (list1 != null && list2 != null) {
            if (list1.value < list2.value) {
                res.bottom = list1;
                res = list1;
                list1 = list1.bottom;
            } else {
                res.bottom = list2;
                res = list2;
                list2 = list2.bottom;
            }
            res.next = null;
        }

        // Connect the remaining
        // elements if any
        if (list1 != null) {
            res.bottom = list1;
        } else {
            res.bottom = list2;
        }

        // Break the last node's
        // link to prevent cycles
        if (dummyNode.bottom != null) {
            dummyNode.bottom.next = null;
        }

        return dummyNode.bottom;
    }

    // Flattens a linked list with child pointers
    public static CustomNode flattenLinkedList(CustomNode head) {
        // If head is null or there
        // is no next node, return head
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively flatten the
        // rest of the linked list
        CustomNode mergedHead = flattenLinkedList(head.next);
        head = merge(head, mergedHead);
        return head;
    }
}
