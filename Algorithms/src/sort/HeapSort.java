package sort;

// 힙 정렬-> 힙 자료구조를 이용한 정렬
// 힙 자료구조-> (binary heap) 최댓값/최솟값을 찾아내는 빠른 연산을 위해 만들어진 완전 이진트리 베이스 자료구조
public class HeapSort {
	public static void sort(Comparable[] a) {
		int heapSize = a.length-1;				// a[0]은 사용 x (-1)
		for (int i = heapSize/2 - 1; i > 0; i--)	// heap 생성
			downheap(a,i,heapSize);			
		while(heapSize > 1) {					// heap 정렬
			swap(a,1,heapSize--);				// a[1](현재 힙에서 가장 큰 값을 갖음)과 마지막 원소와 교환
			downheap(a,1,heapSize);
		}
			
	}

	private static void downheap(Comparable[] a, int p, int heapSize) {
		while (2 * p <= heapSize) {
			int s = 2 * p; 								// s -> 왼쪽 자식(노드) 인덱스 
			System.out.printf("부모 위치 :%d(%d), 자식 위치 %d(%d, %d)\n", p, a[p], s, a[s], a[s+1] );
			print(a);
			if (s < heapSize && isless(a[s], a[s + 1])) // 만약 오른쪽 노드가 크다면
				s++; 	
			if (!isless(a[p], a[s]))					// 부모가 자식 노드들 보다 크다면 힙 만족 
				break; 									// -> break;
			swap(a, p, s); 								// 부모가 자식노드보다 작다면 
			p = s; 										// 부모노드의 값이 둘중 큰 자식노드의 자리로 이동
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
		System.out.printf("heapSort 결과: ");
		print(a);
	}
}

/* 
 * 상향식으로 힙을 구성 -> O(N) 
 * 루트와 힙의 마지막 노드 교환 후 downheap() 수행 -> O(logN)
 * 루트와 힙의 마지막 노드를 교환하는 횟수 -> N-1
 * => O(N) + (N-1)*O(logN) = O(NlogN) [최종 수행시간]
 * => 어떠한 입력이든 최소 O(NlogN)을 보장 -> 가장 큰값 몇개만 필요시 유용
 * 
 * */

