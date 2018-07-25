package com.in28minutes.mockito.mockitodemo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SomeBusinessStubTest {

	@Test
	public void testfindTheGreatest() {
		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(new DataServiceStub());
		int result = someBusinessImpl.findTheGreatest();
		assertEquals(24, result);
	}
	
}

class DataServiceStub implements DataService{

	@Override
	public int[] retrieveAllData() {
		return new int[]{24,1,15};
	}
	
}