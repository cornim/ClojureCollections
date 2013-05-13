package com.instaorder.clojure_collections;

public interface IPersistentList<T> extends Iterable<T> {
	int count();

	IPersistentList<T> cons(Object o);

	IPersistentList<T> empty();

	boolean equiv(IPersistentList<T> list);
	
	T peek();

	IPersistentList<T> pop();
	
	IPersistentList<T> without(T item);
}
