package Greedy.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a set of n jobs where each job has a deadline and profit associated with it.
 *
 * Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit associated
 * with a job if and only if the job is completed by its deadline.
 *
 * Find the number of jobs done and the maximum profit.
 *
 * Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job. Deadline of the job is the
 * time on or before which job needs to be completed to earn the profit.*/
public class JobSequencing {

    // Concept-: delay the jobs to the end days, bilkul last mai kaam kro jab deadline khatam hone vaali hai
    // since hume max profit chaiye toh start with the job jo max profit de
    int[] JobScheduling(Job arr[], int n){

        // sort the jobs according to profit
        Arrays.sort(arr, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.profit-o2.profit;
            }
        });

        // find the job with last deadline, jiske baad koi job nhi kr skte
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].deadline > maxi) {
                maxi = arr[i].deadline;
            }
        }

        // we have maxi number of days to do n jobs
        // create array to store which job will be done on which day
        int result[] = new int[maxi + 1];

        // initialse the result with -1, means abhi koi job assign nhi hui kisi bhi din par
        for (int i = 1; i <= maxi; i++) {
            result[i] = -1;
        }

        // now start iterating on arr, which is sorted on profit , max profit vaali job uthao and use deadline ke just pehle
        // complete kro
        int countJobs = 0, jobProfit = 0;

        for (int jobId = 0; jobId < n; jobId++) {

            for (int day = arr[jobId].deadline; day > 0; day--) {

                // Free slot found
                if (result[day] == -1) {
                    result[day] = jobId;
                    countJobs++;
                    jobProfit += arr[jobId].profit;
                    break;
                }
            }
        }

        int ans[] = new int[2];
        ans[0] = countJobs;
        ans[1] = jobProfit;
        return ans;





    }

    class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }
}
