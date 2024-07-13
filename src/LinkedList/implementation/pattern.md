### 1. Why create SinglyLinkedList class, why not directly create Node class?  
   The SinglyLinkedList class is created to encapsulate the operations and behavior of a linked list. The Node class represents the structure of a single element, while the SinglyLinkedList class provides methods to manipulate the list (like adding, removing, and printing nodes). This separation of concerns makes the code more modular, maintainable, and easier to understand.

### 2. Why create an inner class, you could have created Node class separately?
   Creating the Node class as an inner class has a few advantages:

Encapsulation: The Node class is tightly coupled with the SinglyLinkedList class and doesn't need to be exposed outside of it. Keeping it as an inner class helps encapsulate the implementation details.  
Logical grouping: Since the Node class is only relevant within the context of the SinglyLinkedList class, it makes sense to group them together.  
Simplified access: The inner class can access the private members of the outer class, which can simplify certain operations.  
However, it's also perfectly valid to create the Node class separately if you prefer.

### 3. Why is the Node class private?
   The Node class is made private to encapsulate the internal structure of the linked list. This ensures that the implementation details are hidden from the users of the SinglyLinkedList class, promoting encapsulation and preventing misuse or unintended manipulation of the list's internal structure.