package StackAndQueues.implementationProblems;

import java.util.ArrayList;

public class StockSpan {

    ArrayList<Integer> list;

    public StockSpan() {
        list=new ArrayList<>();
    }

    public int next(int price) {
        list.add(price);
        int count=0;
        for(int i=list.size()-1;i>=0;i--){
            if(list.get(i)<=price){count++;}
            else{break;}
        }
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
