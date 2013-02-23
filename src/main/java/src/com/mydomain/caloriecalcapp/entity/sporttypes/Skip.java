package com.mydomain.caloriecalcapp.entity.sporttypes;

/**
 * Represents skipping sport 
 * 
 * @author Pasrija.Deepak
 * @version 1.0
 */
public class Skip implements Sport
{

	private int		burnRate			= 5;
	private String	sportDescription	= "Land";

	public Skip()
	{
		super();
	}

	public Skip( int burnRate, String sdesc )
	{
		super();
		this.burnRate = burnRate;
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
