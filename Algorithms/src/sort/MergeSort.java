package sort;

import java.lang.Comparable;

/*
 * 합병정렬 
 * - 하나의 리스트를 2개의 균등한 리스트로 분할 후 부분 리스트 정렬 이후 두 리스트를 하나의 리스트로 병합
 * - 실제 정렬이 이루어지는 시점=> 2개의 리스트를 합병하는 단계 
 * 분할정복 알고리즘(Divide -and - Conquer)
 * */
public class MergeSort {
	private static void merge(Comparable[] a, Comparable[] b,int low, int mid, int high) {
		int i = low, j = mid+1;
		for(int k = low; k <= high; k++) { 	// 배열 a의 앞부분과 뒷부분을 합병하여 보조배열 b에 저장
			if(i > mid) 					// 앞부분이 먼저 소진될 경우
				b[k] = a[j++];
			else if(j>high) 				// 뒷부분이 먼저 소진
				b[k] = a[i++];
			else if(isless(a[j],a[i]))		// merge()호출
				b[k] = a[j++];				// a[j]가 승자
			else 
				b[k] = a[j++];				// a[i]가 승자
		}
		//merge이후 수행결과를 알아보기위한 곳이기에 굳이 필요하지않음
		for(int k = low; k <= high; k++) {	// 보조배열 b를 배열 a에 복사
			a[k] = b[k];
		}
		System.out.printf("합병 정렬>> ");
		print(a);
	}
	
	private static void sort(Comparable[] a, Comparable[] b, int low, int high) {
		if (high <= low)					// 항목의 길이가 1보다 작을 경우
			return;
		int mid = low + (high - low) / 2;
		sort(a, b, low, mid); 				// 앞부분 재귀 호출
		sort(a, b, mid + 1, high); 			// 뒷부분 재귀 호출
		merge(a, b, low, mid, high); 		// 합병 수행
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
		System.out.print("합병 결과 : ");
		print(a);
	}

}
