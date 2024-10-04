package Greedy.easy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    /**
     * If you are performing any operation on int,int ,the resultant will still be int even if you store it in double
     * like in below code in comparator, o1.value and o1.weight both are int and you are dividing it and storing it in
     * double but it does not convert into double, it is still int.
     * So convert any one of it to double, like yaha o1.value ko double mai convert kra, ab dono ka operation double dega
     * */
    double fractionalKnapsack(int w, Item arr[], int n) {
        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                double r1=(double) o1.value/o1.weight;
                double r2=(double) o2.value/o2.weight;
                return Double.compare(r2,r1);
            }
        });

        int i=0;
        double profit=0.0;

        while (i<n && w>0){
            int currentWeight=arr[i].weight;
            int currentProfit=arr[i].value;
            if(currentWeight<=w){
                w=w-currentWeight;
                profit=profit+currentProfit;
            }
            else{
                double ratioOfWeightWeCanTake=(double) w/currentWeight;
                double ratioOfProfitWeCanTake=ratioOfWeightWeCanTake*currentProfit;
                w=0;
                profit=profit+ratioOfProfitWeCanTake;
            }
            i++;
        }

        return profit;
    }

    public static void main(String[] args) {
        Item arr[]=new Item[3];
        arr[0]=new Item(60,10);

    }
}

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
