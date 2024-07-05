package Recursion.basic;

import java.util.Stack;

public class SortStack {

    /**
     * Initialize an auxiliary stack.
     * While the original stack is not empty, pop an element from it.
     * Push it onto the auxiliary stack if it's empty or the top element of the auxiliary stack is less than or equal to the popped element.
     * If the top element of the auxiliary stack is larger, pop elements from the auxiliary stack back to the original stack until the auxiliary stack is either empty or the top element is lesser than or equal to the popped element.
     * Push the popped element onto the auxiliary stack.
     * Repeat until all elements are sorted in the auxiliary stack.
     * Transfer elements back to the original stack if needed.
     * */
    public static Stack<Integer> func(Stack<Integer> stack){
        // create a temporary stack
        Stack<Integer> stack1=new Stack<>();

        while (stack.size()>0){
            int currElement=stack.pop();
            if(stack1.size()==0 || stack1.peek()<=currElement){
                stack1.add(currElement);
            }
            else{
                while (!stack1.isEmpty() && stack1.peek() > currElement){
                    stack.add(stack1.pop());
                }
                stack1.add(currElement);
            }
        }

        return stack1;

    }

    /** Don't use recursion, it is difficult */


}
