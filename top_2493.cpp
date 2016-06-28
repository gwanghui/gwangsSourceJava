#include <iostream>
#include <stack>
using namespace std;
 
stack<int*> s;
int N = 0;
int values[500000][2];
int result[500000];
int main(int argc, char* argv) {
 
    scanf("%d", &N);
    for (int i = 0; i < N; i++) {
        scanf("%d", &values[i][0]);
        values[i][1] = i;
    }
 
    s.push(values[N - 1]);
 
    for (int i = N - 2; i >= 0; i--) {
        int* before = values[i + 1];
        int* current = values[i];
        if (current[0] > before[0] && !s.empty()) {
            while (!s.empty()) {
                int* check = s.top();
                if (current[0] > check[0]) {
                    result[check[1]] = current[1] + 1;
                    s.pop();
                } else {
                    break;
                }
            }
             
        }
        s.push(current);
    }
 
    for (int i = 0; i < N; i++) {
        printf("%d ",result[i]);
    }
 
    return 0;
}
