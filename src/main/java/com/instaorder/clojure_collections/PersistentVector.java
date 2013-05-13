package com.instaorder.clojure_collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import clojure.lang.IMapEntry;
import clojure.lang.RT;
import clojure.lang.SeqIterator;

public class PersistentVector<T> implements IPersistentVector<T> {
	private final clojure.lang.IPersistentVector _clojureVector;
	
	public PersistentVector(){
		_clojureVector = clojure.lang.PersistentVector.create(new ArrayList<T>());
	}
	
	public PersistentVector(List<T> items){
		_clojureVector = clojure.lang.PersistentVector.create(items);
	}
	
	public PersistentVector(@SuppressWarnings("unchecked") T... items){
		_clojureVector = clojure.lang.PersistentVector.create(items);
	}
	
	private PersistentVector(clojure.lang.IPersistentVector clojureVector){
		_clojureVector = clojureVector;
	}
	@Override
	public int count() {
		return _clojureVector.count();
	}

	@Override
	public IPersistentVector<T> empty() {
		return new PersistentVector<T>((clojure.lang.IPersistentVector) _clojureVector.empty());
	}

	@Override
	public boolean equiv(IPersistentVector<T> vec) {
		if (vec.getClass() != PersistentVector.class){
			return false;
		}
		
		PersistentVector<T> cVec = (PersistentVector<T>) vec;
		return _clojureVector.equiv(cVec._clojureVector);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T peek() {
		return (T) _clojureVector.peek();
	}

	@Override
	public IPersistentVector<T> pop() {
		return new PersistentVector<T>((clojure.lang.IPersistentVector) _clojureVector.pop());
	}

	@Override
	public int length() {
		return _clojureVector.length();
	}

	@Override
	public IPersistentVector<T> assocN(int i, T val) {
		return new PersistentVector<T>(_clojureVector.assocN(i, val));
	}

	@Override
	public IPersistentVector<T> cons(T val) {
		return new PersistentVector<T>(_clojureVector.cons(val));
	}

	@SuppressWarnings("unchecked")
	@Override
	public T nth(int i) {
		return (T) _clojureVector.nth(i);
	}

	@Override
	public boolean containsKey(Integer key) {
		return _clojureVector.containsKey(key);
	}

	@Override
	public IMapEntry entryAt(Integer key) {
		return _clojureVector.entryAt(key);
	}

	@Override
	public IPersistentVector<T> assoc(Integer key, T val) {
		return new PersistentVector<T>((clojure.lang.IPersistentVector) _clojureVector.assoc(key, val));
	}

	@SuppressWarnings("unchecked")
	@Override
	public T valAt(Integer key) {
		return (T) _clojureVector.valAt(key);
	}

	@Override
	public T valAt(Integer key, T notFound) {
		if(key >= 0 && key < count()){
	        return nth(key);
		    }
		return notFound;
	}

	@Override
	public IPersistentVector<T> subVec(int start, int end) {
		return new PersistentVector<T>(RT.subvec(_clojureVector, start, end));
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<T> iterator() {
		return new SeqIterator(_clojureVector.seq());
	}

	@Override
	public IPersistentVector<T> without(T item) {
		IPersistentVector<T> ret = new PersistentVector<T>();
		for (T t : this) {
			if (!t.equals(item)){
				ret = ret.cons(t);
			}
		}
		return ret;
	}
}
