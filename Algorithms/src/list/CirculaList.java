package list;
import java.util.NoSuchElementException;
// 원형 연결 리스트 -> 마지막 노드가 첫 노드와 연결된 singlyList
public class CirculaList<E> {
	private Node last;
	private int size;
	
	// 생성자
	public CirculaList() {
		last = null;
		size = 0;
	}
	
	public int size() {return size;}
	public boolean isEmpty() {return size ==0;}
	
	//last가 가리키는 노드의 다음에 새 노드 삽입
	public void insert(E item) {
		Node newNode = new Node(item, null);
		// 리스트가 비어있다면
		if(last == null) {
			newNode.setNext(newNode);			// 새로추가된 항목은 다음노드로 자신을 가리킴
			last= newNode;						// last변수는 새로 추가된 노드를 가리킴
		}
		// 리스트에 항목이 존재한다면
		else {
			newNode.setNext(last.getNext());	// 새로 추가된 항목이 가리키는 노드는 현재 last변수가 가리키는 노드의 다음노드
			last.setNext(newNode);				// last변수가 가리키는 다음노드가 newNode가 되도록
		}
		size++;
	}
	
	// last노드가 가리키는 노드의 다음노드를 삭제 
	public Node delete() {
		if(isEmpty())
			throw new NoSuchElementException();
		Node x = last.getNext();
		// 리스트의 항목이 1개 일 경우
		if(x == last)
			last = null;
		else {
			last.setNext(x.getNext());			// last가 가리키는 다음노드를 x가 가리키는 다음노드로 변경
			x.setNext(null);					// x의 다음노드를 null로 변경해줌으로써 연결을 해제
		}
		size--;
		return x;
	}
	
	public void print(){
		if (size > 0){
			int i = 0;
			for (Node p = last.getNext(); i<size ; p = p.getNext(), i++) 
					System.out.print(p.getItem()+"\t ");
		}
		else
			System.out.println("리스트가 비었습니다..");
		System.out.println();
	}
}
