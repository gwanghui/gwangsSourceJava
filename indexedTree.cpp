#include <stdio.h>
using namespace std;
int indexedTree[300000];
int values[200000];
int initSum(int node , int start , int end){
	if(start == end){
		return indexedTree[node] = values[start];
	}else{
		return indexedTree[node] = initSum(node*2,start,(start+end)/2) + initSum(node*2+1,(start+end)/2+1,end);
	}
}

int findSum(int node , int start, int end, int left,int right){
	if(right < start || end < left){
		return 0;
	}
	if(left <= start && end <= right){
		return indexedTree[node];
	}else{
		return findSum(node*2,start,(start+end)/2 , left , right) +
		       findSum(node*2+1,(start+end)/2+1,end , left , right);
	}
}

void updateSum(int node , int start, int end , int index, int value){
	if(index < start || end < index){
		return;
	}
	
	indexedTree[node] += value;
	if(start != end){
		updateSum(node*2,start,(start+end)/2 , index , value);
	    updateSum(node*2+1,(start+end)/2+1,end , index , value);
	}
}

int main(int argc, char** argv) {
	for(int i=0 ;i<10 ;i++){
		values[i] = i+1;
	}
	initSum(1,0,9);
	printf("%d\n" , findSum(1,0,9,0,3));
	printf("%d\n" , findSum(1,0,9,4,9));
	printf("%d\n" , findSum(1,0,9,0,9));
	
	updateSum(1,0,9,0,1);
	
	printf("%d\n" , findSum(1,0,9,0,3));
	printf("%d\n" , findSum(1,0,9,4,9));
	printf("%d\n" , findSum(1,0,9,0,9));
	return 0;
}
