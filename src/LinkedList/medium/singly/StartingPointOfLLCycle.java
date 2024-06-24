package LinkedList.medium.singly;

import LinkedList.implementation.singly.Node;

import java.util.HashMap;
import java.util.HashSet;

public class StartingPointOfLLCycle {

    /**
     * Consider this example
     *  1->2->3->4->5
     *        ^     |
     *        |-----|
     * */
    public static Node detectCycle(Node head) {

        // check whether it contains cycle or not
        Node slow=head;
        Node fast=head.next;
        boolean flag=false;

        while (fast!=null && fast.next!=null){
            if(fast==slow){flag=true;break;}
            fast=fast.next.next;
            slow=slow.next;
        }

        // if there is no cycle return null
        if(!flag){return null;}

        /** slow and fast will point at 4*/

        // now store all nodes of a cycle in a hashset
        HashSet<Node> hashSet=new HashSet<>();

        do {
            hashSet.add(fast);
            fast=fast.next;
        }
        while (fast!=slow);

        /** Hashset={3,4,5}*/

        // Now start iterating from head and see whether hashmap contains it or not, if yes toh vahi start hai
        /**start from 1 and check the first element found in hashmap, toh 1 ni mila, 2 ni mila , 3 mila toh vahi answer hai*/
        while (!hashSet.contains(head)){
            head=head.next;
        }

        return head;

    }

    public static Node detectCycle2(Node head) {

        /** First node jo 2 baar visit hoti hai vahi starting point of cycle hoti hai */

        Node temp=head;
        HashSet<Node> hashSet=new HashSet<>();

        while (temp!=null){
            if(hashSet.contains(temp)){
                // Means it is first repeated node toh yahi answer hai
                return temp;
            }
            else{
                hashSet.add(temp);
                temp=temp.next;
            }
        }

        // yaha tak aaye means there is no loop
        return null;
    }

    public static Node detectCycle3(Node head) {

        Node slow=head;
        Node fast=head;

        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){break;}
        }

        // slow and fast meets
        // Now slow ko vaapis head pr point karado

        slow=head;

        // Ab jaha slow and fast vaapis milege voh start position hogi I don't know the logic but learn it
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node3;

        detectCycle(node1);

    }
}
