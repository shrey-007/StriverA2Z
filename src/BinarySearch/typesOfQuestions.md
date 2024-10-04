# Rotated Sorted Array
If arr[mid]<arr[high] then mid to high is sorted else low to mid is sorted. Yahi concept saare questions mai lagega
1. Search-: find which part is sorted, agar us sorted part ka first and last element ke beech mai target hai toh usi mai
dhoondho else doosre region mai jaao
2. Pivot-: Find which part is sorted, and us part ka min element answer ho skta hai toh use update krdo, now maybe min 
element is part mai ho hi na doosre part mai ho, toh doosre part mai jaao. Or direcly graph se socho ,Rotated sorted
array is discontinous graph toh tumhe agar arr[mid]<arr[high] dikha means tum right side pr ho toh left jaao. Else right jaao
3. In dono hi question mai problem tab aati hai jab arr[mid]=arr[low]=arr[high] toh pata nhi padta ki konsa part sorted hai, toh agar mid answer nhi hai toh low++;high--; krdo

# BS on answers
Binary search on answers is a powerful technique used to solve problems where you need to find the optimal value that satisfies certain conditions. This technique is commonly applied in problems where the solution space is monotonic, meaning the solution either strictly increases or decreases as you progress through the possible answers. Here are the formats of questions where binary search on answers can be effectively applied:

### 1. **Minimization or Maximization Problems**
- **Problem Statement:** Find the minimum or maximum value that satisfies a given condition.
- **Example:**
    - **Minimization:** Find the minimum time required to complete a set of tasks given a certain number of workers.
    - **Maximization:** Find the maximum possible length of a rope that can be cut into pieces of a given length.

### 2. **Threshold Problems**
- **Problem Statement:** Identify the smallest or largest value for which a certain condition holds true.
- **Example:**
    - Determine the smallest integer \( x \) such that a function \( f(x) \) meets a specific criterion, e.g., \( f(x) \geq k \).
    - Find the maximum distance between elements in an array such that all elements within that distance are distinct.

### 3. **Feasibility Check Problems**
- **Problem Statement:** Check whether it is possible to achieve a certain condition with a given parameter.
- **Example:**
    - Determine the minimum size of a subarray with a sum greater than or equal to a target value.
    - Find the maximum capacity that can be distributed across multiple containers such that none exceeds a certain limit.

### 4. **Optimization Problems with Constraints**
- **Problem Statement:** Optimize a certain parameter (like cost, time, or resources) under given constraints.
- **Example:**
    - Minimize the maximum load across servers in a server farm by distributing tasks.
    - Maximize profit within a given budget by selecting the optimal set of items.

### 5. **Problems Involving Intervals or Ranges**
- **Problem Statement:** Find the optimal interval or range that satisfies a certain property.
- **Example:**
    - Find the smallest window in an array that contains all elements of another array.
    - Determine the maximum length of a subarray that can be rearranged to form a palindrome.

# MAX of MIN or MIN of MAX Questions through reverse engineering


