package sort;

// 삽입정렬에 전처리 과정을 추가 => 한자리씩 이동하는 단점을 보완
// 전처리 과정 -> 작은 값을 가진 원소들을 배열의 앞부분으로 옮겨 뒷부분에 큰 값이 오도록 하는 과정
// 주로 임베디드 시스템에 많이 사용 -> 입력이 크지 않은 경우에 좋은 성능
// 수행시간 = 간격의 설정 여부
public class ShellSort {
	// h-정렬: 간격이 h인 원소들끼리 정렬하는 것
	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 4;								// 3x+1 간격: 1,4,13,40...중에서 4와 1만 사용
		while (h >= 1) {						
			for (int i = h; i < N; i++) { 		// h정렬 수행 
				for (int j = i; j >= h && isless(a[j], a[j - h]); j -= h) {
					swap(a, j, j - h);
					System.out.printf("쉘정렬 %d-단계 : ", h);
					print(a);
				}
			}
			//h /= 3;		
			h -=1;			// 1칸 줄이기 h를 조절함에 따라 수행시간이 달라짐
		}
	}
	
	private static boolean isless(Comparable v, Comparable w) {
		return (v.compareTo(w) < 0);
	}

	private static void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private static void print(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + (i < a.length - 1 ? ", " : "\n"));
		}
	}
	
	public static void main(String[] args) {
		Comparable[] a = { 69, 10, 30, 2, 16, 8, 31, 22 };
		ShellSort.sort(a);
		System.out.printf("쉘정렬 결과:  ");
		print(a);
	}

}
