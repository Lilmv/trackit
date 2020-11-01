package com.egraph.model;

public class GetLocationCoord {
	
	public String[] getCoord(String response) {
		String[] listofString = response.split("[:,]");
		for(String L : listofString)
			System.out.println(L);
		return listofString;
	}

}
