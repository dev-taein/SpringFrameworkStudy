package com.test.diEx06;

import java.util.ArrayList;

public class Player {
	private String name;
	private int age;
	private ArrayList<String> posision;
	private double height;
	private double weight;
	
	public Player() {
	}

	public Player(String name, int age, ArrayList<String> posision) {
		super();
		this.name = name;
		this.age = age;
		this.posision = posision;

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setPosision(ArrayList<String> posision) {
		this.posision = posision;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public ArrayList<String> getPosision() {
		return posision;
	}

	public double getHeight() {
		return height;
	}

	public double getWeight() {
		return weight;
	}
	
	
}
