package Arrays.hard;

import java.util.ArrayList;

public class CountInversions {
    // method 1 is simple 2 for loops

    // method 2 mai ese socho ki 2 sorted arrays hai
    // [2,3,5,6] and [2,2,4,4,8]
    // and i tumhe 1st array se lena hai and j tumhe 2nd array se lena hai
    /**
     * [2,3,5,6]   [2,2,4,4,8]
     *  i           j  toh yaha arr[i]>arr[j] nahi hai toh socho kaha jaoge, tumhe chaiye ki left array vala bada ho
     *  right array vale se, toh tum i++ karoge na.
     *
     *  [2,3,5,6]  [2,2,4,4,8]
     *     i        j         abhi arr[i]>arr[j] hai toh left array mai i ke baad jitne bhi elements hai voh sab bhi
     *  arr[j] se bade hai, toh total pairs 3. {3,2}{5,2}{6,2}. Toh is j ko bada do ab
     *
     *  [2,3,5,6]  [2,2,4,4,8]
     *     i          j         abhi arr[i]>arr[j] hai toh left array mai i ke baad jitne bhi elements hai voh sab bhi
     *  arr[j] se bade hai, toh total pairs 3. {3,2}{5,2}{6,2}. Toh is j ko bada do ab
     *
     *  [2,3,5,6]  [2,2,4,4,8]
     *     i            j         abhi arr[i]>arr[j] nahi hai toh i++ kro
     *
     *  [2,3,5,6]  [2,2,4,4,8] abhi arr[i]>arr[j] hai toh left array mai i ke baad jitne bhi elements hai voh sab bhi
     *       i          j
     *  arr[j] se bade hai, toh total pairs 2. {5,4}{6,4}. Toh is j ko bada do ab.
     *
     *  and so on. Toh ye question agar esa hota 2 sorted vala toh easy hota, toh ise esa bana do, isme merge sirt lagao
     *  merge function mai tumhe 2 sorted arrays milege unse coun nikaal lena inverse pairs ka, and unko merge bhi kr dena
     *
     *  means count bhi krte jaaoa and sort bhi krte jaao
     *
     * */



    // method 2 we use mergeSort, watch striver video get how its working or if you can dry run mergeSort it will easy for you

    private static int merge(int[] arr, int low, int mid, int high) {

        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //Modification 1: cnt variable to count the pairs:
        int cnt = 0;

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                cnt += (mid - left + 1); //Modification 2
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        return cnt; // Modification 3
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2 ;
        cnt += mergeSort(arr, low, mid);  // left half
        cnt += mergeSort(arr, mid + 1, high); // right half
        cnt += merge(arr, low, mid, high);  // merging sorted halves
        return cnt;
    }

    public static int numberOfInversions(int[] a, int n) {
        // Count the number of pairs:
        return mergeSort(a, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1};
        int n = 5;
        int cnt = numberOfInversions(a, n);
        System.out.println("The number of inversions are: " + cnt);
    }

}
