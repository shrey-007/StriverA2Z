## Steps -: 
1. Hume pehle kya find krna hai voh dekho, hume 90% cases mai class banani padegi coz heap mai nodes daalege toh node class banani padegi
2. Fir dekho ki konsi cheej cell to cell vary karegi, like x,y cordinate and any other attribute, in 90% cases jo cheej find krni hai vahi vary karegi cell to cell toh node class mai ek attribute uska bhi daalo
3. Fir initial nodes ko heap mai daalo
4. Fir BFS ki loop likho
5. Also BFS,DFS mai priorityQueue use nhi krte, queue use krte hai

```java

public void bfs(){
    
    PriorityQueue<CustomClass> pq=new PriorityQueue<>();
    
    // add the initial nodes in the priorityQueue, having some initial z
        
    while(!pq.isEmpty()){
        Node curr=pq.poll();
        
        // get the details of current node
        
        // update the ans through curr.z
        
        // visit all its neighbours if they are not visited
        // before inserting the node in the queue, update its z atribute for the node only
        
    }  
    
}

class CustomClass{
    // ans atribute which will change cell to cell, let z
}
```

The z attribute is 
1. parent in cycle detection
2. time in rotten oranges
3. nearest 0 in ZeroOneMatrix