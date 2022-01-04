package list;

import java.util.NoSuchElementException;

public class AryList {
	public class ArrList <E> {
		private  E a[];     
	    private  int size;  
	    //생성자
		public  ArrList() { 
	        a = (E[]) new Object[1];  
	        size = 0;                
	    }
	    // k번째 항목을 찾기
	    public E find(int k) {  
	  		if (isEmpty()) 
	  			throw new NoSuchElementException(); 
	  		return a[k];
	      }
	    
	    public void insertLast(E item) {        
	        if (size == a.length)   	
	        	resize(2*a.length);  	
	         a[size++] = item;    	
	    }
	        
	    public void insert(E item, int k) { 
	    	if (size == a.length)   			// 배열이 가득 찼을 경우	   
	    		resize(2*a.length);			   	// 배열의 크기를 2배로 
	    	for (int i = size-1; i >= k; i--)  	// 배열의 마지막 부분부터 k번째 항목까지 한칸씩 뒤로 이동
	    		a[i+1] = a[i];  
	    	a[k] = item;						// k번째에 항목 추가
	    	size++;
	    }
	    
		// 배열 비었는지 확익
	    public boolean isEmpty() {
	    	return size == 0;
	    }
	    

	    public E delete(int k) {  
			if (isEmpty()) throw new NoSuchElementException(); // underflow 발생시 프로그램 정지
			E item = a[k];
			for (int i = k; i <size; i++)  a[i] = a[i+1];  
			size--;
			if (size > 0 && size == a.length/4) // 만약 배열 크기보다 1/4만 차지 한다면
				resize(a.length/2); 			// 배열의 크기를 1/2로 축소하기
			return item;
	    }
	    
	    
	    // 배열의 크기를 재설정
		private void resize(int newSize) {		
			Object[] t = new Object[newSize];   
			for (int i = 0; i < size; i++)
				t[i] = a[i];                    
			a = (E[]) t;                     
		}
	}
}
