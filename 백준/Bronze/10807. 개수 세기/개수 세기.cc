#include <iostream>
using namespace std;
int main() {
    int num;
    int v;
    cin >> num;
    int arr[num];
    int answer =0;
    for(int i=0; i<num; i++){
        cin >>arr[i];
    }
    cin >> v;
    for(int i=0; i<num; i++){
        if(v == arr[i]){
            answer++;
        }
    }
    cout << answer;
    return 0;
}