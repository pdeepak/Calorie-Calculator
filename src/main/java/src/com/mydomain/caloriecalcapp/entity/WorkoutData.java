package com.mydomain.caloriecalcapp.entity;

import com.mydomain.caloriecalcapp.entity.sporttypes.Sport;

public class WorkoutData
{
	private boolean	sportTimeMorning;
	private int		durationInMins;
	private Sport	sportType;

	public WorkoutData( boolean sportTimeMorning, int durationInMins, Sport sportType )
	{
		super();
		this.sportTimeMorning = sportTimeMorning;
		this.durationInMins = durationInMins;
		this.sportType = sportType;
	}

	public boolean isSportTimeMorning()
	{
		return sportTimeMorning;
	}

	public void setSportTimeMorning( boolean sportTimeMorning )
	{
		this.sportTimeMorning = sportTimeMorning;
	}

	public int getDurationInMins()
	{
		return durationInMins;
	}

	public void setDurationInMins( int durationInMins )
	{
		this.durationInMins = durationInMins;
	}

	public Sport getSportType()
	{
		return sportType;
	}

	public void setSportType( Sport sportType )
	{
		this.sportType = sportType;
	}

}
