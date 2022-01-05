package list;

// 노드 만들기
public class Node<E> {
	private E item; 			// 항목
	private Node<E> next;		// 다음 항목을 가리키는 노드타입형 변수
	
	// 생성자 
	public Node(E item, Node<E> node) {
		this.item = item;
		next = node;
	}
	
	// 현재 항목 가저오기
	public E getItem(){
		return item;
	}
	// 다음 항목 가져오기 
    public Node getNext(){ 
    	return next;
    }
    
    // 현재 항목을 해당 항목을 바꾸기
    public void setItem(E item){ 
    	this.item = item;
    }
    
    // 현재 가리키고 있는 다음 노드를 해당 노드로 바꾸기
    public void setNext(Node next){
    	this.next = next;
    }
	
}
