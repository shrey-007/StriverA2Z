package StackAndQueues.problems;

import java.util.Stack;

/**
 * Question is very simple , you can see from test cases what to do
 * If you see the last test case toh tumhe pata padega ki ith asteroid coming to left can affect (0 to i-1) asteroids on the left.
 * Will ith asteroid coming to left affect right asteroids? No. suppose arr[7] par -5 hai and arr[8] par 5 hai toh 7th vaala 8 ko affect nhi karega coz vo left jaa rha hai and 8 right mai hai uske , cordinate geometry se soch lo 7 th asterid in on (7,0) and 8th is on (8,0) toh (7,0) se left jaa rha hai toh (8,0) ko kuch nhi hoga
 * Only question is what should we do?
 *
 * WHENEVER ith INDEX KE KAARAN (0 to i-1) INDEXES MAI CHANGE HO LIKE DELETION, TOH US CASE MAI AGAR LIST/STRING/ARRAY USE KRA TO PROBLEM HOTI HAI,
 * KIUKI TUM US LIST PAR TRAVERSE KR RHE HO AND USI MAI DELETION KR RHE HO TOH DELETE KRTE HI TUMHARA CURRENT INDEX CHANGE HO JAAEGA.
 * TOH ESE CASES MAI STACK USE KRO JESE HI ith ELEMENT PR AAYE TOH STACK MAI (0 to i-1) ELEMENTS ALREADY HOGE UNKO CONDITION KE ACCORDING DELETE KRO
 * AND USSE INDEXING PAR FARAK NHI PADEGA KUKI TRAVERSE TUM GIVEN QUESTION KE DATA STRUCTURE PAR KR RHE HO AND CHANGES TUM STACK MAI KR RHE(JISME INDEXING NI HOTI)*/

/**
 * Concept-: Only +- will collide, --,++,-+ will not collide where +- means ki (i-1) is positive and i is negative
 * Toh agar positive aaye toh stack mai push krdo
 * Agar negative aaye toh tab tak collision hoga jab tak uske just peeche positives hai
 * */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack=new Stack<>();

        // traverse the array
        int n=asteroids.length;
        for (int i = 0; i < n; i++) {
            // Toh abhi apan ith asteroid pr hai , toh dekho ki is  asteroid ke kaaran previous (0 to i-1) asteroid jo
            // ki stack mai hai , unme change(deletion) ho skta hai kya
            boolean isDestroyed=false;

            // Agar previous asteroid hai , and current asteroid left side jaa rha hai, toh changes hoge
            while (!stack.isEmpty() && asteroids[i]<0 && stack.peek()>0){
                if(Math.abs(asteroids[i])>Math.abs(stack.peek())){
                    // [2,-5], if i is -5 and peek is 2, toh 2 destroy ho jaaega and -5 jaata jaaega left side
                    stack.pop();
                }
                else if(Math.abs(asteroids[i])==Math.abs(stack.peek())){
                    // [8,-8] if i is -8 and peek is 8, toh dono destroy ho jaaege, toh -8 is now destroyed toh use baad mai stack mai add krne ki need nhi hai
                    stack.pop();
                    isDestroyed=true;
                    break;
                }
                else{
                    // [10,-5] if i is -5 and peek is 10 toh -5 vaala destroy ho jaaega toh use stack mai add krne ki need nhi hai
                    isDestroyed=true;
                    break;
                }
            }

            // means ya toh , ye positive asteroid hai toh ise add kro ya fir ye negative asteroid hai jo ki destroy nhi hua hai
            if(!isDestroyed) stack.add(asteroids[i]);
        }


        // bache hue asteroids stack mai hai
        int m=stack.size();
        int ans[]=new int[m];
        for (int i = m-1; i >=0 ; i--) {
            ans[i]=stack.pop();
        }

        return ans;
    }
}
