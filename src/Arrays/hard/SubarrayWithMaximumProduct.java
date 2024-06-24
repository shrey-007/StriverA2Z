package Arrays.hard;

public class SubarrayWithMaximumProduct {

    // Just remember ki isme ans either prefix or suffix hi hota hai
    // Problem negative number nhi 0 hai
    // Toh jab bhi 0 aaye toh simply prefix=suffix=1 krdo

    public static int func(int arr[]){

        int prefix=1;
        int suffix=1;
        int ans=Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if(prefix==0){
                prefix=1;
            }
            if (suffix==0){
                suffix=1;
            }

            prefix=prefix*arr[i];

            suffix=suffix*arr[arr.length-1-i];

            ans=Math.max(ans,Math.max(prefix,suffix));

        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
