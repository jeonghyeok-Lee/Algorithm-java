package list;
import java.util.NoSuchElementException;
// ���� ���� ����Ʈ -> ������ ��尡 ù ���� ����� singlyList
public class CirculaList<E> {
	private Node last;
	private int size;
	
	// ������
	public CirculaList() {
		last = null;
		size = 0;
	}
	
	public int size() {return size;}
	public boolean isEmpty() {return size ==0;}
	
	//last�� ����Ű�� ����� ������ �� ��� ����
	public void insert(E item) {
		Node newNode = new Node(item, null);
		// ����Ʈ�� ����ִٸ�
		if(last == null) {
			newNode.setNext(newNode);			// �����߰��� �׸��� �������� �ڽ��� ����Ŵ
			last= newNode;						// last������ ���� �߰��� ��带 ����Ŵ
		}
		// ����Ʈ�� �׸��� �����Ѵٸ�
		else {
			newNode.setNext(last.getNext());	// ���� �߰��� �׸��� ����Ű�� ���� ���� last������ ����Ű�� ����� �������
			last.setNext(newNode);				// last������ ����Ű�� ������尡 newNode�� �ǵ���
		}
		size++;
	}
	
	// last��尡 ����Ű�� ����� ������带 ���� 
	public Node delete() {
		if(isEmpty())
			throw new NoSuchElementException();
		Node x = last.getNext();
		// ����Ʈ�� �׸��� 1�� �� ���
		if(x == last)
			last = null;
		else {
			last.setNext(x.getNext());			// last�� ����Ű�� ������带 x�� ����Ű�� �������� ����
			x.setNext(null);					// x�� ������带 null�� �����������ν� ������ ����
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
			System.out.println("����Ʈ�� ������ϴ�..");
		System.out.println();
	}
}
