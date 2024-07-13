
Tips to solve BS on answers-:
1) First solve it using bruteForce then think ki isme BS on answer kiu laga else if this question comes in interview tum pta nhi kr paaoge ki isme BS on answers lagana hai.
2) These type of questions are long story based questions with many variables  so use copy,pen and write each variable and its significance.
3) We are generally asked min/max of something and ek part ko hata skte hai answer se toh ese question m use hota hai  


### Identifying if a problem can be solved using binary search on answers generally involves recognizing certain characteristics in the problem. Here are some common signs and strategies:

1) Monotonicity:

The problem's solution space must be monotonic, meaning that if a solution is valid for some value, then it remains valid (or invalid) for all larger or smaller values. Essentially, the problem should exhibit a property where the answers become progressively better or worse as you move in one direction.
2) Search Space:

There should be a clear range (search space) within which the answer lies. This range can often be derived from the problem constraints.
3) Decision Function:

You should be able to construct a decision function that, given a candidate solution, tells you whether it meets the problem's requirements. This function should be efficient to compute.
4) Optimization or Threshold:

The problem might involve finding the maximum or minimum value that satisfies certain conditions, or determining if a particular threshold value can be met.
### Examples
Here are a few classic examples to illustrate these principles:

1) Finding the Square Root of a Number:

You want to find the square root of a number x. The range is from 0 to x. If a number mid is a potential solution, then you can check if mid * mid is equal to, less than, or greater than x to decide which half of the search space to discard.
2) Minimum Time to Complete Jobs:

Given a set of jobs and the time each takes, and multiple workers, you want to find the minimum amount of time required to complete all jobs. The range is from the maximum job time to the sum of all job times. You can check if a certain amount of time is sufficient by simulating the job distribution among workers.
3) Capacity to Ship Packages Within D Days:

You have a set of weights for packages and need to ship them within D days. The range is from the maximum weight of a single package to the sum of all weights. You can check if a certain capacity allows for shipping within D days.