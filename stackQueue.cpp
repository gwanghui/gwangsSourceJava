#include <stdio.h>
#include <iostream>
#include <stack>
#include <queue>
#include <deque>
using namespace std;

stack<int> s;
queue<int> q;
deque<int> dequ;
int main(int argc, char* args) {
	
	s.push(1);
	s.push(2);
	s.push(3);
	s.push(4);
	s.push(5);
	while (!s.empty()) {
		printf("%d \n", s.top());
		s.pop();
	}
	
	q.push(1);
	q.push(2);

	printf("%d \n", q.front());
	q.front();
	printf("%d \n", q.front());
	
	q.swap(queue<int>());
	if (q.empty()) {
		printf("yahhoo");
	}
	return 0;
}
