package com.mydomain.caloriecalcapp.entity.sporttypes;

/**
 * This is the base class of sports or routines user can follow to burn calories.
 * It lets the application to perform calculation to get the calories
 * 
 * @author Pasrija.Deepak
 * @version 1.0
 */
public interface Sport
{

	/*
	 * This method calculates the calories burnt for the give duration.
	 * 
	 * @param duration: Duration of exercise expected in mins
	 */
	public float getCalories( int duration );

	/*
	 * This method provides the description/details of the type of sports.
	 * 
	 */
	public String getSportDescription();
}
