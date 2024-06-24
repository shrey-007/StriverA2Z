package LinkedList.medium.singly;

import LinkedList.implementation.singly.Node;

public class OddEvenLL {

    /**
     * Ek even pointer rakho and ek odd pointer fir odd ko odd pr point krate jaao and even ko even par. End mai odd
     * vaalo ki alag LL bn jaaegi and even vaalo ki alag. Ab unhe combine krne ki condition jaane ke liye 2 test case
     * lelo ek mai even no. of nodes ho and ek mai odd no. of nodes
     * */
    public Node oddEvenList(Node head) {

        if(head==null || head.next==null || head.next.next==null){return head;}

        Node odd=head;
        Node even=head.next; // both odd and even can't be null coz uski condition uper check krli

        int count=1; // tells whether odd ki turn h ki even ki

        Node evenHead=null;  // first even node
        Node oddTail=null;   // last odd node

        while (odd!=null && even!=null){
            if(count%2==1){
                oddTail=odd;
                // odd turn
                odd.next=even.next;  // these will never throw exception coz neither odd nor even is null
                odd=even.next;
                count++;
            }
            else{
                if(count==2){evenHead=even;}
                // even turn
                even.next=odd.next;
                even=odd.next;
                count++;
            }
        }

        // Ye loop khatam hone ke baad odd ki LL alag bn jaaegi and even ki LL alag

        // condition for combining even LL and odd LL

        if(count%2==1){
            // means ki odd number of nodes hai
            odd.next=evenHead;
        }
        else{
            // means ki even number of nodes hai
            oddTail.next=evenHead;
        }

        return head;

    }
}
