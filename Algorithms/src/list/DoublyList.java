package list;
import java.util.NoSuchElementException;

public class DoublyList<E> {
	protected Node<?> head, tail;
	protected int size;
	
	// ������(�̱۰� �ٸ��� ���ۺ��� 2���� ��� �����ϰ� ����)
	public DoublyList() {
		head = new Node<Object>(null,null,null);	// �ƹ��͵� ����Ű�� �ʴ� ��� ����
		tail = new Node<Object>(null,head,null);	// head�� ����Ű�� tail�κ� ����
		head.setNext(tail);					// head�� ���� ��带 ����Ű�� ���� tail�� ����
		size = 0;
	}
	
	// previous�� ����Ű�� ����� ��!!!�κп� �׸��߰�
	public void insertBefore(Node<?> previous, E item) {	
		Node<?> t = previous.getPrevious();				// ���t�� previous�� ����Ű�� ��尡 ����Ű�� �ִ� ���    (([t] ->p),A,n ->)  (<- p,B,(n<-[previous]))  ��, A->B �̷��� ����Ű�� �ִ� ��
		Node<E> newNode = new Node<E>(item,t,previous);		// �߰��� ��� ����	(p,A,n) (<- p,New,n->) (p,B,n)
		previous.setPrevious(newNode);					// ���� previous�� ����Ű�� ��尡 ����Ű�� �� ��带 ���� �߰��� ���� ����  	(p,A,n) (p,New,n) (<- p,B,n)
		t.setNext(newNode);								// ��� t�� ����Ű�� ���� ��带 ���� �߰��� ���� ����	(p,A,n ->) (p,New,n) (<- p,B,n)
		size++;											// ���� ũ��
	}
	
	// previous�� ����Ű�� ����� �� �κп� �׸� �߰� ��, previous�� ���ο� ��带 ����Ų�ٴ� �ǹ�
	public void insertAfter(Node<?> previous, E item) {
		Node<?> t = previous.getNext();					// ���t�� �Էµ� previous�� ���� �ִ� ��尡 ����Ű�� �ִ� ����(�ڿ� �ִ�) ���
		Node<E> newNode = new Node<E>(item, previous, t);
		t.setPrevious(newNode);
		previous.setNext(newNode);
		size++;
	}
	
	// ���d�� ����
	public void delete(Node<?> d) {
		if(d == null) 
			throw new NoSuchElementException();
		
		Node<?> previous = d.getPrevious();			// ������ ����� �� �� ��带 ��������
		Node<?> next = d.getNext();
		previous.setNext(next);						// ������ ����� �� �� ��带 ����
		next.setPrevious(previous);
		d.setPrevious(null);
		d.setNext(null);
		size--;										// ������ ���̱�
	}
	
    public void print(){							// ���� ����Ʈ ������ �׸��� ���
		if (size > 0) 
			for (Node<?> p = head.getNext(); p != tail; p = p.getNext()) 
					System.out.print(p.getItem()+"\t ");
		else
			System.out.println("����Ʈ�� ������ϴ�.");
		System.out.println();
	}
}
