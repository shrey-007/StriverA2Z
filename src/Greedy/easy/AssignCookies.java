package Greedy.easy;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int g[],int s[]){
        Arrays.sort(g);
        Arrays.sort(s);
        int n1=g.length;
        int n2=s.length;

        int i=0; // pointer to s
        int j=0; // pointer to g

        while (i<n2 && j<n1){
            // if the size of the current cookie is greater then the greed of the child, toh vo use khaa lega
            if(s[i]>=g[j]){
                i++; // next cookie pr jaao, current cookie khaa li gyi hai
                j++; // next child pr jaao current child ne khaa liya hai
            }
            else{
                // means ki current cookie se child ki greed nhi bharegi, and since g is sorted toh aage aane vaale
                // children ki bhi greed nhi bharegi toh ye cookie kuch nhi kr paaegi toh
                i++;
            }
        }

        return j;
    }

}
