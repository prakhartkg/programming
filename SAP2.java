package programming;

public class SAP2 {
	
	public static void swap(Integer a, Integer b) {
		//Integer temp = new Integer(a);
		a = b;
		b= a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a = new Integer(10);
		Integer b = new Integer(20);
		swap(a,b);
		System.out.println(a + " " +b);
	}

}
