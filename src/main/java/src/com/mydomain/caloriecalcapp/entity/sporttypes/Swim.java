package com.mydomain.caloriecalcapp.entity.sporttypes;

/**
 * Represents swimming sport 
 * 
 * @author Pasrija.Deepak
 * @version 1.0
 */
public class Swim implements Sport
{
	private int		burnRate			= 5;
	private String	sportDescription	= "Water";

	public Swim()
	{

	}

	public Swim( int bRate, String sdesc )
	{
		this.burnRate = bRate;
		this.sportDescription = sdesc;
	}

	@Override
	public float getCalories( int duration )
	{
		return burnRate * duration;
	}

	public int getBurnRate()
	{
		return burnRate;
	}

	public void setBurnRate( int burnRate )
	{
		this.burnRate = burnRate;
	}

	

	@Override
	public String getSportDescription()
	{
		return sportDescription;
	}

	public void setSportDescription( String sportDescription )
	{
		this.sportDescription = sportDescription;
	}

}
