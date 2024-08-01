If you found out recursion function then memoization is very easy  
Problem is to convert it to tabulation  
Here are some of my points-:  
1. Jo parameters recursion mai change hoge, unhi parameters ka dp array banta hai memoization and tabulation mai.
2. Memoization mai dp array apne aap ban jaaega, but tabulation mai tumhe khud fill krni hai vo parameter ki values toh
jitne parameters utni loops lagegi tabulation mai, take an example from NinjaTraining 
```java
public int func(int arr[][],int index,int lastActivity,int n)
```
Isme jaise 2 changing paramters hai toh tabulation mai 2D array banega inhi changing parameters ka, (index)x(lastActivity) ke size ka jise fill krna hoga,
 Toh use fill krne ke liye uspr iterate krege
```java
  for (int index = n - 2; index >= 0; index--) {
        for (int lastActivity = 0; lastActivity < 3; lastActivity++){
            
        }
  }
```
3. Ye jo index hai vo day hai and lastActivity denotes ki last pr konsi activity kri. Ab jab ye ho jaaega toh recursive function ko dekho, usme current index(day) ki activity choose kr rha hai
```java
        for (int activity = 0; activity < 3; activity++) {
            if(activity!=lastActivity){
                faith=Math.max(faith,func(arr,index+1,activity,n,dp)+arr[index][activity]);
            }
        }
```
But ye kaam abhi tak apan ne kra nhi tabulation mai toh is bhi kro, ise same as it is copy paste krdo bas func ki jagah [] aaega
4. Also bahut baar esa hoga ki tabulation ka base case khud likhna padega, toh recursion ki last call ko dry run krlo pata pad jaaega kya likhna hai ya fir dp array n+1 sizez ka banao 

### Space Optimization
1. If current answer is using previous row/col then we can optimise it
2. We will use array to store previous row, if we need previous row, we can obtain from previous row array and when you need
   previous column , wee can obtain it from dp array itself.