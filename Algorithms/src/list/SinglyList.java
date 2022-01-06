package list;

import java.util.NoSuchElementException;

public class SinglyList<E extends Comparable<E>> {

	protected Node<?> head;	// 첫번째 노드를 가리키는 노드타입 변수
	private int size;		
	
	public Node<?> getHead() {return head;}
	public void setHead(Node<?> n) {head =n;}
	
	//생성자
	public SinglyList() {
		head = null;
		size = 0;
	}
	
	public int size() {return size;}
	public boolean isEmpty() {return size ==0;}
	
	// target으로 지정된 항목의 인덱스를 찾기
	public int search(E target) {
		Node<?> p = head;
		for(int k =0; k<size;k++) { 				//0번부터 size만큼 반복
			if(target == p.getItem()) 				//해당 항목이 존재 하면 해당 인덱스를 리턴
				return k;
			p = p.getNext();
		}
		return -1; 									 // 해당 리스트에 없을 경우 -1flxjs
	}
	
	
	// 리스트 맨 앞 부분에 항목을 추가
	public void insertFront(E nItem) {
		head = new Node(nItem, head); 				// 헤드변수는 새롭게 생선된 노드를 가리킴
		size++;							// 
	}
	
	// 리스트 중간에 항목을 추가하기
	public void insertAfter(E nItem, Node<?> p) { 		// 현재 추가될 노드를 가리킬 노드타입변수 p
		p.setNext(new Node(nItem, p.getNext())); 	// p는 새로 추가될 노드를 가리키도록 한다.
		size++;										// 새로 추가될 노드는 현재 p가 가리키는 노드를 가르키도록
	}
	
	// 리스트 맨 앞 항목을 삭제하기
	public void deleteFront() {
		if(size == 0)								// 항목이 비었을 경우
			throw new NoSuchElementException();
		head = head.getNext();						
		size--;
	}
	
	// 리스트 중간(p다음)에 항목을 삭제하기
	public void deleteAfter(Node<?> p) {
		if(p == null)
			throw new NoSuchElementException();
		Node<?> t = p.getNext();						// 현재 p가 가리키는 노드 값을 t로
		p.setNext(t.getNext());						// p가 가리키는 다음 노드를 t가 가리키는 노드로 변경
		t.setNext(null);							// t가 가리키는 노드값을 null로 다시 설정
		size--;
	}
	
	public void print(){  
		for (Node p = head; p != null; p = p.getNext()) 
			System.out.print(p.getItem()+"\t ");
		System.out.println();
	}
}
