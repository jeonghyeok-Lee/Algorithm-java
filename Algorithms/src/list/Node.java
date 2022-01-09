package list;

// ��� �����
public class Node<E> {
	private E item; 			// �׸�
	private Node<?> next;			// ���� �׸��� ����Ű�� ���Ÿ���� ����
	
	private Node<?> previous;		// ���� ��� �տ� �ִ� ��带 ����Ű�� ���Ÿ���� ����
	
	// SinglyList Ŭ�������� ����ϴ� ���� ������
	public Node(E item, Node<?> head) {
		this.item = item;
		next = head;
	}
	
	// DoublyLinkedList Ŭ�������� ����ϴ� ���� ������
	public Node(E item, Node<?> previous, Node<?> next) {	// �׸�, �ճ��, �޳��
		this.previous = previous;
		this.item = item;
		this.next = next;
	}
	
	// ���� �׸� ��������
	public E getItem(){return item;}
	// ���� �׸� �������� 
    public Node<?> getNext(){return next;}
    
    // ���� �׸��� �ش� �׸��� �ٲٱ�
    public void setItem(E item){this.item = item;}
    
    // ���� ����Ű�� �ִ� ���� ��带 �ش� ���� �ٲٱ�
    public void setNext(Node<?> next) {this.next = next;}
    
    // DoublyLinkedList����� ���� �߰����� �޼ҵ�
    
    public Node<?> getPrevious() {return previous;}
    public void setPrevious(Node<?> p) { previous = p;}
	
}
