
public class BinaryHeap {
	
	private int[] arr = new int[10];
	private int size = 0;
	
	public void grow_heap(){
		int[] new_arr = new int[arr.length*2];
		System.arraycopy(arr, 0, new_arr, 0, arr.length);
		arr = new_arr;

	}
	
	public void swap (int[]arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		
	}
	
	public void add(int n){
		if(arr.length == size)
			grow_heap();
		arr[size++] = n;
		int index = size -1;
		int parent = (index-1)/2;
		while(index > 0 && arr[index] < arr[parent]){
			swap(arr, index, parent);
			index = parent;
			parent = (index-1)/2; 
		}	
			
	}
	public int left_child(int index){
		return (index*2)+1;
	}
	public int right_child(int index){
		return (index*2)+2;
	}
	
	public int remove(){
		int temp = arr[0];
		arr[0]= arr[--size];
		bubbledown(0);
		return temp;
	}
	
	public void bubbledown(int index){
		if(left_child(index)< size){
			int child = left_child(index);
			if(right_child(index) < size && arr[right_child(index)] < arr[child]){
				child = right_child(index);
			}
			if(arr[index] > arr[child]){
				swap(arr, index, child);
			}
		bubbledown(child);	
	}
	
}
}