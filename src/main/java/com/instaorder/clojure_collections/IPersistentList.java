package com.instaorder.clojure_collections;

public interface IPersistentList<T> {
	int count();

	IPersistentList<T> cons(Object o);

	IPersistentList<T> empty();

	boolean equiv(IPersistentList<T> list);
	
	T peek();

	IPersistentList<T> pop();
}
