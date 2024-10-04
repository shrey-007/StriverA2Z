package BinarySearch.Anwers;

import java.util.ArrayList;
import java.util.Arrays;

public class BookAllocation {
    /**
     * Given an array ‘arr’ of integer numbers, ‘arr[i]’ represents the number of pages in the ‘i-th’ book.
     * There are ‘m’ number of students, and the task is to allocate all the books to the students.
     * Allocate books in such a way that:
     * 1. Each student gets at least one book.
     * 2. Each book should be allocated to only one student.
     * 3. Book allocation should be in a contiguous manner.

     * You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum.
     * If the allocation of books is not possible, return -1.
     * */

    /**
     * First understand problem carefully, If you have this doubt then read this-:
     *
     * Doubt-: if the pages[]={12,23,45,90} and number of students are 4. Means each student will get one book, so max
     *         number of pages 1st student got is 12, max number of pages 2nd student got is 23, 3rd got 45, 4th got 90.
     *         Minimum of them is 12, so it should be answer
     * The goal is not just to allocate books such that each student gets one book and then pick the minimum of those values.
     * Instead, the objective is to minimize the maximum number of pages that any student has to read, after the books
     * have been distributed.
     * Since the number of students equals the number of books, each student will indeed get exactly one book. Therefore,
     * the maximum number of pages any student will have to read is the largest book in the array, which is 90. This is
     * the correct maximum value among the distributions.
     *
     * However, the goal is to minimize the maximum number of pages that any student reads, not to find the minimum of
     * those maximums for individual students. Since each student has to read at least one book, and the largest book
     * contains 90 pages, there’s no way to reduce the maximum below this value without changing the problem constraints
     * (like allowing students to share a book).
     * */

    /** So the problem is ki book distribution ke saare combinations mai se vo students nikaalo jinne sabse jyaada padha
     * like in above example 90 vaale ne sabse jyaada padha. Unka min nikaalo
     * */

    //---------------------------------------------------------------------------------------------------------------
    // if number of student(m) > number of books(n) toh -1 hi ans hai
    // else means ki n>m hai toh one answer always exists ki 0 to m-2 books ko 0 to m-2 student ko dedo remaining n-m+1
    // books ko last student ko dedo
    // But we want ki min allocate ho toh it is BS question

    /**
     * pages[]={25 46 28 49 24} and number of students are 4
     * Distribution-:
     * [25],[46],[28],[49,24]- sabse jyaada vaale ne 73 pages padhe
     * [25,46],[28],[49],[24]- sabse jyaada vaale ne 71 pages padhe
     * [25],[46,28],[49],[24]-sabse jyaada vaale ne 74 pages padhe
     * [25],[46],[28],[49,24]-sabse jyaada vaale ne 73 pages padhe
     * So ans is 71, ok Now how to solve using BS? see these are the answers 73,71,74 out of them min was the 71
     *
     * So do reverse enginnering start from 49 check kro kya sabse jyaada vaale ne 49 pages padhe esa ho skta hai kya?
     * Toh har bachhe ne 49 ya usse kam pages padhe hai toh esa krna possible hai kya ye check kro
     * 1st student- 25 pages padhe ab check kro kya voh 46 pages aur padh skta hai kya ans is no coz max 49 pages hi padhne hai, toh only 25 pages book is allocated to him
     * 2nd student- 46 pages padhe ab check kro kya voh 28 pages aur padh skta hai kya ans is no coz max 49 pages hi padhne hai, toh only 46 pages book is allocated to him
     * 3rd student- 28 pages padhe
     * 4th student- 49 padhe
     * 5th student- 24 padhe
     * means ki agar max pages read by student 49 hai toh 5 student lagege but number of students are 4 toh, max oages read ko badana padega, so check for 50,51...
     *
     * Check ki 70 ans ho skta hai kya?
     * 1st- 25 only[agar 46 aur padhe toh 73 ho jaaega but max 70 krna hai]
     * 2nd- 46
     * 3rd- 28
     * 4th- 49
     * 5th-24
     * isme bhi 5 students ki need padi
     *
     * Check ki 71 ans ho skta hai?
     * 1st- 25,46
     * 2nd- 28
     * 3rd- 49
     * 4th- 24
     * Toh ye ho gya 4 students mai toh ye ans hai, ab iske aage vaale saare ans hai and peeche vaala koi nhi hai
     *
     * */

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // low is max of arr, high is sum of all elements of arr
        int low=0;
        int high=0;


        for (int i:arr){
            low=Math.max(low,i);
            high=high+i;
        }

        int ans=Integer.MAX_VALUE;

        while (low<=high){
            int mid=(low+high)/2;

            // if mid can be ans toh ans ko update kro and peeche jaao coz min chaiye
            if(predicate(arr,m,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                // since mid is not ans toh aage jaao
                low=mid+1;
            }
        }

        return ans;
    }

    public static boolean predicate(ArrayList<Integer> arr,int studentsAvailable,int maxPagesReadByStudent){
        int currentStudent=1;
        int pagesReadByCurrentStudent=0;

        for (int i:arr){
            if(pagesReadByCurrentStudent+i<=maxPagesReadByStudent){
                pagesReadByCurrentStudent=pagesReadByCurrentStudent+i;
            }
            else{
                pagesReadByCurrentStudent=i;
                currentStudent++;
            }
        }

        // current student is the count of students jinki requirement lagi, ye kam ya equal hone chaiye real no. of students se
        return currentStudent<=studentsAvailable;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list= (ArrayList<Integer>) Arrays.asList(25,46,28,49,24);
        System.out.println(findPages(list, list.size(),4));
    }
}
