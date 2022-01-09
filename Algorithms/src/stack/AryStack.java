package stack;
import java.util.EmptyStackException;
public class AryStack<E> {
	private E s[];				// 값을 넣기 위한 배열
	private int top;			// 최상단 값을 찾기 위한 top변수 배열 인덱스
	public AryStack() {
		s = (E[]) new Object[1];
		top = -1;
	}
	
	public int size() {return top+1;}
	public boolean isEmpty() {return top == -1;}
	
	// 최상단의 값을 가져오기
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
		Object[] re =new Object[newSize]; 	// newsize크기의 배열 생성
		for(int i = 0; i<size(); i++) {		// 반복문을 통해 새로 만들어진 배열에 값 넣기
			re[i] = s[i];
		}
		s = (E[]) re;						// 원래 배열을 새로 만들어진 배열로 변경
	}
	
	public E pop() {
		if(isEmpty()) 
			throw new EmptyStackException();
		E item = s[top];					// 현재 최상단 값 가져오기
		s[top--] = null;					// 현재 top이 가리키는 값을 null로 바꾸고 1 감소
		if(size() > 0 && size() == s.length/4)	// 크기가 만약 1/4보다 작을 경우 사이즈를 절반으로
			resize(s.length/2);		
		return item;						// 항목 전달
	}
	
	public void print() {
		if (isEmpty())
			System.out.print("배열이 비었습니다.");
		else
			for (int i = 0; i < size(); i++)
				System.out.print(s[i] + "\t ");
		System.out.println();
	}
}
