package com.instaorder.clojure_collections;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PersistentListTest {
	
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

}
