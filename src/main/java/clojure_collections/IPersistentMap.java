package clojure_collections;

import clojure.lang.IMapEntry;
import clojure.lang.MapEntry;

public interface IPersistentMap<K, V> extends Iterable<MapEntry>{
	int count();
	
	IPersistentMap<K, V> cons(MapEntry entry);
	
	IPersistentMap<K, V> empty();
	
	boolean equiv(IPersistentMap<K, V> map);
	
	boolean contiansKey(K key);
	
	IMapEntry entryAt(K key);
	
	V valAt(K key);
	
	V valAt(K key, V notFound);
	
	IPersistentMap<K, V> assoc(K key, V value);
	
	IPersistentMap<K, V> assocEx(K key, V value);
	
	IPersistentMap<K, V> without(K key);
}
