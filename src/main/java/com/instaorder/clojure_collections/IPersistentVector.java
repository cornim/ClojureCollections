package com.instaorder.clojure_collections;

import clojure.lang.IMapEntry;

public interface IPersistentVector<T> extends Iterable<T> {
	int count();

	IPersistentVector<T> empty();

	boolean equiv(IPersistentVector<T> vec);

	T peek();

	IPersistentVector<T> pop();

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
	
	IPersistentVector<T> remove(T item);
}
