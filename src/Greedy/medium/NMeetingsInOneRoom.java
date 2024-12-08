package Greedy.medium;

/**
 * You are given timings of n meetings in the form of (start[i], end[i]) where start[i] is the start time of meeting i
 * and end[i] is the finish time of meeting i. Return the maximum number of meetings that can be accommodated in a
 * single meeting room, when only one meeting can be held in the meeting room at a particular time.
 *
 * Note: The start time of one chosen meeting can't be equal to the end time of the other chosen meeting.
 * */
/** Basically start and end time are actual clock time. kisi meeting ka end time 4 hai toh uske baad us meeting ko nhi kr skte jiska start time 2 hai coz voh choot gyi*/
public class NMeetingsInOneRoom {
    // It is a simple question, suppose tumhe bahut saari meetings leni hai, and meetings apas mai clash kr rhi hai
    // Attend meetings such that ki tum jyaada se jyaada meetings attend kr sko. Konsi meeting pehle krna hai usse farak nhi padta. There is no order. But start and end time of meeting are of real clock time
    // Basically start and end time are actual clock time. kisi meeting ka end time 4 hai toh uske baad us meeting ko nhi kr skte jiska start time 2 hai coz voh choot gyi

    /**
     * Intution -:
     * 1. if u sort meeting on start time, and take meeting which occurs first toh voh galat ans dega. Suppose o meeting
     *     sabse pehle start hui voh bahut der tak chali toh uske kaaran tum baaki meetings attend nhi kr paaye.So it is wrong
     *
     * 2. Suppose u sort meeting on duration time (end-start), and shortest meeting attend kri. Toh take a test case
     *    (0,30),(27,33),(31,50). toh ise case mai tum (27,33) loge and 1 meeting tumhara ans aaega but tum 1,3 meeting
     *    le skte the and is case mai tumhe shortest meeting ko hi ignore krna tha. Toh ye bhi galat way hai
     *
     * 3. Suppose u sort on endtime, now jo kaam sabse pehle khatam ho rha hao use pehle krlo, jisse baaki ka krne ka time mil jaaega
     *    So this is correct way.
     *    a. sort meeting on endtime
     *    b. attend ith meeting
     *    c. check whether (i+1)th meeting start time is greater than end time of ith meeting or not if yes then attend the (i+1)th
     *        meeting and else ignore (i+1) and check for (i+2)*/
    public int maxMeetings(int n, int start[], int end[]) {

        // jo meeting jaldi khatam ho use attend kro, toh sort them according to end time
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(end[i]>end[j]){
                    int temp=end[i];
                    end[i]=end[j];
                    end[j]=temp;

                    temp=start[i];
                    start[i]=start[j];
                    start[j]=temp;
                }
            }
        }


        // first meeting will always be performed
        int count=1;
        int endTimeOfLastMeeting=end[0];

        for (int i = 1; i <n; i++) {
            if(start[i]>endTimeOfLastMeeting){
                // then we can perform this meeting
                count++;
                endTimeOfLastMeeting=end[i];
            }
        }

        return count;
    }

    // If you are asked to return order of meetings, toh simply ek class bana lo Meeting{startTime,endTime,index}. then
    // array ko iterate kro and n objects banao meeting ke, then in objects ko comparator ke through sort kro then inhe stack/list mai store krlo
    // toh jab store kroge toh Meeting ka object store kroge jisme likha hoga ki ye konse index ki meeting thi toh order pata pad jaaega

}
