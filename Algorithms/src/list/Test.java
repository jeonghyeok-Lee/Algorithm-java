package list;

public class Test {

	public static void main(String[] args) {
		CirculaList<String> s = new CirculaList<String>();
		
		s.insert("pear");
		s.print();
		s.insert("cherry");
		s.print();
		s.print();
		s.insert("orange");
		s.print();
		s.print();
		s.insert("apple");
		s.print();
		System.out.println(": s�� ���� = " + s.size());
		
		s.delete();
		s.print();
		System.out.println(": s�� ���� = " + s.size());
	}

}
