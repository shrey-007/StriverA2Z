package Strings.medium;

/**
 * Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a
 * decimal place value into a Roman numeral has the following rules:
 *
 * If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input,
 * append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
 *
 * If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol,
 * for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms
 * are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
 * */
public class IntegerToRoman {
    public static String intToRoman(int num) {

        char roman[]={'I','V','X','L','C','D','M'};
        int integer[]={1,  5,  10, 50,100,500,1000};
        String ans="";

        while(num!=0){
            if(findFirstDigit(num)){
                // IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM
                int i=0;
                while (integer[i]<num){
                    i++;
                }
                if(i==1){
                    ans=ans+"IV";
                    num=num-4;
                }
                else if(i==2){
                    ans=ans+"IX";
                    num=num-9;
                }
                else if(i==3){
                    ans=ans+"XL";
                    num=num-40;
                }
                else if(i==4){
                    ans=ans+"XC";
                    num=num-90;
                }
                else if(i==5){
                    ans=ans+"CD";
                    num=num-400;
                }
                else if(i==6){
                    ans=ans+"CM";
                    num=num-900;
                }
            }
            else{
                for (int i = 6; i >=0 ; i--) {
                    if(integer[i]<=num){
                        ans=ans+roman[i];
                        num=num-integer[i];
                        break;
                    }
                }
            }

        }

        return ans;
    }

    public static boolean findFirstDigit(int num){
        while (num>=10){
            num=num/10;
        }
        return num==4 || num==9;
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3749));
    }


}
