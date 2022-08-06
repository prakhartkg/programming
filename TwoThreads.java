package programming;

public class TwoThreads {
	
	static int counter = 1;
	
	static int n;

	public void printEven() {
		synchronized (this) {
			while (counter<n) {
				while (counter%2==1) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(counter + " : " + Thread.currentThread().getName());
				counter++;
				notify();
			}
		}
	}
	
	public void printOdd() {
		synchronized (this) {
			while (counter<n) {
				while (counter%2==0) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(counter + " : " + Thread.currentThread().getName());
				counter++;
				notify();
			}
		}
	}
	
	public static void main(String[] args) {
		TwoThreads bq = new TwoThreads();
		n=10;
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				bq.printOdd();
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				bq.printEven();
				
			}
		});
		
		t1.start();
		t2.start();
	}
}
