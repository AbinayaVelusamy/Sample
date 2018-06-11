package com.restassuredlearning;

import java.io.Serializable;

public class Rectangle implements Serializable{

	int Height=50;
	int Width=30;
	
	
	public int calculateArea()
	{
		return Height*Width;
	}
	
	
	public void print() {
		System.out.println(Height);
	}
}
