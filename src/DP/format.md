1. Try all possible ways,min,max in sab mai recursion lagta hai.
2. ### DP mai saare questions mai functional recursion lagta hai.
### Steps to Solve Recursion Problem-:
1. Try to represent problem in terms of index
2. Do all possible stuffs on that index according to the problem
3. If they are asking you count-: sum all stuffs  
   If they are asking you min-: find minimum of all stuffs
### Steps to convert Recursion to Memoization
1. Find the parameter, which are changing.
2. Create dp of size n+1(Agar question mai 1 based indexing use kri hai tab else no need)
3. Save the answer before returning 
4. Before doing anything, first check whether it has already been calculated or not.
### Steps to convert Memoization to Tabulation
1. Initialise the same dp array used in Memoization
2. Look at the base cases, initialise the dp array values by reading base cases.
3. Recursion mai jo parameters change ho rhe hai, unki loops banao.like if index and lastIndex are changing toh 2 for loop chalao index and lastIndex ki
4. recursion mai jaha call kari hai vaha calls mai f() ko dp[] se replace krdo
5. Recursion mai jaha return kara hai end mai vaha return krne ki jagah dp[] mai store krlo 
### Can we reduce Space complexity of Tabulation
1. Simply dekho ki Tabulation mai dp[i] ko calculate krne ke liye kiski need hai if, only dp[i-1],dp[i-2] ki need hai toh poori dp table banane se 2 variables banao which will point to last two index.

### When greedy fails , you should try all possible combinations

### What i have observed is, ki DP ke mostly question subset/subsequence vaale hote hai subarray/substring vaale nhi 

### Types of questions-:
1. Count Problem-: Base case mai 1 return kro, negative base case mai 0. Also har call ke baad kuch add mat krna. func()+1 esa kuch mat krna. tuhe faith1+faith2 return karna hai.

### How to find answers
1. kuch questions mai faith1 and faith2 ko answer previous call return nhi krta balki isi call mai f()+1 krke pata padta hai like LIS
2. kuch mai faith1 and faith2 direct answers de dega
3. kuch mai apan ko parameters mai hi ans dena padega and vahi parameter ko update krte rehna padega
4. if you are using parametric recursion then ans is updated in parameter, if you are using functional recursion toh usme har call mai answer ko manipulate krna hai like f()+Math.abs(), f()+arr[index], etc. But if it is a count problem toh mat krna simply return f1+f2 and positive base case mai 1 return krna