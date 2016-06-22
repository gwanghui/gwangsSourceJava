package testUnionFind;

import java.util.Arrays;

public class Main {
	static int[] parent;
	static int[] rank;
	public static void main(String[] args) {
		parent = new int[10];
		Arrays.fill(parent, -1);
		System.out.println(find(2));
		union(0,1);
		union(2,3);
		union(4,5);
		union(6,7);
		
		union(0,2);
		union(4,6);
		
		union(0,4);
		
		System.out.println();
	}
	
	public static void union(int i, int j){
		int iParentIndex = find(i);
		int jParentIndex = find(j);
		
		int temp = parent[iParentIndex] + parent[jParentIndex];
		if(parent[iParentIndex] > parent[jParentIndex]){
			parent[i] = jParentIndex;
			parent[j] = temp;
		}else{
			parent[j] = iParentIndex;
			parent[i] = temp;
		}
		
	}
	
	public static int find(int i){
		while(true){
			if(parent[i] < 0){
				return i;
			}else {
				i = parent[i];
			}
		}
	}
	
	
	
	
}
