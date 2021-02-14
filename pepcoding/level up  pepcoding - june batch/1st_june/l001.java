import java.util.Scanner;
import java.util.ArrayList;

public class l001 {

    public static Scanner scn = new Scanner(System.in);

    public static void printEvenOdd(int a, int b)

    {
        if (a == b + 1) {
            return;
        }
        if (a % 2 == 0)

        {
            System.out.println(a);
        }

        printEvenOdd(a + 1, b);

        if (a % 2 != 0)

        {
            System.out.println(a);
        }
    }

    public static void set1() {

        int a = scn.nextInt();
        int b = scn.nextInt();
        printEvenOdd(a, b);

    }

    public static void set2() {

        int[] arr = { 1, 45, 67, 456, 345, 5, 454324, 34, 14, 1, 4312, 4 };
        // array with size 10 and default value as 0
        // in java except primitive data types everything is made on heap and primitive
        // data types are made on stack
        // * -- not sure -- * in cpp every thing is made on stack unless we say it to
        // make on heap
        display(arr, 0);

        System.out.println();
        System.out.println(firstIndex(arr, 0, 5));

        System.out.println(lastIndex(arr, 0, 4));

        System.out.println(allIndex(arr, 0, 67, 0));
        // this will return the address of the array and not the array itself

        int answer[] = allIndex(arr, 0, 67, 0);

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }

    }

    public static void display(int[] arr, int idx) {
        if (idx == arr.length) {
            return;
        }
        System.out.print(arr[idx] + " ");
        display(arr, idx + 1);
    }

    public static int firstIndex(int[] arr, int idx, int data) {

        if (idx == arr.length)
            return -1;

        if (arr[idx] == data)
            return idx;

        return firstIndex(arr, idx + 1, data);

    }

    public static int lastIndex(int[] arr, int idx, int data) {

        if (idx == arr.length)
            return -1;

        int ans = lastIndex(arr, idx + 1, data);

        if (ans != -1) {
            return ans;
        }

        else {
            return arr[idx] == data ? idx : -1;
        }

    }

    public static int[] allIndex(int[] arr, int idx, int data, int count) {
        // rec last se bhi chala sakte hain
        // yahan pe jo hai we are using post order type of revurssion
        if (idx == arr.length)
            return new int[count];

        if (arr[idx] == data) {
            int[] ans = allIndex(arr, idx + 1, data, count + 1);
            ans[count] = idx;
            return ans;

        } else {
            int ans[] = allIndex(arr, idx + 1, data, count);
            return ans;
        }

    }

    public static String[] words = { ":;/", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz", "&*%",
            "!@$" };

    public static void set3() {

        // System.out.println(nokiaKeyPad1("1010"));

        // System.out.println(nokiaKeyPad2("1010", ""));

        // System.out.println(printEncodings("10123", ""));
        // System.out.println("pulkit sood ");

    }

    public static ArrayList<String> nokiaKeyPad1(String str) {
        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = str.charAt(0);
        ArrayList<String> ans = nokiaKeyPad1(str.substring(1));

        String word = words[ch - '0'];
        ArrayList<String> myans = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (String s : ans) {
                myans.add(word.charAt(i) + s);
            }
        }

        return myans;
    }

    public static int nokiaKeyPad2(String str, String ans)

    {

        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }

        char ch = str.charAt(0);
        String newques = str.substring(1);
        String word = words[ch - '0'];

        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            count += nokiaKeyPad2(newques, ans + word.charAt(i));
        }

        if (str.length() > 1) {
            char ch2 = str.charAt(1);
            int num = (ch - '0') * 10 + (ch2 - '0');

            if (num >= 10 && num <= 11) {
                word = words[num];
                for (int i = 0; i < word.length(); i++) {
                    count += nokiaKeyPad2(str.substring(2), ans + word.charAt(i));
                }
            }
        }
        return count;
    }

    public static void set4() {
        System.out.println(printEncodings("1423", ""));
        System.out.println("pulkit sood ");
    }

    public static int printEncodings(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        char ch = str.charAt(0);

        if (ch == '0') {
            return 0;
        }

        String nstr = str.substring(1);
        count += printEncodings(nstr, ans + (char) (ch - '0' + 'a' - 1));

        if (str.length() > 1) {
            char ch2 = str.charAt(1);
            int num = (ch - '0') * 10 + (ch2 - '0');

            if (num >= 10 && num <= 25) {
                nstr = str.substring(2);
                count += printEncodings(nstr, ans + (char) (num + 'a' - 1));
            }
        }

        return count;
    }

    public static void solve() {

        set4();

    }

    public static void main(String[] args) {
        solve();
    }
}