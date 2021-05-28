// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function Template for C++

class Solution{
  public:
    bool isPalin(int N)
    {
        //Your code here
        //You may use a helper function if you like
        int val = 0;
        int temp = N;
        while(temp != 0){
            val = val*10 + temp%10;
            temp = temp/10;
        }
        return val == N;
    }
};

// { Driver Code Starts.

int main() {
	int T;
	cin>>T;
	while(T--) 
	{
	    int N;
	    cin>>N;
	    Solution obj;
	    cout<<obj.isPalin(N)<<endl;
	}
	return 0;
}  // } Driver Code Ends