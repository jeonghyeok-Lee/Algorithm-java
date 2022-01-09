package list;

// 노드 만들기
public class Node<E> {
	private E item; 			// 항목
	private Node<?> next;			// 다음 항목을 가리키는 노드타입형 변수
	
	private Node<?> previous;		// 현재 노드 앞에 있는 노드를 가리키는 노드타입형 변수
	
	// SinglyList 클래스에서 사용하는 노드용 생성자
	public Node(E item, Node<?> head) {
		this.item = item;
		next = head;
	}
	
	// DoublyLinkedList 클래스에서 사용하는 노드용 생성자
	public Node(E item, Node<?> previous, Node<?> next) {	// 항목, 앞노드, 뒷노드
		this.previous = previous;
		this.item = item;
		this.next = next;
	}
	
	// 현재 항목 가저오기
	public E getItem(){return item;}
	// 다음 항목 가져오기 
    public Node<?> getNext(){return next;}
    
    // 현재 항목을 해당 항목을 바꾸기
    public void setItem(E item){this.item = item;}
    
    // 현재 가리키고 있는 다음 노드를 해당 노드로 바꾸기
    public void setNext(Node<?> next) {this.next = next;}
    
    // DoublyLinkedList사용을 위한 추가적인 메소드
    
    public Node<?> getPrevious() {return previous;}
    public void setPrevious(Node<?> p) { previous = p;}
	
}
