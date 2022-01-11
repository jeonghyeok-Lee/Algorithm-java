package queue;

import java.util.NoSuchElementException;

public class AryQueue<E> {
	private E[] q;
	private int front , rear , size;	// front-> ù��° �� ���� ����Ŵ(����Ű�� ������ ���� ����) rear -> ������ ���� ����Ŵ
	
	public AryQueue() {
		q = (E[]) new Object[2]; 
		front = rear = size = 0;
	}
	
	public int size() {return size;}
	public boolean isEmpty() {return front==rear;}
	
	public void add(E item) {
		if((rear + 1) % q.length == front) 	// ����ִ� ������ ������ 1���� ��� �� ť�� ���� ������ ���
			resize(2*q.length);				// ť�� ������ Ű���
		rear = (rear+1) % q.length;			
		q[rear] = item;
		size++;
	}
	
	public E remove() {
		if(isEmpty())
			throw new NoSuchElementException();	
		front = (front + 1) % q.length;			// ���� front�� ��ġ�� ��ĭ ������ �̵�(���� ����)
		E item = q[front];						// ���� front�� ��ġ �迭�� ��
		q[front] = null;						// ���� front ��ġ �迭 ���� null�� �����Ͽ� ����
		size--;									// ������ �ϳ� ���̱�
		if (size > 0 && size == q.length / 4) 
			resize(q.length / 2); 
		return item;
	}
	
	private void resize(int newSize) {
		Object[] t = new Object[newSize]; 
		for (int i = 1, j = front + 1; i < size + 1; i++, j++) {
			t[i] = q[j % q.length]; 
		}
		front = 0;
		rear = size;
		q = (E[]) t; 
	}
	
	public void print() {
		if (isEmpty())
			System.out.print("ť�� ������ϴ�.");
		else {
			for (int i = 0; i < q.length; i++)
				System.out.print(q[i] + "\t ");
			System.out.println();
		}
	}
	
}
