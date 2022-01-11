package queue;

import java.util.NoSuchElementException;

public class AryQueue<E> {
	private E[] q;
	private int front , rear , size;	// front-> 첫번째 값 앞을 가리킴(가리키는 곳에는 값이 없음) rear -> 마지막 값을 가리킴
	
	public AryQueue() {
		q = (E[]) new Object[2]; 
		front = rear = size = 0;
	}
	
	public int size() {return size;}
	public boolean isEmpty() {return front==rear;}
	
	public void add(E item) {
		if((rear + 1) % q.length == front) 	// 비어있는 원소의 개수가 1개일 경우 즉 큐가 가득 차있을 경우
			resize(2*q.length);				// 큐의 사이즈 키우기
		rear = (rear+1) % q.length;			
		q[rear] = item;
		size++;
	}
	
	public E remove() {
		if(isEmpty())
			throw new NoSuchElementException();	
		front = (front + 1) % q.length;			// 현재 front의 위치를 한칸 앞으로 이동(값이 존재)
		E item = q[front];						// 현재 front의 위치 배열의 값
		q[front] = null;						// 현재 front 위치 배열 값을 null로 변경하여 제거
		size--;									// 사이즈 하나 줄이기
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
			System.out.print("큐가 비었습니다.");
		else {
			for (int i = 0; i < q.length; i++)
				System.out.print(q[i] + "\t ");
			System.out.println();
		}
	}
	
}
