package com.mydomain.caloriecalcapp.decorate;

import com.mydomain.caloriecalcapp.entity.sporttypes.Sport;

/**
 * Base decorator class that allows to add additional
 * functionality to the sport types  
 * 
 * @author Pasrija.Deepak
 * @version 1.0
 */
public class SportDecorator implements Sport
{

	private Sport	sportType;

	public SportDecorator( Sport sportType )
	{
		super();
		this.sportType = sportType;
	}

	@Override
	public float getCalories( int duration )
	{
		return sportType.getCalories( duration );
	}

	@Override
	public String getSportDescription()
	{
		return sportType.getSportDescription();
	}

}
