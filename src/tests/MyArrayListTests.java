package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import utility.*;

class MyArrayListTests {

	private MyArrayList<String> list;
	

	@BeforeEach
	void setUp()
	{
		this.list = new MyArrayList<String>();
	}
	

	@AfterEach
	void end()
	{
		this.list.clear();
	}
	
	/**
	 * Test if the list size is equal to 5
	 */
	@Test
	void testSize()
	{
		addList();
		assertEquals(5, this.list.size());
	}
	/**
	 * Tests the default size of an empty arraylist 0
	 */
	@Test
	void testDefaultSize()
	{
		assertEquals(0, this.list.size());
	}
	
	/**
	 * Test if the list is empty
	 */
	@Test
	void testIsEmpty()
	{
		assertTrue(this.list.isEmpty());
	}
	
	/**
	 * Adds '1' to the list, clears it, then tests if it is empty
	 */
	@Test
	void testClear()
	{
		this.list.add("1");
		this.list.clear();
		assertTrue(this.list.isEmpty());
	}
	
	
	/*
	 * Tests if element can be added to the list
	 */
	@Test
	void testAdd()
	{
		assertTrue(this.list.add("324"));
	}
	
	/*
	 * Tests if all elements can be added to the list
	 */
	@Test
	void testAddAll()
	{
		MyArrayList<String> add = new MyArrayList<>();
		addList();
		add.add("543");
		add.add("ten");
		add.add("ten");
		add.add("57");
		assertTrue(this.list.addAll(add));
	}
	
	/**
	 * Test if next iterator works
	 */
	@Test
	void testNext()
	{
		addList();
		Iterator<String> iterator = this.list.iterator();
		iterator.next();
		assertEquals("two", iterator.next());
	}
	
	/*
	 * Tests if hasNext boolean returns true in 4th iteration
	 */
	@Test
	void testHasNext()
	{
		addList();
		Iterator<String> iterator = this.list.iterator();
		iterator.next();
		iterator.next();
		iterator.next();
		iterator.next();
		assertTrue(iterator.hasNext());
	}
	
	/**
	 * Tests if get method returns "two" at index 1
	 */
	@Test
	void testGet()
	{
		addList();
		assertEquals("two", this.list.get(1));
	}
	
	/**
	 * Tests if remove method returns the removed element
	 */
	@Test
	void testRemove()
	{
		addList();
		assertEquals("three", this.list.remove(2));
	}
	
	/**
	 * Tests if the subsequent elements after the removed element shift to the left
	 */
	@Test
	void testRemovedShifted()
	{
		addList();
		this.list.remove(2);
		assertEquals("four", this.list.get(2));
	}
	

	/**
	 * Test if element at index was set
	 */
	@Test
	void testSet()
	{
		addList();
		assertEquals("1", this.list.set(1, "1"));
	}
	
	/**
	 * Tests if list contains 3
	 */
	@Test
	void testContains()
	{
		String[] add = {"1", "2", "3", "4", "5"};
		for(int i = 0; i < add.length; i++)
		{
			this.list.add(add[i]);
		}
		assertTrue(this.list.contains("3"));
	}
	
	/**
	 * Test toArray with toHold parameter
	 */
	@Test
	void testToHold()
	{
		addList();
		String[] toHold = {"2", "4", "6", "8","10", "12"};
		this.list.toArray(toHold);
		assertEquals("three", toHold[2]);
	}
	
	
	/**
	 * Adds 5 values to the list.
	 */
	private void addList()
	{
		String[] add = {"one", "two", "three", "four", "five"};
		for(int i = 0; i < add.length; i++)		
			this.list.add(add[i]);	
	}
}
