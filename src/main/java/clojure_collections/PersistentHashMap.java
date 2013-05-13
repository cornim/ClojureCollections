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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import clojure.lang.IMapEntry;
import clojure.lang.MapEntry;
import clojure.lang.SeqIterator;

public class PersistentHashMap<K, V> implements IPersistentMap<K, V> {
	private final clojure.lang.IPersistentMap _clojureMap;
	
	public PersistentHashMap(){
		_clojureMap = clojure.lang.PersistentHashMap.create(new HashMap<K, V>());
	}
	
	public PersistentHashMap(Map<K, V> map){
		_clojureMap = clojure.lang.PersistentHashMap.create(map);
	}
	
	private PersistentHashMap(clojure.lang.IPersistentMap clojureMap){
		_clojureMap = clojureMap;
	}

	@Override
	public int count() {
		return _clojureMap.count();
	}

	@Override
	public IPersistentMap<K, V> cons(IMapEntry entry) {
		return new PersistentHashMap<K,V>((clojure.lang.IPersistentMap) _clojureMap.cons(entry));
	}

	@Override
	public IPersistentMap<K, V> empty() {
		return new PersistentHashMap<K,V>((clojure.lang.IPersistentMap) _clojureMap.empty());
	}

	@Override
	public boolean equiv(IPersistentMap<K, V> map) {
		if (map.getClass() != PersistentHashMap.class){
			return false;
		}
		
		PersistentHashMap<K, V> cMap = (PersistentHashMap<K, V>) map;
		return _clojureMap.equiv(cMap._clojureMap);
	}

	@Override
	public boolean contiansKey(K key) {
		return _clojureMap.containsKey(key);
	}

	@Override
	public IMapEntry entryAt(K key) {
		return _clojureMap.entryAt(key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public V valAt(K key) {
		return (V) _clojureMap.valAt(key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public V valAt(K key, V notFound) {
		if (_clojureMap.containsKey(key)){
			return (V) _clojureMap.valAt(key);
		}
		return notFound;
	}

	@Override
	public IPersistentMap<K, V> assoc(K key, V value) {
		return new PersistentHashMap<K,V>(_clojureMap.assoc(key, value));
	}

	@Override
	public IPersistentMap<K, V> assocEx(K key, V value) {
		return new PersistentHashMap<K,V>(_clojureMap.assocEx(key, value));
	}

	@Override
	public IPersistentMap<K, V> without(K key) {
		return new PersistentHashMap<K,V>(_clojureMap.without(key));
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<MapEntry> iterator() {
		return new SeqIterator(_clojureMap.seq());
	}

}
