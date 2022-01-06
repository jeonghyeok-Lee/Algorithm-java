package list;

import java.util.NoSuchElementException;

public class SinglyList<E extends Comparable<E>> {

	protected Node<?> head;	// ù��° ��带 ����Ű�� ���Ÿ�� ����
	private int size;		
	
	public Node<?> getHead() {return head;}
	public void setHead(Node<?> n) {head =n;}
	
	//������
	public SinglyList() {
		head = null;
		size = 0;
	}
	
	public int size() {return size;}
	public boolean isEmpty() {return size ==0;}
	
	// target���� ������ �׸��� �ε����� ã��
	public int search(E target) {
		Node<?> p = head;
		for(int k =0; k<size;k++) { 				//0������ size��ŭ �ݺ�
			if(target == p.getItem()) 				//�ش� �׸��� ���� �ϸ� �ش� �ε����� ����
				return k;
			p = p.getNext();
		}
		return -1; 									 // �ش� ����Ʈ�� ���� ��� -1flxjs
	}
	
	
	// ����Ʈ �� �� �κп� �׸��� �߰�
	public void insertFront(E nItem) {
		head = new Node(nItem, head); 				// ��庯���� ���Ӱ� ������ ��带 ����Ŵ
		size++;							// 
	}
	
	// ����Ʈ �߰��� �׸��� �߰��ϱ�
	public void insertAfter(E nItem, Node<?> p) { 		// ���� �߰��� ��带 ����ų ���Ÿ�Ժ��� p
		p.setNext(new Node(nItem, p.getNext())); 	// p�� ���� �߰��� ��带 ����Ű���� �Ѵ�.
		size++;										// ���� �߰��� ���� ���� p�� ����Ű�� ��带 ����Ű����
	}
	
	// ����Ʈ �� �� �׸��� �����ϱ�
	public void deleteFront() {
		if(size == 0)								// �׸��� ����� ���
			throw new NoSuchElementException();
		head = head.getNext();						
		size--;
	}
	
	// ����Ʈ �߰�(p����)�� �׸��� �����ϱ�
	public void deleteAfter(Node<?> p) {
		if(p == null)
			throw new NoSuchElementException();
		Node<?> t = p.getNext();						// ���� p�� ����Ű�� ��� ���� t��
		p.setNext(t.getNext());						// p�� ����Ű�� ���� ��带 t�� ����Ű�� ���� ����
		t.setNext(null);							// t�� ����Ű�� ��尪�� null�� �ٽ� ����
		size--;
	}
	
	public void print(){  
		for (Node p = head; p != null; p = p.getNext()) 
			System.out.print(p.getItem()+"\t ");
		System.out.println();
	}
}
