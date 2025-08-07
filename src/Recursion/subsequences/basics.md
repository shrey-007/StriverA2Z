There are few patterns of subsequences-:
1) Find count of all subsequences-:  
   In base if condition satisfies(positive base case) then return 1 , else return 0(negative base case)  
   In normal call return sum of all calls  

[//]: # (2&#41; Print any one answer-:)

### Types of Recursion-:
1. Functional-: When we have to return something
2. Parametrised-: When edge case arrives, it either prints the answer or it updates the answer passed in the parameter.
Toh agar hume kuch return Object krna ho toh us object ko create kro and new Parametrised recursion banao yaha pass krdo
and ye usme answer update kr dega fir use return krdo. Ye cheej Functional Recursion mai nhi kr skte hai. Toh ye bhi 
return vaala kaam kr skta hai (only on object, not on primitive data types). Like jaise Trees mai apan ko integer return
krna tha toh apan ne use object mai convert krke ans[1] , Parametrised recursion mai pass kiya tha jisse vo ans[1] update
ho gya. It is recommended ki Parametrised recursion use kro, it is easy as compared to Functional. 
3. Parameterised mai aage jaate hue ans milta hai and functinal mai vapis aate hue answer milta hai

### Tips
1. ## kabhi kabhi parameterised mai only ans lene se kaam nahi chalta , currentAns bhi lena padta hai. And positive base case mai apan currentAns ko ans mai add krte hai