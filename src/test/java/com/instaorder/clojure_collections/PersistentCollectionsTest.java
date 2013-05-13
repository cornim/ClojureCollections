package com.instaorder.clojure_collections;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import clojure.lang.MapEntry;

public class PersistentCollectionsTest {
	
	@Test
	public void PersistentListTests(){
		IPersistentList<Integer> target = new PersistentList<Integer>();
		target = target.cons(1);
		target = target.cons(5);
		target = target.cons(10);
		
		assertEquals(3, target.count());
		assertEquals(new Integer(10), target.peek());
		
		target = target.pop();
		
		assertEquals(2, target.count());
		assertEquals(new Integer(5), target.peek());
		
		List<Integer> init = new ArrayList<Integer>();
		init.add(5);
		init.add(1);
		
		IPersistentList<Integer> target2 = new PersistentList<Integer>(init);
		
		assertTrue(target.equiv(target2));
		
		target = target.without(1);
		assertEquals(1, target.count());
		assertEquals(new Integer(5), target.peek());
		
		target = target.empty();
		
		assertEquals(0, target.count());
	}
	
	@Test
	public void PersistentVectorTests(){
		IPersistentVector<Integer> target = new PersistentVector<>();
		

		target = target.cons(1);
		target = target.cons(5);
		target = target.cons(10);
		target = target.cons(20);
		
		assertEquals(4, target.count());
		assertEquals(4, target.length());
		assertEquals(new Integer(20), target.peek());
		assertEquals(new Integer(5), target.nth(1));
		assertEquals(new Integer(5), target.valAt(1));
		assertEquals(new Integer(5), target.valAt(1, null));
		assertNull(target.valAt(5, null));
		assertEquals(new Integer(5), target.entryAt(1).val());
		assertTrue(target.containsKey(2));
		
		
		
		target = target.pop();
		
		assertEquals(3, target.count());
		assertEquals(new Integer(10), target.peek());
		
		target = target.assocN(1, 7);
		assertEquals(3, target.count());
		assertEquals(new Integer(7), target.nth(1));
		
		target = target.assoc(1, 9);
		assertEquals(3, target.count());
		assertEquals(new Integer(9), target.nth(1));
		
		IPersistentVector<Integer> target2 = new PersistentVector<>(3, 56, 55, 8);
		IPersistentVector<Integer> target3 = new PersistentVector<>(3, 56, 55, 8);
		
		assertTrue(target2.equiv(target3));
		
		target = target.cons(-9);
		target = target.subVec(2, 4);
		assertEquals(2, target.count());
		assertEquals(new Integer(10), target.nth(0));
		assertEquals(new Integer(-9), target.nth(1));
		
		target = target.without(10);
		assertEquals(1, target.count());
		assertEquals(new Integer(-9), target.peek());
		
		target = target.empty();
		
		assertEquals(0, target.count());
	}
	
	@Test
	public void PersistentMapTests(){
		IPersistentMap<String, String> target = new PersistentHashMap<String, String>();
		
		target = target.assoc("k1", "v1");
		target = target.assoc("k2", "v2");
		target = target.assoc("k3", "v3");
		target = target.assoc("k4", "v4");
		
		assertEquals(4, target.count());
		assertTrue(target.contiansKey("k3"));
		assertFalse(target.contiansKey("x"));
		assertEquals("k3", target.entryAt("k3").key());
		assertEquals("v3", target.entryAt("k3").val());
		assertEquals("v3", target.valAt("k3"));
		assertEquals("nf", target.valAt("x", "nf"));
		
		target = target.assoc("k2", "vx");
		
		assertEquals(4, target.count());
		assertEquals("vx", target.valAt("k2"));
		
		try{
			target = target.assocEx("k2", "vy");
			fail();
		}catch (Exception e){
			//Expected exception
		}
		
		assertEquals(4, target.count());
		assertEquals("vx", target.valAt("k2"));
		
		target = target.without("k3");
		
		assertEquals(3, target.count());
		assertEquals("v4", target.valAt("k4"));
		
		target = target.cons(new MapEntry("k5", "v5"));
		
		assertEquals(4, target.count());
		assertEquals("v5", target.valAt("k5"));
		
		assertNull(target.valAt("x"));
		assertNull(target.entryAt("x"));
		
		target = target.assoc(null, "null");
		target = target.assoc("null", null);
		
		assertEquals(6, target.count());
		assertEquals("null", target.valAt(null));
		assertNull(target.valAt("null"));
		
		for (MapEntry mapEntry : target) {
			if (mapEntry.key() != null && mapEntry.key().equals("null")){
				assertNull(mapEntry.val());
			}
		}
				
		target = target.empty();
		
		assertEquals(0, target.count());
		
		target = target.assoc("x", "y");
		target = target.assoc("z", "a");
		
		IPersistentMap<String, String> target2 = new PersistentHashMap<String, String>();
		
		target2 = target2.assoc("x", "y");
		target2 = target2.assoc("z", "a");
		
		assertTrue(target.equiv(target2));
		
		target2 = target2.without("z");
		
		assertFalse(target.equiv(target2));
	}
}
