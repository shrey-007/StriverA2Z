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
    // ans atribute which will change in accordingly, let z
}
```

The z attribute is 
1. parent in cycle detection
2. time in rotten oranges
3. nearest 0 in ZeroOneMatrix