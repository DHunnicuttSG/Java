package org.example.MyStrings;

public class MyStringBuffer {
    public static void main(String[] args) {
        final String myString = "This is a test, this is only a test.";

        useStringBuffer2Reverse(myString);
        useForLoop2Reverse(myString);

    }

    public static void useStringBuffer2Reverse(String str) {
        StringBuffer sbf = new StringBuffer(str);
        System.out.println(sbf.reverse());
    }

    public static void useForLoop2Reverse(String str) {
        char[] myStr = str.toCharArray();
        for (int i = myStr.length-1; i>= 0; i--){
            System.out.print(myStr[i]);
        }
    }
}
