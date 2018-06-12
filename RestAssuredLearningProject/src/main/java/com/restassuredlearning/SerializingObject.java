package com.restassuredlearning;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializingObject {

	public void serializableObject(Rectangle r) throws IOException
	{
		FileOutputStream fout=new FileOutputStream("Serialization");
		ObjectOutputStream out=new ObjectOutputStream(fout);
		out.writeObject(r);
		fout.close();
		out.close();
		
		
	}
	
	public Object deserializableObject() throws IOException, ClassNotFoundException
	{
		FileInputStream fin=new FileInputStream("Serialization");
		ObjectInputStream oin=new ObjectInputStream(fin);
		Object deserializedObject=oin.readObject();
		fin.close();
		oin.close();
		return deserializedObject;
		
	
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		SerializingObject sobject=new SerializingObject();
		Rectangle state=(Rectangle) sobject.deserializableObject();
		state.print();
		System.out.println("new branch is created");
	}
	
}
