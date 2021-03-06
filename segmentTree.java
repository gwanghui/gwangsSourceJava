package seg;

public class segmentTree {
	static int[] values;
	static int[] tree;
	public static void main(String[] args) {
		
		values = new int[16];
		//0~9 번까지 10개의 Value 넣을꺼임
		for(int i=1 ; i<=10;i++ ){
			values[i-1] = i;
		}
		int n= 10;
		int k=1;
		for(int i=1 ; i<30 ; i++){
			if((k<<i) > n){
				k= k<<i;
				break;
			}
		}
		tree= new int[k<<1];
		initSum(1,0,9);
		System.out.println(findSum(1,0,9,0,3));
		
		initMin(1,0,9);
		System.out.println(findMin(1,0,9,0,3));
		
		initMax(1,0,9);
		System.out.println(findMax(1,0,9,0,3));
		
	}
	public static int initSum(int node , int start, int end){
		if(start == end ){
			return tree[node] = values[start];
		}else{
			return tree[node] = initSum(node*2,start,(start+end)/2) + initSum(node*2+1,(start+end)/2+1,end);
		}
	}
	
	// left ~ right : 찾아야할 범위
	// start ~ end  : Node가 담당하는 구간
	public static int findSum(int node, int start, int end, int left , int right){
		// 부분합일경우 결과에 영향을 주지 않기 위해 0을 Return;
		if(left > end|| right < start ){
			return 0;
		}
		//start ~ end 구간이 left ~ right 구간안에 전부 포함되는 경우 연산해야 할 대상에 포함되므로 현재 tree의 값을 return; 
		if(left <= start && end <= right){
			return tree[node];
		}
		
		return findSum(node*2,start,(start+end)/2,left,right) + findSum(node*2+1,(start+end)/2+1,end,left,right); 
	}
	
	// Start ~ end 구간에 index가 포함되는 경우      --> 업데이트
	// start ~ end 구간에 index가 포함되지 않는 경우 --> 업데이트 안함 (index가 start보다 작거나, index가 end보다 클경우)
	public static void updateSum(int node,int start, int end , int index , int value){
		if(index < start || index > end ) {
			return;
		}
		tree[node] = tree[node] + value;
		if(start != end){
			updateSum(node*2,start,(start+end)/2,index,value);
			updateSum(node*2+1,(start+end)/2+1,end,index,value);
		}
		
	}
	
	public static int initMin(int node , int start, int end){
		if(start == end ){
			return tree[node] = values[start];
		}else{
			return tree[node] = Math.min(initMin(node*2,start,(start+end)/2) , initMin(node*2+1,(start+end)/2+1,end));
		}
	}
	
	// left ~ right : 찾아야할 범위
	// start ~ end  : Node가 담당하는 구간
	public static int findMin(int node, int start, int end, int left , int right){
		// 부분합일경우 결과에 영향을 주지 않기 위해 0을 Return;
		if(left > end|| right < start ){
			return 0;
		}
		//start ~ end 구간이 left ~ right 구간안에 전부 포함되는 경우 연산해야 할 대상에 포함되므로 현재 tree의 값을 return; 
		if(left <= start && end <= right){
			return tree[node];
		}
		
		return Math.min(findMin(node*2,start,(start+end)/2,left,right), findMin(node*2+1,(start+end)/2+1,end,left,right)) ; 
	}
	// Start ~ end 구간에 index가 포함되는 경우      --> 업데이트
	// start ~ end 구간에 index가 포함되지 않는 경우 --> 업데이트 안함 (index가 start보다 작거나, index가 end보다 클경우)
	public static void updateMin(int node, int start, int end, int index, int value){
		if(index < start || index > end){
			return ;
		}
		tree[node] = Math.min(tree[node], value);
		if(start != end){
			updateMin(node*2  ,start,(start+end)/2,index,value);
			updateMin(node*2+1,(start+end)/2+1,end,index,value);
		}
	}
	
	public static int initMax(int node , int start, int end){
		if(start == end ){
			return tree[node] = values[start];
		}else{
			return tree[node] = Math.max(initMax(node*2,start,(start+end)/2) , initMax(node*2+1,(start+end)/2+1,end));
		}
	}
	
	// left ~ right : 찾아야할 범위
	// start ~ end  : Node가 담당하는 구간
	public static int findMax(int node, int start, int end, int left , int right){
		// 부분합일경우 결과에 영향을 주지 않기 위해 0을 Return;
		if(left > end|| right < start ){
			return 0;
		}
		//start ~ end 구간이 left ~ right 구간안에 전부 포함되는 경우 연산해야 할 대상에 포함되므로 현재 tree의 값을 return; 
		if(left <= start && end <= right){
			return tree[node];
		}
		
		return Math.max(findMax(node*2,start,(start+end)/2,left,right), findMax(node*2+1,(start+end)/2+1,end,left,right)) ; 
	}
	// Start ~ end 구간에 index가 포함되는 경우      --> 업데이트
	// start ~ end 구간에 index가 포함되지 않는 경우 --> 업데이트 안함 (index가 start보다 작거나, index가 end보다 클경우)
	public static void updateMax(int node, int start, int end , int index, int value){
		if(index < start || index > end){
			return;
		}
		
		tree[node] = Math.max(tree[node], value);
		if(start != end){
			updateMax(node*2  ,start,(start+end)/2,index,value);
			updateMax(node*2+1,(start+end)/2+1,end,index,value);
		}
	}
}

