package com.instaorder.clojure_collections;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

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
	}
}
