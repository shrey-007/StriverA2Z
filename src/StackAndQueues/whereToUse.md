WHENEVER ith INDEX KE KAARAN (0 to i-1) INDEXES MAI CHANGE HO LIKE DELETION, TOH US CASE MAI AGAR LIST/STRING/ARRAY USE KRA TO PROBLEM HOTI HAI,
KIUKI TUM US LIST PAR TRAVERSE KR RHE HO AND USI MAI DELETION KR RHE HO TOH DELETE KRTE HI TUMHARA CURRENT INDEX CHANGE HO JAAEGA.
TOH ESE CASES MAI STACK USE KRO JESE HI ith ELEMENT PR AAYE TOH STACK MAI (0 to i-1) ELEMENTS ALREADY HOGE UNKO CONDITION KE ACCORDING DELETE KRO
AND USSE INDEXING PAR FARAK NHI PADEGA KUKI TRAVERSE TUM GIVEN QUESTION KE DATA STRUCTURE PAR KR RHE HO AND CHANGES TUM STACK MAI KR RHE(JISME INDEXING NI HOTI)

### Interesting stuff
Stacks are a versatile data structure that follow the Last-In, First-Out (LIFO) principle. They are used in various scenarios where this behavior is advantageous. Here are some common cases where stacks are particularly useful:

1. Reversing Data
   Since stacks operate on a LIFO principle, they are ideal for reversing the order of data. For example, reversing a string or list.
2. Expression Evaluation
   Stacks are used to evaluate expressions, particularly those in postfix (Reverse Polish Notation) and infix notations. They help in parsing and evaluating expressions by managing the order of operations.
3. Syntax Parsing
   Compilers and interpreters often use stacks to check for balanced parentheses, brackets, or braces in code. This is also applicable in validating XML/HTML tags.
4. Function Call Management
   The call stack is a stack structure used by most programming languages to manage function calls and their local variables. When a function is called, its context is pushed onto the stack, and when it returns, its context is popped off.
5. Backtracking Algorithms
   Stacks are useful in algorithms that require backtracking, such as depth-first search (DFS) in graphs or solving puzzles like mazes and the N-Queens problem.
6. Undo Mechanisms
   Applications that provide undo functionality, like text editors, often use stacks to keep track of actions. Each action is pushed onto the stack, and an undo operation pops the last action.
7. Recursive Algorithms
   While recursion implicitly uses the call stack, some recursive algorithms can be implemented iteratively using an explicit stack, which can help avoid stack overflow errors.
8. Tree Traversals
   In-order, pre-order, and post-order tree traversals can be implemented using stacks, especially when converting recursive tree traversal algorithms to iterative ones.
9. Stack-Based Memory Management
   Some programming languages, particularly lower-level ones like C, use stacks for memory management, especially for managing local variables within functions.
10. Browser History
    Browsers use stacks to manage the history of visited pages. Each time you visit a new page, it's pushed onto the stack, and using the back button pops the top page off the stack to return to the previous page.