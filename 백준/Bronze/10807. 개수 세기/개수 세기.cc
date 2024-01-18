#include <iostream>
int main() {
    int num,v;
    int answer =0;
    scanf("%d", &num);
    int arr[num];
    for(int i=0; i<num; i++){
        scanf("%d", &arr[i]);
    }
    scanf("%d", &v);
    for(int i=0; i<num; i++){
        if(v == arr[i]){
            answer++;
        }
    }
    printf("%d", answer);
    return 0;
}