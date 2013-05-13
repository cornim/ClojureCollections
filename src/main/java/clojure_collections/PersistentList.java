package clojure_collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import clojure.lang.SeqIterator;

public class PersistentList<T> implements IPersistentList<T> {
	
	private final clojure.lang.IPersistentList _clojureList;
	
	public PersistentList(){
		_clojureList = (clojure.lang.IPersistentList) clojure.lang.PersistentList.create(new ArrayList<T>());
	}
	
	public PersistentList(List<T> list){
		_clojureList = (clojure.lang.IPersistentList) clojure.lang.PersistentList.create(list);
	}
	
	private PersistentList(clojure.lang.IPersistentList clojureList){
		_clojureList = clojureList;
	}
	
	@Override
	public int count() {
		return _clojureList.count();
	}

	@Override
	public IPersistentList<T> cons(T o) {
		return new PersistentList<T>((clojure.lang.IPersistentList) _clojureList.cons(o));
	}

	@Override
	public IPersistentList<T> empty() {
		return new PersistentList<T>((clojure.lang.IPersistentList) _clojureList.empty());
	}

	@Override
	public boolean equiv(IPersistentList<T> list) {
		if (list.getClass() != PersistentList.class){
			return false;
		}
		
		PersistentList<T> cList = (PersistentList<T>) list;
		return _clojureList.equiv(cList._clojureList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T peek() {
		return (T) _clojureList.peek();
	}

	@Override
	public IPersistentList<T> pop() {
		return new PersistentList<T>((clojure.lang.IPersistentList) _clojureList.pop());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<T> iterator() {
		return new SeqIterator(_clojureList.seq());
	}

	@Override
	public IPersistentList<T> without(T item) {
		IPersistentList<T> ret = new PersistentList<T>();
		for (T t : this) {
			if (!t.equals(item)){
				ret = ret.cons(t);
			}
		}
		return ret;
	}
}
