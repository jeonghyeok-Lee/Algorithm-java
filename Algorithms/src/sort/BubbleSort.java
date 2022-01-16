package sort;

// �������� - ������ �ΰ��� ���Ҹ� ��-��ȯ ���
public class BubbleSort {
	public static void sort(int array[]) {
		int n = array.length;
		int k;
		for (int m = n; m >= 0; m--) {
			System.out.printf("\n���� ���� %d �ܰ� :\n", n-m+1);
			for (int i = 0; i < n - 1; i++) {
				k = i + 1;
				if (array[i] > array[k]) {
					swap(i, k, array);
					print(array);
				}
			}
		}
	}
	
	private static void swap(int i, int j, int[] array) {
		int tmp;
		tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	private static void print(int[] input) {
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + (i<input.length-1? ", ":"\n"));
		}
	}
	
	public static void main(String[] args) {
		int[] a = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		BubbleSort.sort(a);
		System.out.printf("\n���� ��� : ");
		print(a);
	}

}

/* ��� �ð� ���⵵ O(n2)
 * ���� �ð� 
 * - �ּ�: �ڷᰡ ���ĵǾ��ִ°�� 
 * 		Ƚ��: n(n-1)/2�� ��ȯȽ��: ����
 * - �־�: �ڷᰡ �������� ���ĵǾ��ִ°��
 * 		Ƚ��: n(n-1)/2�� ��ȯȽ��: n(n-1)/2��
 * */
