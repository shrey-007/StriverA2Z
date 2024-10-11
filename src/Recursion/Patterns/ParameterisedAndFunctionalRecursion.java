package Recursion.Patterns;

public class ParameterisedAndFunctionalRecursion {
    // Suppose we need to print the sum of elements of array then we will store our answer in parameter,
    // and when the base case arrives , we will return the parameter
    public void func(int arr[],int index,int sum){
        if(index==arr.length){
            System.out.println(sum);
            return;
        }
        func(arr,index+1,sum+arr[index]);
    }

    // Now suppose we have to return the value(not print the value), so we will do in this way
    public int func(int arr[],int index){
        if(index==arr.length){return 0;}
        return arr[index]+func(arr,index+1);
    }
}
