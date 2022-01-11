package stack;

import java.util.EmptyStackException;
import list.Node;

public class ListStack<E> {
	private Node<E> top;
	private int size;
	
	public ListStack() {
		top = null;
		size = 0;
	}
	
	public int size() {return size;}
	public boolean isEmpty() {return size == 0;}
	
	public void push(E item) {
		Node newNode = new Node(item,top);
		top = newNode;
		size++;
	}
	
	public E find() {
		if(isEmpty())
			throw new EmptyStackException();
		return top.getItem();
	}
	
	public E pop() {
		if(isEmpty())
			throw new EmptyStackException();
		E topItem = top.getItem();				// 현재 top가 가리키는 노드의 항목을 가져오기
		top = (Node<E>) top.getNext();			// 현재 top가 가리키는 노드의 다음 노드를 가리키도록
		size--;
		return topItem;
	}
	
	public void print() { 
		if (isEmpty())
			System.out.print("스택이 비었습니다.");
		else
			for (Node p = top; p != null; p = p.getNext())
				System.out.print(p.getItem() + "\t ");
		System.out.println();
	}
	
}
