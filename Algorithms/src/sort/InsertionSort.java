package sort;

// 배열이 정렬된 부분과 정렬되지 않은 부분으로 나누어져있고
// 정렬 안된 부분의 가장 왼쪽부분의 원소를 정렬된 원소 부분에 삽입하는 방식의 정렬
public class InsertionSort {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int i = 1; i<N;i++) {				//i는 현재 원소의 인덱스
			for (int j = i; j > 0; j--) {		// 현재 원소를 정렬된 앞 부분에 삽입
				if(isless(a[j], a[j-1])) {
				swap(a, j, j-1);
				print(a);
				}
				else
					break;
			}
			System.out.printf("\n선택정렬 %d 단계 : ", i);
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
		System.out.printf("\n정렬 결과:  ");
		print(a);
	}
}
