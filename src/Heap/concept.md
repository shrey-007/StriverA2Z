1. If you have an array and uske saare elements tumne min heap mai daal diye hai. Toh top k elements of the heap denote smallest k elements.Top of heap denotes the smallest element and kth element denotes kth smallest element. Time complexity-: 0(NlogN)
2. But if you fill min heap to only k size and agar current element is larger than the peek toh tum pop kro and current ko push kro. Toh agar ye algorithm use kroge toh heap will store k largest elements of array. Top of the heap will store kth largest element.Lowest element will the largest element. Time complexity-: 0(NlogK)