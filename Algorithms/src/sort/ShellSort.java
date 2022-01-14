package sort;

// �������Ŀ� ��ó�� ������ �߰� => ���ڸ��� �̵��ϴ� ������ ����
// ��ó�� ���� -> ���� ���� ���� ���ҵ��� �迭�� �պκ����� �Ű� �޺κп� ū ���� ������ �ϴ� ����
// �ַ� �Ӻ���� �ý��ۿ� ���� ��� -> �Է��� ũ�� ���� ��쿡 ���� ����
// ����ð� = ������ ���� ����
public class ShellSort {
	// h-����: ������ h�� ���ҵ鳢�� �����ϴ� ��
	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 4;								// 3x+1 ����: 1,4,13,40...�߿��� 4�� 1�� ���
		while (h >= 1) {						
			for (int i = h; i < N; i++) { 		// h���� ���� 
				for (int j = i; j >= h && isless(a[j], a[j - h]); j -= h) {
					swap(a, j, j - h);
					System.out.printf("������ %d-�ܰ� : ", h);
					print(a);
				}
			}
			//h /= 3;		
			h -=1;			// 1ĭ ���̱� h�� �����Կ� ���� ����ð��� �޶���
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
		System.out.printf("������ ���:  ");
		print(a);
	}

}
