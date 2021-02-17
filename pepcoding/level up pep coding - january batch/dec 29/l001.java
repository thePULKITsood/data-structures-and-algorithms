// import java.util.Scanner;
// import java.util.ArrayList;

// public class l001{
//     public static Scanner scn = new Scanner (System.in);

    
//         public static void numDecodings(String s) {
            
//           int count = decoding(s,0);
//             System.out.println(count); 
//     }
    
//     public static int decoding( String s ,int idx)
//     {
//         int count = 0 ;
            
//             if (idx == s.length() )
//             {  
//                 return 1 ;
//             }
            
//             if (s.length() >= 1)
//             {
//                 int  ch = (s.charAt(idx) - '0');
                          
//                 if (ch!=0)
//                 {
//                     count += decoding(s,idx+1);
//                 }
//             }
            
//             if (s.length ()>=2)
//             {
//                 int  ch1 = (s.charAt(idx) - '0');
//                 int  ch2 = (s.charAt(idx+1) - '0');
                
//                 int ch = 10*ch1 + ch2;
               
                
//                 if (ch>=10 && ch<=26 )
//                 {
//                     count += decoding(s,idx+2);
//                 }
//             }
//             return count ;
            
//         }





//     public static void main(String[] args) {
//     solve();
// }

// public static void solve() {
// String s = scn.nextLine();
//     numDecodings(s);

// }
// }

import java.io.*;
import java.util.*;

public class l001{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> paths = getStairPaths(n);
        System.out.println(paths);

    }

    public static ArrayList <String> getStairPaths(int n) {
        
        if (n<0)
        {ArrayList<String> base =new  ArrayList<String> ();
            return base ;
            //return empty base 
        }
        
        if (n==0)
        {
            ArrayList<String> base =new  ArrayList<String> ();
            base.add("");
            return base;
        }
        
        ArrayList<String> bigans = new ArrayList<String> ();
    // small ans for one 
    if (n>=1)
    {
        ArrayList<String> smallans1 =   getStairPaths(n - 1);
        
        for (String ans :smallans1)
        {
            bigans .add("1"+ans);
        }
    }
    if (n>=2)
    {
        ArrayList<String> smallans2 =  getStairPaths(n - 2);
        
        for (String ans :smallans2)
        {
            bigans .add("2"+ans);
        }
    }
    if (n>=3)
    {
        ArrayList<String> smallans3 =  getStairPaths(n - 3);
        
        for (String ans :smallans3)
        {
            bigans .add("3"+ans);
        }
        
    }
    return bigans;
    
        
    }

}