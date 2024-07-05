1) Here 7 is not stored as 7 in memory of computer but it is stored as 32 bit binary number 00000000000000000000000000000111, where leftmost bit is reserved for sign. 
```java
int x=7;
```
Whenever we want to print x, it first converts the binary to decimal and then prints.

2) 1's complement - flip all bits
3) 2's complement - first do 1's complement and then add 1 to it
4) How does computer store x=-13 ? 
```text
It first converts find binary of 13 which comes out to be
00000000000000000000000000001101
Then it finds its 2's complement so first find 1's complement
11111111111111111111111111110010
Now add 1 to it
11111111111111111111111111110011
So this is how -13 is stored
```
   
### OPERATORS
1) AND(&)   
```java
// in questions where we have to find a number is even or odd toh modulo se jyaada fast & operator hota hai
if(num&1==1)
```
2) OR(|)  
3) XOR(^) - if number of 1 are odd then it will give 1 else 0  
4) RIGHT SHIFT(>>) -
```java
int x=13;
// x = 1101
x=x>>1; // right shift mai right ki taraf number ko kheechte hai toh rightmost number gayab ho jaata hai toh left most mai ek zero extra add ho jaata ahi (simply it is divided by 2)
// x = 110
// x>>k means x/(2^k)
// In Binary search questions when we find mid most of the people use this
int mid=(low+high)>>1;
```
5) LEFT SHIFT(<<) -
```java
int x=13;
// x = 1101
x=x<<1; // left shift mai left ki taraf number ko kheechte hai toh leftmost number gayab ho jaata hai toh right most mai ek zero extra add ho jaata ahi (simply it is multiply by 2)
// x = 1010
// x>>k means x*(2^k)
// The problem is you can not left shift the INTEGER.MAX_VALUE
```
5) NOT(~)- It first flips all the bits and then checks if the resultant is negative than it does 2's complement else it stops 
```text
~5=-6
~-6=5
```