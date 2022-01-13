package sort;

// �迭�� ���ĵ� �κа� ���ĵ��� ���� �κ����� ���������ְ�
// ���� �ȵ� �κ��� ���� ���ʺκ��� ���Ҹ� ���ĵ� ���� �κп� �����ϴ� ����� ����
public class InsertionSort {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int i = 1; i<N;i++) {				//i�� ���� ������ �ε���
			for (int j = i; j > 0; j--) {		// ���� ���Ҹ� ���ĵ� �� �κп� ����
				if(isless(a[j], a[j-1])) {
				swap(a, j, j-1);
				print(a);
				}
				else
					break;
			}
			System.out.printf("\n�������� %d �ܰ� : ", i);
			print(a);
		}
	}
	
	private static boolean isless(Comparable v, Comparable w) {
		return (v.compareTo(w) < 0);
	}

	private static void swap(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private static void print(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + (i<a.length-1? ", ":"\n"));
		}
	}
	
	public static void main(String[] args) {
		Comparable[] a = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		InsertionSort.sort(a);
		System.out.printf("\n���� ���:  ");
		print(a);
	}
}
