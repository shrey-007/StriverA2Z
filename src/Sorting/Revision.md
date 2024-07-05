1) BubblesSort-: 2 for loops mai if arr[i]>arr[j] toh swap  
   Time-n^2
2) SelectionSort-: 0 to n mai smallest element choose kro and use 0th index pr rakho, fir 1 to n mai smallest element choose kro and use 1st index pr rakho and son on..  
   Time-n^2
3) InsertionSort-: Ek sorted part hai , ek unsorted part hai toh unsorted part se elements ko sorted part mai bhejna hai.  
   Time-n^2  
   BestTime=n(when array is sorted toh usme 2nd loop ni chalegi)
4) MergeSort-:  
   Time-nlog(n)  
   Space-n
5) QuickSort-:select a pivot element, fir us pivot element ko apne sahi position pr rakho , then pivot se chote left side mai rakho and usse bade right side mai rakho then recursively call for  
   Time-nlog(n)  
   WorstTime=n^2(when array is sorted toh usme pivot element 1st index hoga joki smallest hoga toh uske left mai koi nhi hoga toh hamesha T(n)=T(n-1)+c hoga)
6) HeapSort-:

### We generally use quicksort because its TC is nlog(n) and it does not take any extra space, toh sabse optimised algorithm toh aani hi chaiye.
### For linkedlist we use mergesort, not quicksort
### There are only 2 exceptions quicksort mai worst n2 hota hai and insertion sort mai best n hota hai and dono tabhi hote hai jab array already sorted ho.
### MergeSort and QuickSort dono mai apan start and end paas krte hai but start hamesha 0 nhi hota toh start + index krna mt bhoolna similarly mid + index