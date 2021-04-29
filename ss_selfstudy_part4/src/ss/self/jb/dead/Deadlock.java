/**
 * 
 */
package ss.self.jb.dead;

/**
 * deadlock example
 * 
 * @author Ryan Knapp
 *
 */
public class Deadlock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// declaring variables
		String firstBook = "Peter Pan";
		String secondBook = "Harry Potter";

		// start thread1 block
		Thread student1 = new Thread() {

			@Override
			public void run() {
				try {
					// student1 checks out firstBook and holds on to it for a week
					synchronized (firstBook) {
						System.out.println("student1 checked firstBook out");
						Thread.sleep(200);
						// student1 wants to checkout secondBook
						synchronized (secondBook) {
							System.out.println("student1 checked secondBook out");
						}
					}
				} catch (Exception e) {

				}

			}

		}; // end thread1 block

		// start thread2 block
		Thread student2 = new Thread() {

			@Override
			public void run() {
				try {
					// student2 checks out secondBook and holds on to it for a week
					synchronized (secondBook) {
						System.out.println("student2 checked secondBook out");
						Thread.sleep(200);
						// student2 wants to checkout firstBook
						synchronized (firstBook) {
							System.out.println("student2 checked firstBook out");
						}
					}
				} catch (Exception e) {

				}

			}

		}; // end thread2 block

		System.out.println("Start Deadlock Program");

		// starting threads
		student1.start();
		student2.start();

		System.out.println("End Deadlock Program");

	}

}
