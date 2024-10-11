### How to find?
Subarray/Substring ke question mai lagta hai sliding window

### Fixed window

```java
int func(int nums[],int k){
    int start=0;
    int end=0;
    
    while(end<nums.length){
        // do operations on end
        
        // if window size is less, than increase size
        if(end-start+1<k){
            end++;
        }
        // if window size is equal to k, then maintain the window
        else if(end-start+1==k){
            // update the ans
            // remove operations of start 
            start++;
            end++;  
        }
        
    }
    
}
```

### Variable Window

```java
int func(int nums[]){
    int start=0;
    int end=0;

    while(end<nums.length){
        // do operations on end
        
        // isme multiple conditions ban skti hai, pehle sirf 2 thi.
        // Toh voh khud sochna padega ki kya conditions hogi
        
        if(condition matches){
            // update ans
            // and window badao kiuki largest subarray chaiye
            end++;
        }
        else if(condition does not matches){
            // socho kiu ni match kr rhi, toh pata padega ki end badana hai ya start
        }
        else{
            // socho kiu ni match kr rhi, toh pata padega ki end badana hai ya start
        }
    }
}
```

### sum Lesser than equal to goal(count)

```java
public int func(){
    if(goal<0){return 0;}

    
    int start=0;
    int end=0;
    
    int ans=0;
    int sum=0;

    
    while (end<nums.length){
        // do work on end
        // sum=sum+nums[end];
        
        while (sum>goal){
            sum=sum-nums[start];
            start++;
        }
        
        ans=ans+end-start+1;   // means (end-start+1) is the count of subarrays to be added to ans
        end++;
    }

    
    return ans;
    
}
```