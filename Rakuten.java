package programming;

public class Rakuten {

	public static String print(int count) {
		if(count==0) {
			return null;
		}
		System.out.println("Hello");
		count--;
		return print(count);
	}
	
	public static void main(String[] args) {
	
		// print hello with out using loop
		print(100);
		
		
	}

}
