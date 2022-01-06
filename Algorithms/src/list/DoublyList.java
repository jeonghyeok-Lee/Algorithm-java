package list;
import java.util.NoSuchElementException;

public class DoublyList<E> {
	protected Node<?> head, tail;
	protected int size;
	
	// 생성자(싱글과 다르게 시작부터 2개의 노드 생성하고 시작)
	public DoublyList() {
		head = new Node<Object>(null,null,null);	// 아무것도 가리키지 않는 노드 생성
		tail = new Node<Object>(null,head,null);	// head를 가리키는 tail부분 생성
		head.setNext(tail);					// head가 다음 노드를 가리키는 값을 tail로 세팅
		size = 0;
	}
	
	// previous가 가리키는 노드의 앞!!!부분에 항목추가
	public void insertBefore(Node<?> previous, E item) {	
		Node<?> t = previous.getPrevious();				// 노드t는 previous가 가리키는 노드가 가리키고 있는 노드    (([t] ->p),A,n ->)  (<- p,B,(n<-[previous]))  즉, A->B 이렇게 가리키고 있던 것
		Node<E> newNode = new Node<E>(item,t,previous);		// 추가할 노드 생성	(p,A,n) (<- p,New,n->) (p,B,n)
		previous.setPrevious(newNode);					// 현재 previous가 가리키는 노드가 가리키는 앞 노드를 새로 추가한 노드로 변경  	(p,A,n) (p,New,n) (<- p,B,n)
		t.setNext(newNode);								// 노드 t가 가리키는 다음 노드를 새로 추가된 노드로 변경	(p,A,n ->) (p,New,n) (<- p,B,n)
		size++;											// 현재 크기
	}
	
	// previous가 가리키는 노드의 뒷 부분에 항목 추가 즉, previous가 새로운 노드를 가리킨다는 의미
	public void insertAfter(Node<?> previous, E item) {
		Node<?> t = previous.getNext();					// 노드t는 입력된 previous를 갖고 있는 노드가 가리키고 있는 다음(뒤에 있는) 노드
		Node<E> newNode = new Node<E>(item, previous, t);
		t.setPrevious(newNode);
		previous.setNext(newNode);
		size++;
	}
	
	// 노드d를 삭제
	public void delete(Node<?> d) {
		if(d == null) 
			throw new NoSuchElementException();
		
		Node<?> previous = d.getPrevious();			// 삭제할 노드의 앞 뒤 노드를 가져오기
		Node<?> next = d.getNext();
		previous.setNext(next);						// 삭제할 노드의 앞 뒤 노드를 연결
		next.setPrevious(previous);
		d.setPrevious(null);
		d.setNext(null);
		size--;										// 사이즈 줄이기
	}
	
    public void print(){							// 연결 리스트 노드들의 항목을 출력
		if (size > 0) 
			for (Node<?> p = head.getNext(); p != tail; p = p.getNext()) 
					System.out.print(p.getItem()+"\t ");
		else
			System.out.println("리스트가 비었습니다.");
		System.out.println();
	}
}
