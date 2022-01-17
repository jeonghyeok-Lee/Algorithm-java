package sort;

import java.lang.Comparable;

/*
 * �պ����� 
 * - �ϳ��� ����Ʈ�� 2���� �յ��� ����Ʈ�� ���� �� �κ� ����Ʈ ���� ���� �� ����Ʈ�� �ϳ��� ����Ʈ�� ����
 * - ���� ������ �̷������ ����=> 2���� ����Ʈ�� �պ��ϴ� �ܰ� 
 * �������� �˰���(Divide -and - Conquer)
 * */
public class MergeSort {
	private static void merge(Comparable[] a, Comparable[] b,int low, int mid, int high) {
		int i = low, j = mid+1;
		for(int k = low; k <= high; k++) { 	// �迭 a�� �պκа� �޺κ��� �պ��Ͽ� �����迭 b�� ����
			if(i > mid) 					// �պκ��� ���� ������ ���
				b[k] = a[j++];
			else if(j>high) 				// �޺κ��� ���� ����
				b[k] = a[i++];
			else if(isless(a[j],a[i]))		// merge()ȣ��
				b[k] = a[j++];				// a[j]�� ����
			else 
				b[k] = a[j++];				// a[i]�� ����
		}
		//merge���� �������� �˾ƺ������� ���̱⿡ ���� �ʿ���������
		for(int k = low; k <= high; k++) {	// �����迭 b�� �迭 a�� ����
			a[k] = b[k];
		}
		System.out.printf("�պ� ����>> ");
		print(a);
	}
	
	private static void sort(Comparable[] a, Comparable[] b, int low, int high) {
		if (high <= low)					// �׸��� ���̰� 1���� ���� ���
			return;
		int mid = low + (high - low) / 2;
		sort(a, b, low, mid); 				// �պκ� ��� ȣ��
		sort(a, b, mid + 1, high); 			// �޺κ� ��� ȣ��
		merge(a, b, low, mid, high); 		// �պ� ����
	}
	
	public static void sort(Comparable[] a) {
		Comparable[] b = new Comparable[a.length];
		sort(a, b, 0, a.length - 1);
	}

	private static boolean isless(Comparable v, Comparable w) {
		return (v.compareTo(w) < 0);
	}

	private static void print(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + (i < a.length - 1 ? ", " : "\n"));
		}
	}

	public static void main(String[] args) {
		Comparable[] a = { 69, 10, 30, 2, 16, 8, 31, 22 };
		MergeSort.sort(a);
		System.out.print("�պ� ��� : ");
		print(a);
	}

}
