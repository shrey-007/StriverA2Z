package Greedy.easy;

public class CoinChange {
    // This is DP question, you can't do it using greedy
    // This will work with greedy only if coins[]={1,2,5,10,20,50,100}...
    // yaha i,i+1 ka sum i+2 se chota hai, isliye greedy work krega, but if arr[]={1,5,6,9} esa hota and 11 chaiye hota
    // toh greedy galat ans dega. coz 5+6<11 false hai.
    // In real life denominations are designed in such a way ki normal people greedy se find kr ske, agar kuch toh bhi
    // denominations bana denge toh shopkeepers ko DP lagani padegi
}
