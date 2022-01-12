package sort;
import java.lang.Comparable;

public class SelectionSort {
	public static void sort(Comparable[] a) {
		int N = a.length;					// N-> Ž���� �׸���� ����
		int i,j;							// i-> ������ �ʿ��� ��ġ(min���� ����� ��ġ), j-> i���� ������ Ž���ϱ� ���� �ε���
		for(i = 0; i<N;i++) {				// �����ϱ�
			int min = i;					// min-> i��ġ���� �������� ���� ���� ���� �ִ� ���� �ε��� ��ȣ
			for(j= i+1; j<N ;j++) {			// min���� ã�� i+1���� ���������� Ž���ϸ鼭
				if(isless(a[j], a[min]))	//
					min = j;
			}
			swap(a,i,min);
			System.out.printf("\n���� ���� %d�ܰ� : ",i+1);
			print(a);
		}
	}
	
	private static boolean isless(Comparable i, Comparable j) {	// Ű�� ��
		return (i.compareTo(j) < 0);							// i�� j�� ���Ͽ� j�� ũ�ų� ���ٸ� false�� i�� ũ�ٸ� true
	}
	
	private static void swap(Comparable[] a, int i, int j) { 	// ���� ��ȯ
		Comparable temp = a[i];									
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static void print(Comparable[] input) {				// ���ĵ� ���� ���
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + (i<input.length-1? ", ":"\n"));
		}
	}
	
//	public static void main(String[] args) {
//		Integer a[] = {69, 10, 30, 2, 16, 8, 31, 22};
//		SelectionSort.sort(a);
//		System.out.printf("\n���� ���: ");
//		print(a);
//	}
}
