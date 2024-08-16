package SlidingWindowAndTwoPointer.medium;

public class MaximumPointsYouCanObtainFromCards {
    /**
     * supppose k=5
     * toh what options do you have?
     * take all 5 from left
     * take 4 from left and 1 from right
     * take 3 from left and 2 from right
     * take 2 from left and 3 from right
     * take 1 from left and 4 from right
     * take all 5 from right
     * Means you have k+1 options. So run a loop k+1 times
     * */
    public int maxScore(int[] cardPoints, int k) {
        int numberOfElementsTakenFromLeft=k;
        int numberOfElementsTakenFromRight=0;
        int currSum=0;
        int ans=0;
        int n=cardPoints.length;

        while (numberOfElementsTakenFromLeft!=-1){
            // sum up left elements
            for (int i = 0; i < numberOfElementsTakenFromLeft; i++) {
                currSum=currSum+cardPoints[i];
            }

            // sum up right elements
            for (int i = n-1; i >n-numberOfElementsTakenFromRight-1; i--) {
                currSum=currSum+cardPoints[i];
            }

            // update the ans
            ans=Math.max(ans,currSum);

            // go to next case
            numberOfElementsTakenFromLeft--;
            numberOfElementsTakenFromRight++;
            currSum=0;
        }

        return ans;
    }


    // tum har case ke liye dubaara se answer calculate kr rhe ho, since there are k cases and tumhe k elements add krna
    // hai har case mai , so it is taking k^2 time complexity

    // Better way is ki jab tumne left se 5 liye and right se 0 and us samay currSum=S hai agar toh
    // left se 4 and right se 1 lene ke liye vaapis calculate krne se achha S-arr[4]+arr[n-1] kro

    public int maxScore2(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = 0;

        // Calculate the total sum of the first 'k' cards from the beginning
        for (int i = 0; i < k; i++) {
            totalSum += cardPoints[i];
        }

        // Initialize 'ans' with 'totalSum' as one potential maximum score
        int ans = totalSum;

        // Slide the window by removing one card from the left and adding one card from the right
        for (int i = 0; i < k; i++) {
            totalSum = totalSum - cardPoints[k - 1 - i] + cardPoints[n - 1 - i];
            ans = Math.max(ans, totalSum);
        }

        return ans;
    }


}
