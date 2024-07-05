package Recursion.basic;

import java.util.Stack;

public class ReverseStack {
    static void func(Stack<Integer> s,Stack<Integer> stack){
        if(s.isEmpty()){return;}
        int temp=s.pop();
        stack.add(temp);
        func(s,stack);
    }
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.add(4);
        stack.add(5);
        stack.add(7);
        System.out.println(stack);
        Stack<Integer> stack1=new Stack<>();
        func(stack,stack1);
        System.out.println(stack1);
    }
}
