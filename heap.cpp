#include <stdio.h>
using namespace std;
void swap(int &a, int &b){
	int temp = a;
	a = b;
	b = temp;
}


struct heap{
	int size = 0;
	int arr[300000];
	bool isEmpty(){
		return size == 0;
	}
	
	void add(int value){
		size++
		int idx = size;
		arr[idx] = value;
		
		while(idx > 1){
			int parent = idx >> 1;
			if(arr[parent] < value){
				break;
			}
			swap(arr[parent],arr[idx]);
			idx = parent;
		}
	}
	
	void remove(){
		arr[0] = arr[size];
		size--;
		int idx = 1;
		while((idx << 1) <= size){
			int t_idx , t_value  = arr[idx];
			int child = idx << 1;
			if(arr[child] < t_value){
				t_idx = child;
				t_value = arr[child];
			}
			
			child++;
			if(child <= size && arr[child] < t_value){
				t_value = arr[child];
				t_idx = child;
			}
			
			if(t_value == arr[idx]){
				break;
			}
			swap(arr[child],arr[idx]);
			idx = t_idx;
		}
	}
}heap;

int sort(int arr[100000][3], int left, int right) {
    int temp, l = left, r = right;
    int pivot = arr[(left + right) / 2][2];
    while (l <= r) {
        while (pivot > arr[l][2]) l++;
        while (pivot < arr[r][2]) r--;
        if (l <= r) {
            swap(&arr[l][0], &arr[r][0]);
            swap(&arr[l][1], &arr[r][1]);
            swap(&arr[l][2], &arr[r][2]);
            l++;
            r--;
        }
    }
    if (l < right) sort(arr, l, right);
    if (left < r) sort(arr, left, r);
}


int main(int argc, char** argv) {

	return 0;
}
