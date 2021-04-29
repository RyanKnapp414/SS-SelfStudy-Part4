/**
 * 
 */
package ss.self.jb.prod;

import java.util.LinkedList;

/**
 * Producer and consumer threads with buffer
 * 
 * @author Ryan Knapp
 *
 */
public class ProducerConsumer {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// create new ProdCon class
		ProdCon prodCon = new ProdCon();

		// create producer thread
		Thread prodThread = new Thread() {

			@Override
			public void run() {
				try {
					prodCon.produce();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}; // end prodThread block

		// create consumer thread
		Thread conThread = new Thread() {

			@Override
			public void run() {
				try {
					prodCon.consume();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}; // end conThread block

		// start threads
		prodThread.start();
		conThread.start();

		// join threads
		prodThread.join();
		conThread.join();

	}

	// class for functionality
	public static class ProdCon {

		// bounded buffer for producer and consumer to interact with
		LinkedList<Integer> list = new LinkedList<>();
		// size of buffer
		int limit = 5;

		// produce method that increments values and puts them in the linkedlist
		public void produce() throws InterruptedException {
			// starts at 0
			int producedNum = 0;

			while (true) {
				// synchronize this class
				synchronized (this) {
					// if the buffer is full, wait
					while (list.size() == limit) {
						wait();
					}

					// display number of items produced
					System.out.println("Produced: " + producedNum);

					// add item to the list
					list.add(producedNum++);

					// notify consumer thread that items are in the buffer
					notify();

					// smooth out runtime
					Thread.sleep(1000);
				}
			}
		}

		// consume method that removes items from the linkedlist
		public void consume() throws InterruptedException {
			while (true) {
				// synchronize this class
				synchronized (this) {
					// if buffer is empty, wait
					while (list.size() == 0) {
						wait();
					}
					// remove item from the list
					int consumedNum = list.removeFirst();

					// display number of items consumed
					System.out.println("Consumed: " + consumedNum);

					// notify producer thread that items are removed from the buffer
					notify();

					// smooth out runtime
					Thread.sleep(1000);

				}
			}
		}

	}

}
