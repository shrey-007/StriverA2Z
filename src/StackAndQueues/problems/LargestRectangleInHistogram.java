package StackAndQueues.problems;

public class LargestRectangleInHistogram {

    /**
     * Concept-:
     * 1) ith index ki heigth ka rectangle agar banana hai toh uski width = [previousSmallerElement,nextSmallerElement] ke beech hogi.
     *
     * Examples dekh lo-:
     * 1) 2nd index ki height 5 hai, 5 heigth ka rectangle 3rd index se combine hojaayega kiuki uski height 6 hai but vo
     *    1st index se combine nhi hoga kiuki uski heigth 1 hai. means 5 height ka rectangle 2,3 index pr combine hokr ban jaaega
     *
     * 2) 4th index ki height 2 hai, 2 heigth ka rectangle 2,3,5 indexes se combine hojaayega kiuki unki height 5,6,3 hai but vo
     *    1st index se combine nhi hoga kiuki uski heigth 1 hai. means 2 height ka rectangle 2,3,4,5 index pr combine hokr ban jaaega
     *
     * 3) Toh concept ye hai ki agar uske just left ya right mai mai usse bada heigth ka hai toh combine krlo else nhi ho paaega
     *    Toh agar ye dekhna hai ki kab tak right mai combine kr skte hai toh right mai nextSmallerElement nikaalo like 5 height vaale ka nextSmallerElement 2 height vaala hai toh vo usse combine nhi hoga but usse pehele tak combine ho skta hai
     *    Toh agar ye dekhna hai ki kab tak left mai combine kr skte hai toh left mai previousSmallerElement nikaalo like 5 height vaale ka previousSmallerElement 1 height vaala hai toh vo usse combine nhi hoga but usse baad se hojaega , but uske baad toh vo khud hi hai toh vo left mai kisi se combine nhi kr paaega.
     *
     * 4) You need NGE concept here
     * */
    public static int largestRectangleArea(int[] heights) {

        int nse[]=new int[heights.length];
        int pse[]=new int[heights.length];

        nse=nse(heights);
        pse=pse(heights);

        int ans=Integer.MIN_VALUE;

        for (int i = 0; i < heights.length; i++) {

            int currHeight=heights[i];

            int indexOfNextSmallerElement=nse[i];
            int indexOfPreviousSmallerElement=pse[i];

            int width=(indexOfNextSmallerElement-1)-(indexOfPreviousSmallerElement+1)+1;

            if(currHeight*width>ans){ans=currHeight*width;}
        }

        return ans;
    }

    public static int[] nse(int [] heights){
        //implement it
        return null;
    }

    public static int[] pse(int [] heights){
//        implement it
        return null;
    }

}
