package sort;
import java.lang.Comparable;

public class SelectionSort {
	public static void sort(Comparable[] a) {
		int N = a.length;					// N-> 탐색할 항목들의 길이
		int i,j;							// i-> 정렬이 필요한 위치(min값과 변경될 위치), j-> i부터 끝까지 탐색하기 위한 인덱스
		for(i = 0; i<N;i++) {				// 정렬하기
			int min = i;					// min-> i위치에서 끝까지중 가장 작은 값이 있는 곳의 인덱스 번호
			for(j= i+1; j<N ;j++) {			// min값을 찾기 i+1부터 마지막까지 탐색하면서
				if(isless(a[j], a[min]))	//
					min = j;
			}
			swap(a,i,min);
			System.out.printf("\n선택 정렬 %d단계 : ",i+1);
			print(a);
		}
	}
	
	private static boolean isless(Comparable i, Comparable j) {	// 키를 비교
		return (i.compareTo(j) < 0);							// i와 j를 비교하여 j가 크거나 같다면 false를 i가 크다면 true
	}
	
	private static void swap(Comparable[] a, int i, int j) { 	// 값을 교환
		Comparable temp = a[i];									
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static void print(Comparable[] input) {				// 정렬된 값을 출력
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + (i<input.length-1? ", ":"\n"));
		}
	}
	
//	public static void main(String[] args) {
//		Integer a[] = {69, 10, 30, 2, 16, 8, 31, 22};
//		SelectionSort.sort(a);
//		System.out.printf("\n정렬 결과: ");
//		print(a);
//	}
}
