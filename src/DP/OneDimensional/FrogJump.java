package DP.OneDimensional;

/**
 *  Geek wants to climb from the 0th stair to the (n-1)th stair. At a time the Geek can climb either one or two steps.
 *  A height[N] array is also given. Whenever the geek jumps from stair i to stair j, the energy consumed in the jump
 *  is abs(height[i]- height[j]), where abs() means the absolute difference. return the minimum energy that can be used
 *  by the Geek to jump from stair 0 to stair N-1.*/
public class FrogJump {

    // Recursion-----------------------------------------------------------------------------------------------
    public int minimumEnergy(int arr[],int N){
        return func(arr,N-1);
    }

    // func(index) returns ki uski index to 0 jaane ki min cost kya hogi
    // Isme apan 0 to index jaane ki cost ko bhi func maan skte the no problem
    // Isme negative base case kabhi aaega hi nhi, kiuki pehle hi check kr liya,
    // Pehle isliye check kra kiuki apan ko Math.abs(arr[index]-arr[index-2]); krna tha and agar index-2<0 hota toh arr[index-2] pehle error deta uske baad call hoti tab negative base case aata, but call hogi hi nhi arr[index-2] hi error de dega isliye pehle check kra.
    // Negative base case mai Integer.MAX_VALUE return hoti, jo ki faith2 call krta , but negative base case call hi nhi hoga toh pehle se hi Integer.MAX_VALUE assign krdi
    public int func(int arr[],int index){
        // 0 to 0 jaane ki cost zero
        if(index==0){return 0;}

        // is call se kabhi bhi negative index call nhi hoga
        int faith1=func(arr,index-1)+Math.abs(arr[index]-arr[index-1]);

        // is call se negative index call ho skta hai toh call krne se pehle check krlo
        int faith2=Integer.MAX_VALUE;
        if(index-2>=0){
            faith2=func(arr,index-2)+Math.abs(arr[index]-arr[index-2]);
        }

        return Math.min(faith1,faith2);
    }

    // Memoization ----------------------------------------------------------------------------------------------------
    // Look at the parameters which are changing(index)
    // Max value of index is 5 so, create a dp[] of size 6 coz it will have 5th index.
    public int func(int arr[],int index,int dp[]){
        // 0 to 0 jaane ki cost zero
        if(index==0){return 0;}
        if(dp[index]!=-1){return dp[index];}

        // is call se kabhi bhi negative index call nhi hoga
        int faith1=func(arr,index-1)+Math.abs(arr[index]-arr[index-1]);

        // is call se negative index call ho skta hai toh call krne se pehle check krlo
        int faith2=Integer.MAX_VALUE;
        if(index-2>=0){
            faith2=func(arr,index-2)+Math.abs(arr[index]-arr[index-2]);
        }

        dp[index]=Math.min(faith1, faith2);

        return Math.min(faith1,faith2);
    }

    // Tabulation-------------------------------------------------------------------------------------------------------
    // Opposite of Memoization.
    // It is bottom up approach
    public int tabulation(int arr[],int N){

        int dp[]= new int[N+1];
        dp[0]=0;

        for (int i = 1; i < N; i++) {
            int faith1=dp[i-1]+Math.abs(arr[i]-arr[i-1]);
            int faith2=Integer.MAX_VALUE;
            if(i-2>=0){
                faith2=dp[i-2]+Math.abs(arr[i]-arr[i-2]);
            }
            dp[i]=Math.min(faith1,faith2);
        }

        return dp[N];
    }

    // Optimised Space complexity
    // prev2 prev curr
    public int spaceOptimised(int arr[],int N){
        int prev2=0; // dp[0]
        int prev=0;

        for (int i = 1; i <N; i++) {
            int faith1=prev+Math.abs(arr[i]-arr[i-1]);
            int faith2=Integer.MAX_VALUE;
            if(i-2>=0){
                faith2=prev2+Math.abs(arr[i]-arr[i-2]);
            }

            int curr=Math.min(faith1,faith2);

            prev2=prev;
            prev=curr;
        }
        
        return prev;
    }

}
