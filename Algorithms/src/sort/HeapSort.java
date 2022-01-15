package sort;

// �� ����-> �� �ڷᱸ���� �̿��� ����
// �� �ڷᱸ��-> (binary heap) �ִ�/�ּڰ��� ã�Ƴ��� ���� ������ ���� ������� ���� ����Ʈ�� ���̽� �ڷᱸ��
public class HeapSort {
	public static void sort(Comparable[] a) {
		int heapSize = a.length-1;				// a[0]�� ��� x (-1)
		for (int i = heapSize/2 - 1; i > 0; i--)	// heap ����
			downheap(a,i,heapSize);			
		while(heapSize > 1) {					// heap ����
			swap(a,1,heapSize--);				// a[1](���� ������ ���� ū ���� ����)�� ������ ���ҿ� ��ȯ
			downheap(a,1,heapSize);
		}
			
	}

	private static void downheap(Comparable[] a, int p, int heapSize) {
		while (2 * p <= heapSize) {
			int s = 2 * p; 								// s -> ���� �ڽ�(���) �ε��� 
			System.out.printf("�θ� ��ġ :%d(%d), �ڽ� ��ġ %d(%d, %d)\n", p, a[p], s, a[s], a[s+1] );
			print(a);
			if (s < heapSize && isless(a[s], a[s + 1])) // ���� ������ ��尡 ũ�ٸ�
				s++; 	
			if (!isless(a[p], a[s]))					// �θ� �ڽ� ���� ���� ũ�ٸ� �� ���� 
				break; 									// -> break;
			swap(a, p, s); 								// �θ� �ڽĳ�庸�� �۴ٸ� 
			p = s; 										// �θ����� ���� ���� ū �ڽĳ���� �ڸ��� �̵�
			print(a);
		}
	}
	
	private static boolean isless(Comparable i, Comparable j) {
		return (i.compareTo(j) < 0);
	}

	private static void print(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			System.out.print(a[i] + (i < a.length - 1 ? ", " : "\n"));
		}
	}

	private static void swap(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args) {
		Comparable[] a = { 0, 69, 10, 30, 2, 16, 8, 31, 22 };
		HeapSort.sort(a);
		System.out.printf("heapSort ���: ");
		print(a);
	}
}

/* 
 * ��������� ���� ���� -> O(N) 
 * ��Ʈ�� ���� ������ ��� ��ȯ �� downheap() ���� -> O(logN)
 * ��Ʈ�� ���� ������ ��带 ��ȯ�ϴ� Ƚ�� -> N-1
 * => O(N) + (N-1)*O(logN) = O(NlogN) [���� ����ð�]
 * => ��� �Է��̵� �ּ� O(NlogN)�� ���� -> ���� ū�� ��� �ʿ�� ����
 * 
 * */

