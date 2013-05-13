package clojure_collections;

import clojure.lang.IMapEntry;

public interface IPersistentVector<T> extends Iterable<T> {
	/**Returns the number of objects currently in the vector.*/
	int count();

	/**Returns the vector with all elements removed.*/
	IPersistentVector<T> empty();

	/**Checks if this vector is equivalent to another vector.
	 * Equivalent means it has equal items at the same positions.
	 * 
	 * @param vec The other vector to compare with.
	 * @return True if the two vectors are equivalent, False otherwise.*/
	boolean equiv(IPersistentVector<T> vec);

	/**Returns the object which was last added to the vector.*/
	T peek();

	/**Returns a vector where the object which was added last has been removed.*/
	IPersistentVector<T> pop();

	/**Returns the number of objects currently in the vector.*/
	int length();

	IPersistentVector<T> assocN(int i, T val);

	IPersistentVector<T> cons(T val);
	
	T nth(int i);
	
	boolean containsKey(Integer key);

	IMapEntry entryAt(Integer key);

	IPersistentVector<T> assoc(Integer key, T val);

	T valAt(Integer key);

	T valAt(Integer key, T notFound);
	
	IPersistentVector<T> subVec(int start, int end);
	
	IPersistentVector<T> without(T item);
}
