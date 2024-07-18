1. Time-: Teeno traversal mai saare nodes 1 baar visit hoti hai toh O(N) hai teeno ki
2. Space-: The space complexity mainly depends on the depth of the recursion stack, which is related to the height of the tree. Kiuki dekho jab apan root se start krte hai toh left jaate rehte hai and jab leftmost node pahuchte hai toh total nodes jo stack mai hai vo height of leftmost branch hoga ab jab vo use print krega toh backtrack krke uper jaaega and us node ko hataega and right node ko daalega stack mai toh. Ek gyi toh doosri aayi.  
Toh simply space-: O(height)  
Best case-: O(logn) (Balanced Binary Tree)  
Worst case-: O(N) (skewed Binary Tree)

