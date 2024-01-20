#include <iostream>
#include <queue>
#include <vector>
using namespace std;
int main() {
    queue<int> q;
    int n,k;
    int count =1;
    int idx =0;
    cin >>n>>k;
    vector<int> v(n);
    for(int i=1; i<=n; i++){
        q.push(i);
    }
    while(!q.empty()){
        int num = q.front();
        if(count % k == 0){
            v[idx] = num;
            q.pop();
            idx++;
        }
        else{
            q.pop();
            q.push(num);
        }
        count++;
    }
    cout <<"<";
    for(int i=0; i<n; i++){
        if(i != n-1){
            cout<<v[i]<<","<<" ";
        }
        else{
            cout<<v[i]<<">";
        }
    }
    return 0;
}