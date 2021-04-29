/**
 * 
 */
package ss.self.jb.single;

/**
 * Double checked locking Singleton class
 * 
 * @author Ryan Knapp
 *
 */
public class SingletonDouble {

	// instantiate a singleton object
	volatile private static SingletonDouble instance = null;

	public String s;

	// singleton constructor
	private SingletonDouble() {

	}

	// method to get the current instance of the object
	public static SingletonDouble getInstance() {

		// if there is no instance
		if (instance == null) {
			// lock if there is more than one thread
			synchronized (SingletonDouble.class) {
				// if there is no instance
				if (instance == null) {
					// instantiate a new instance
					instance = new SingletonDouble();
				}
			}
		}

		return instance;
	}

}
