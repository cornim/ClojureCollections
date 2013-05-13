/**
 * ClojureCollections
 * Copyright (c) Dr. Cornelius Mund. All rights reserved.
 * The use and distribution terms for this software are covered by the
 * Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 * which can be found in the file epl-v10.html at the root of this distribution.
 * By using this software in any fashion, you are agreeing to be bound by the
 * terms of this license.
 * You must not remove this notice, or any other, from this software. * 
 **/

package clojure_collections;

import clojure.lang.IMapEntry;

/**Interface for a persistent (immutable) vector.
 * All methods are guaranteed to leave the object itself unmodified and only
 * return modified copies of the original.
 * 
 * @author Dr. Cornelius Mund
 *
 * @param <T> Type of items to be contained in the vector. */
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

	/**Place a value at the i'th position in the vector thereby replacing
	 * the value which was there before. If i was not filled before then an
	 * IndexOutOfBoundsExceptions is thrown.
	 * 
	 * @param i Position where the new value should be placed.
	 * @param val The new value
	 * @return The new vector with the replaced value. */
	IPersistentVector<T> assocN(int i, T val);

	/**Adds an object of type T to the vector.
	 * 
	 * @param o Object to be added.
	 * @return New vector with the additional object added.*/
	IPersistentVector<T> cons(T val);
	
	/**Returns the n'th element in the list.*/
	T nth(int n);
	
	/**Returns true if i is a filled element, false otherwise.*/
	boolean containsKey(Integer i);

	/**Returns the the value at a given position together with the number of
	 * the position.
	 * 
	 * @param i Number of the position to retrieve.
	 * @return A MapEntry consisting of the the position i as key and the value
	 * at position i as val. */
	IMapEntry entryAt(Integer i);

	/**Returns the object at position i.
	 * 
	 * @see nth	*/
	T valAt(Integer i);

	/**Returns the object at position i or notFound if i is out of bounds.*/
	T valAt(Integer i, T notFound);
	
	/**Returns a subvector of the current vector starting at start (inclusive)
	 * and ending at end (exclusive). */
	IPersistentVector<T> subVec(int start, int end);
	
	/**Returns the vector without item. If item is not in the vector 
	 * a copy of the entire vector is returned.
	 * 
	 * @param item Item which is filtered from the vector.*/
	IPersistentVector<T> without(T item);
}
