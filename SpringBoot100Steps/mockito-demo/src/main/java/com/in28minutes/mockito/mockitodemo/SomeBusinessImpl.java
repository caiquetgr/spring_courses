package com.in28minutes.mockito.mockitodemo;

public class SomeBusinessImpl {

	private DataService dataService;
	
	public SomeBusinessImpl(DataService dataService) {
		this.dataService = dataService;
	}

	int findTheGreatest() {
		int[] data = dataService.retrieveAllData();
		int greatest = Integer.MIN_VALUE;
		
		for (int i : data) {
			if(i > greatest) greatest = i;
		}
		
		return greatest;
	}
	
}