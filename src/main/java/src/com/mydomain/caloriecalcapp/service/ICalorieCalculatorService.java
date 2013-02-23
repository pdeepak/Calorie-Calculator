package com.mydomain.caloriecalcapp.service;

import com.mydomain.caloriecalcapp.entity.UserData;

/**
 * Service class that contains the business rules
 * to calculate the total calories burned for a any user.
 * @author Pasrija.Deepak
 * @version 1.0
 */
public interface ICalorieCalculatorService 
{

	/*
	 * this method is invoked to fetch the total calories burnt by user
	 * in a day.
	 * @param userdata contains the details or the user and the  details of 
	 * work outs performed and their duration
	 */
	public float getCaloriesBurnt(UserData userd);
}
