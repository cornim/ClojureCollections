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

public class MapEntry<K, V> implements IMapEntry<K, V> {
	private final K _key;
	private final V _val;
	
	public MapEntry(K key, V val){
		_key = key;
		_val = val;
	}
	
	@SuppressWarnings("unchecked")
	MapEntry(clojure.lang.IMapEntry clojureMapEntry){
		_key = (K) clojureMapEntry.key();
		_val = (V) clojureMapEntry.val();
	}

	@Override
	public K key() {
		return _key;
	}

	@Override
	public V val() {
		return _val;
	}

}
