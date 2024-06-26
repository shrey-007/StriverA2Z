package LinkedList.medium.singly;


import LinkedList.implementation.singly.Node;

/**
 *
 *  when we add 2  numbers 2345
 *                         4443 than we have to start calculating from right side and then go to left side
 *  But in singly LL it is not possible to go left.
 * */

public class AddOneToANumberRepresentedByLL {

    // here we are given a number let 539 and we have to add it but the problem is we first have to add it to 9 then if
    // there is carry then we have to add the carry  to 3 and so on until carry=0.
    // Means we have to go right to left which is not possible

    // method1 - reverse the LL so it becomes 935 now add 1 to it not like normal math addition but the way we did in AddTwoNumbersInLL
    // so it becomes 045 now again revese the LL so it becomes 540

    // method 2- use recursion
    // func will add the carry to the current number return the new carry
    public static int func(Node node){
        // we have to add 1 so this is the base case
        if(node==null){return 1;}

        // dekho sabse pehle function call ho rhi hai means sabse pehle vo last node tak jaaega i.e 9 tak (5->3->9)
        int carry=func(node.next);
        // Is ke baad ki saari lines function call ke baad likhi hai means vaapis aate hue execute hogi (9->3->5) and apan ko isi order mai calculations krni thi
        int result=node.value+carry;

        if(result>=10){
            result=result-10;
            node.value=result;

            // return the carry 1
            return 1;
        }
        else{
            node.value=result;

            // return the carry 0
            return 0;
        }
    }

    /** DRY RUN IT IF YOU DON'T UNDERSTAND */




}
