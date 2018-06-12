package com.restassuredlearning;

import java.io.Serializable;

public class Rectangle implements Serializable{

	int Height=500;
	int Width=300;
	
	
	public int calculateArea()
	{
		return Height*Width;
	}
	
	
	public void print() {
		System.out.println(Height);
	}
}
