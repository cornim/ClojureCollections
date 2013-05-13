package com.instaorder.clojure_collections;

public interface IPersistentList<T> extends Iterable<T> {
	/**Returns the number of objects currently in the list.*/
	int count();

	/**Adds an object of type T to the List and returns it.
	 * 
	 * @param o Object to be added.
	 * @return New list with the additional object added.*/
	IPersistentList<T> cons(T o);

	/**Returns the list with all elements removed.*/
	IPersistentList<T> empty();

	/**Checks if this list is equivalent to another list.
	 * Equivalent means it has equal items at the same positions.
	 * 
	 * @param list The other list to compare with.
	 * @return True if the two lists are equivalent, False otherwise.*/
	boolean equiv(IPersistentList<T> list);
	
	/**Returns the object which was last added to the list.*/
	T peek();

	/**Returns a list where the object which was added last has been removed.*/
	IPersistentList<T> pop();
	
	/**Returns a list where the item specified has been removed.
	 * If no item in the list is equal the the item specified the entire list
	 * is returned.
	 * 
	 * @param item The item to be removed.
	 * @return The list with the item specified removed. */
	IPersistentList<T> without(T item);
}
