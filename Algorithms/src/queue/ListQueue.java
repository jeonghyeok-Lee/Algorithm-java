package queue;

import java.util.NoSuchElementException;
import list.Node;

public class ListQueue<E> {
	private Node<E> front, rear;
	private int size;
	
	public ListQueue() {
		front = rear = null;
		size = 0;
	}
	
	public int size(){return size;}
	public boolean isEmpty() {return size()==0;}
	
	public void add(E item) {
		Node newItem = new Node(item,null);	// 새로운 항목 생성	
		if(isEmpty())						// 만약 비어있다면 front가 새로운 아이템을 가리킴
			front = newItem;
		else
			rear.setNext(newItem);			// 만약 비어있지 않다면 현재 rear가 가리키는 다음 노드를 newItem으로 변경
		rear = newItem;						// rear가 가리키는 노드를 newItem으로 변경
		size++;
	}
	
	public E remove() {
		if(isEmpty())
			throw new NoSuchElementException();
		E frontItem = front.getItem();			// 현재 front가 가리키고 있는 노드의 아이템을 frontItem에 전달
		front = (Node<E>) front.getNext();		// 현재 front가 가리키고 있는 노드를 front가 가리키던 다음 노드로 변경
		if(isEmpty())
			rear = null;						// 만약 노드가 없다면 rear는 null을 가리키도록
		size--;
		return frontItem;
	}
	public void print() { 
		if (isEmpty())
			System.out.print("큐가 비었습니다.");
		else
			for (Node p = front; p != null; p = p.getNext())
				System.out.print(p.getItem() + "\t ");
		System.out.println();
	}
	
}
