package com.mydomain.caloriecalcapp.entity;

import java.util.List;

public class UserData
{
	private int					weightInKgs;
	private List< WorkoutData >	workoutDetails;

	public int getWeightInKgs()
	{
		return weightInKgs;
	}

	public void setWeightInKgs( int weightInKgs )
	{
		this.weightInKgs = weightInKgs;
	}

	public List< WorkoutData > getWorkoutDetails()
	{
		return workoutDetails;
	}

	public void setWorkoutDetails( List< WorkoutData > workoutDetails )
	{
		this.workoutDetails = workoutDetails;
	}

}
