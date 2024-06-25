package LinkedList.medium.singly;


import LinkedList.implementation.singly.Node;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * It is an easy question because digits are stored reversed toh last se sum ni krna starting se krna hai*/
public class AddTwoNumbersInLL {

    /**
     *
     *  when we add 2  numbers 2345
     *                         4443 than we have to start calculating from right side and then go to left side
     *  But in singly LL it is not possible to go left.
     *  But problem is easy because we are given reversed numbers i.e instead of 2345 we are given 5432 so we have to
     *  calculate from left to right which is easy.
     *
     * */



    public static Node addTwoNumbers(Node l1, Node l2) {

        Node temp1=l1; // points to the current node of new list1
        Node temp2=l2; // points to the current node of new list2

        int carry=0;

        Node dummyNode=new Node(null,0);  // whenever you are creating new LL always initialsed a dummyNode which will always point to the head of the new list
        Node curr=dummyNode; // points to the current node of new list

        while (temp1!=null && temp2!=null){
            int result=temp1.value+ temp2.value+carry;
            if(result>=10){
                carry=1;
                result=result-10;
            }
            else{
                carry=0;
            }

            Node node=new Node(result);
            curr.next=node;
            curr=curr.next;

            temp1=temp1.next;
            temp2=temp2.next;
        }

        // if l1 is bigger than l2

        if(temp1!=null && temp2==null){
            int result=temp1.value+carry;
            if(result>=10){
                carry=1;
                result=result-10;
            }
            else{
                carry=0;
            }

            Node node=new Node(result);
            curr.next=node;
            curr=curr.next;

            temp1=temp1.next;
        }
        // if l2 is bigger than l1
        else if(temp2!=null && temp1==null){

            int result=temp2.value+carry;
            if(result>=10){
                carry=1;
                result=result-10;
            }
            else{
                carry=0;
            }

            Node node=new Node(result);
            curr.next=node;
            curr=curr.next;

            temp2=temp2.next;
        }

        // even if both list are completed and carry is left so still we have to add the carry in the result
        if(carry!=0){
            Node node=new Node(carry);
            curr.next=node;
            curr=curr.next;
        }

        return dummyNode.next;
    }


    public static void main(String[] args) {
        Node node1=new Node(9);
        Node node2=new Node(9);
        Node node3=new Node(9);
        Node node4=new Node(9);
        Node node5=new Node(9);
        Node node6=new Node(9);
        Node node7=new Node(9);
        Node node11=new Node(9);
        Node node12=new Node(9);
        Node node13=new Node(9);
        Node node14=new Node(9);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;

        node11.next=node12;
        node12.next=node13;
        node13.next=node14;

        System.out.println(addTwoNumbers(node1,node11));


    }


}
