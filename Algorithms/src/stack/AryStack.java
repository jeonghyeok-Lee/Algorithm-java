package stack;
import java.util.EmptyStackException;
public class AryStack<E> {
	private E s[];				// ���� �ֱ� ���� �迭
	private int top;			// �ֻ�� ���� ã�� ���� top���� �迭 �ε���
	public AryStack() {
		s = (E[]) new Object[1];
		top = -1;
	}
	
	public int size() {return top+1;}
	public boolean isEmpty() {return top == -1;}
	
	// �ֻ���� ���� ��������
	public E find() {
		if(isEmpty()) 
			throw new EmptyStackException();
		return s[top];
	}
	
	public void push(E item) {
		if(size() ==s.length)
			resize(2*s.length);
		s[++top] = item;
	}
	
	public void resize(int newSize) {
		Object[] re =new Object[newSize]; 	// newsizeũ���� �迭 ����
		for(int i = 0; i<size(); i++) {		// �ݺ����� ���� ���� ������� �迭�� �� �ֱ�
			re[i] = s[i];
		}
		s = (E[]) re;						// ���� �迭�� ���� ������� �迭�� ����
	}
	
	public E pop() {
		if(isEmpty()) 
			throw new EmptyStackException();
		E item = s[top];					// ���� �ֻ�� �� ��������
		s[top--] = null;					// ���� top�� ����Ű�� ���� null�� �ٲٰ� 1 ����
		if(size() > 0 && size() == s.length/4)	// ũ�Ⱑ ���� 1/4���� ���� ��� ����� ��������
			resize(s.length/2);		
		return item;						// �׸� ����
	}
	
	public void print() {
		if (isEmpty())
			System.out.print("�迭�� ������ϴ�.");
		else
			for (int i = 0; i < size(); i++)
				System.out.print(s[i] + "\t ");
		System.out.println();
	}
}
