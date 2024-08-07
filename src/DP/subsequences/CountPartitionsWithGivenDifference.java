package DP.subsequences;

public class CountPartitionsWithGivenDifference {
    /**
     Given an array arr, partition it into two subsets(possibly empty) such that each element must belong to only one
     subset. Let the sum of the elements of these two subsets be S1 and S2.
     Given a difference d, count the number of partitions in which S1 is greater than or equal to S2 and the difference
     between S1 and S2 is equal to d

     We have to divide the array into 2 subsets such that
     s1-s2=d
     s1-(totalSum-s1)=d
     2*s1=totalSum+d
     s1=(totalSum+d)/2

     So question now becomes find number of subset with given sum((totalSum+d)/2)
     This question i have not solved because it was easy

     */
}
