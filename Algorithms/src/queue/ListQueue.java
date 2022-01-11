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
		Node newItem = new Node(item,null);	// ���ο� �׸� ����	
		if(isEmpty())						// ���� ����ִٸ� front�� ���ο� �������� ����Ŵ
			front = newItem;
		else
			rear.setNext(newItem);			// ���� ������� �ʴٸ� ���� rear�� ����Ű�� ���� ��带 newItem���� ����
		rear = newItem;						// rear�� ����Ű�� ��带 newItem���� ����
		size++;
	}
	
	public E remove() {
		if(isEmpty())
			throw new NoSuchElementException();
		E frontItem = front.getItem();			// ���� front�� ����Ű�� �ִ� ����� �������� frontItem�� ����
		front = (Node<E>) front.getNext();		// ���� front�� ����Ű�� �ִ� ��带 front�� ����Ű�� ���� ���� ����
		if(isEmpty())
			rear = null;						// ���� ��尡 ���ٸ� rear�� null�� ����Ű����
		size--;
		return frontItem;
	}
	public void print() { 
		if (isEmpty())
			System.out.print("ť�� ������ϴ�.");
		else
			for (Node p = front; p != null; p = p.getNext())
				System.out.print(p.getItem() + "\t ");
		System.out.println();
	}
	
}
