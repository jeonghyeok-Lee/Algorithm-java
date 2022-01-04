package list;

import java.util.NoSuchElementException;

public class AryList {
	public class ArrList <E> {
		private  E a[];     
	    private  int size;  
	    //������
		public  ArrList() { 
	        a = (E[]) new Object[1];  
	        size = 0;                
	    }
	    // k��° �׸��� ã��
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
	    	if (size == a.length)   			// �迭�� ���� á�� ���	   
	    		resize(2*a.length);			   	// �迭�� ũ�⸦ 2��� 
	    	for (int i = size-1; i >= k; i--)  	// �迭�� ������ �κк��� k��° �׸���� ��ĭ�� �ڷ� �̵�
	    		a[i+1] = a[i];  
	    	a[k] = item;						// k��°�� �׸� �߰�
	    	size++;
	    }
	    
		// �迭 ������� Ȯ��
	    public boolean isEmpty() {
	    	return size == 0;
	    }
	    

	    public E delete(int k) {  
			if (isEmpty()) throw new NoSuchElementException(); // underflow �߻��� ���α׷� ����
			E item = a[k];
			for (int i = k; i <size; i++)  a[i] = a[i+1];  
			size--;
			if (size > 0 && size == a.length/4) // ���� �迭 ũ�⺸�� 1/4�� ���� �Ѵٸ�
				resize(a.length/2); 			// �迭�� ũ�⸦ 1/2�� ����ϱ�
			return item;
	    }
	    
	    
	    // �迭�� ũ�⸦ �缳��
		private void resize(int newSize) {		
			Object[] t = new Object[newSize];   
			for (int i = 0; i < size; i++)
				t[i] = a[i];                    
			a = (E[]) t;                     
		}
	}
}
