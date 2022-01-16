package sort;

// 버블정렬 - 인접한 두개의 원소를 비교-교환 방식
public class BubbleSort {
	public static void sort(int array[]) {
		int n = array.length;
		int k;
		for (int m = n; m >= 0; m--) {
			System.out.printf("\n버블 정렬 %d 단계 :\n", n-m+1);
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
		System.out.printf("\n정렬 결과 : ");
		print(a);
	}

}

/* 평균 시간 복잡도 O(n2)
 * 연산 시간 
 * - 최선: 자료가 정렬되어있는경우 
 * 		횟수: n(n-1)/2번 교환횟수: 없음
 * - 최악: 자료가 역순으로 정렬되어있는경우
 * 		횟수: n(n-1)/2번 교환횟수: n(n-1)/2번
 * */
