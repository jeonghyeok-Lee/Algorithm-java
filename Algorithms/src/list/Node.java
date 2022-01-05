package list;

// ��� �����
public class Node<E> {
	private E item; 			// �׸�
	private Node<E> next;		// ���� �׸��� ����Ű�� ���Ÿ���� ����
	
	// ������ 
	public Node(E item, Node<E> node) {
		this.item = item;
		next = node;
	}
	
	// ���� �׸� ��������
	public E getItem(){
		return item;
	}
	// ���� �׸� �������� 
    public Node getNext(){ 
    	return next;
    }
    
    // ���� �׸��� �ش� �׸��� �ٲٱ�
    public void setItem(E item){ 
    	this.item = item;
    }
    
    // ���� ����Ű�� �ִ� ���� ��带 �ش� ���� �ٲٱ�
    public void setNext(Node next){
    	this.next = next;
    }
	
}
