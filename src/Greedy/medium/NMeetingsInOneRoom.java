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

    // Common sense is ki don't attend the longer meeting kuiki us time ek hi meeting kr paoge, instead us time mai 2 choti choti meeting krlo
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
