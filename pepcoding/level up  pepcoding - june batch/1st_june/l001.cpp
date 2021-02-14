#include <iostream>
#include <vector>
#include <string>

using namespace std;

// void set1()
// {
//       int a,b;
//      cin>>a>>b;
//       printIncDec(a,b);

//     int a, b;
//     cin >> a >> b;

//     cout << powerSqrt(a, b) << endl;
// }
// void printIncDec(int a, int b)
// {
//     if (a == b + 1)
//     {
//         return;
//     }
//     cout << a << " hi " << endl;
//     printIncDec(a + 1, b);
//     cout << a << " bye " << endl;
// }
// int fact(int n)
// {
//     // if (n< = 1 ) return 1 ;
//     // return fact (n-1 ) * n ;
//     return n <= 1 ? 1 : fact(n - 1) * n;
// }

// int power(int a, int b)
// {
//     return b == 0 ? 1 : power(a, b - 1) * a;
// }
// int powerSqrt(int a, int b)
// {
//     // basecase

//     if (b == 0)
//         return 1;

//     int ans = powerSqrt(a, b / 2);
//     ans *= ans;
//     return b % 2 == 0 ? ans : ans * a;
// }

// void display(vector<int> &arr, int idx) // & hamesha lagana hai during passing vector

// {
//     if (idx == arr.size())
//         return;

//     cout << arr[idx] << " ";
//     display(arr, idx + 1);
// }

// int maximum(vector<int> &arr, int idx)
// {
//     if (idx == arr.size() - 1)
//         return arr[idx];

//     return max(maximum(arr, idx + 1), arr[idx]);
//     // in java
//     // return Math.max(smallMax,arr[idx]);
// }

// bool find(vector<int> &arr, int data, int idx)
// {
//     if (idx == arr.size())
//         return false;

//     if (arr[idx] == data)
//         return true;

//     return find(arr, data, idx + 1);
// }

// void set2()
// {
//     vector<int> arr = {1, 45, 67, 456, 345, 5, 454324, 34, 14, 1, 4312, 4};
//     //10 size ka vector with default int as zero
//     display(arr, 0);
//     cout << endl;
//     cout << maximum(arr, 0) << endl;

//     if (find(arr, 5, 0))

//     {
//         cout << "true";
//     }
//     else
//     {
//         cout << "false";
//     }
// }

vector<string> subseq(string str)
{
    if (str.length() == 0)
    {
        vector<string> base;
        base.push_back(" ");
        return base;
    }

    char ch = str[0];            // pehla character uthaoo  java -- str.charAt(0);
    string nstr = str.substr(1); // str.subString(1);
    vector<string> ans = subseq(nstr);
    vector<string> myans;

    for (string s : ans) // for each loop   - as we are not doing anything  with settig the value
                         //  but we are using it for getting so it will work
    {                    // here we are not worried about the order we are just getting the jo  done
                         // not looking for the formatiing
        myans.push_back(s);
        myans.push_back(ch + s);
    }
    return myans;
}

int printsubseq(string str, string ans)
{
    if (str.length() == 0)
    {
        cout << ans << endl;
        return 1;
    }
    int count = 0;

    count += printsubseq(str.substr(1), ans + str[0]);
    count += printsubseq(str.substr(1), ans);

    return count;
}

void set3()
{
    string str = "abcd";
    vector<string> myans = subseq(str);

    for (string s : myans)
    {
        cout << s << endl;
    }
    cout << endl
         << endl
         << endl
         << endl;

    cout << printsubseq(str, "") << endl;
}

void solve()
{
    set3();
}

int main()
{
    solve();
    return 0;
}