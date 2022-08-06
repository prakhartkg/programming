package programming;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BlockingQueue<E> {

	private int capacity;
	private Queue<E> queue = new LinkedList<>();
	
	public BlockingQueue(int capacity) {
		this.capacity = capacity;
	}
	
	public  void print(Queue<E> queue) {
		for(E i : queue) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	public synchronized void enqueue(E item) throws InterruptedException {
		while(this.queue.size() == this.capacity) {
			wait();
		}
		this.queue.add(item);
		print(this.queue);
		notifyAll();
	}
	
	public synchronized E dequeue() throws InterruptedException {
		while(this.queue.size() == 0) {
			wait();
		}
		E e = this.queue.remove();
		print(this.queue);
		notifyAll();
		return e;
	}
	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new BlockingQueue<>(5);
		Thread put = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				try {
					queue.enqueue(1);
					queue.enqueue(2);
					queue.enqueue(3);
					queue.enqueue(4);
					queue.enqueue(5);
					queue.enqueue(6);
					queue.enqueue(7);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread take = new Thread(new Runnable() {	
			@Override
			public void run() {
				
				try {
					queue.dequeue();
					queue.dequeue();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
			
	put.start();
	take.start();
	}
}
