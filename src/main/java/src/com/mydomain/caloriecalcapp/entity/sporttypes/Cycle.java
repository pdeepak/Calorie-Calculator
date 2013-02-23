package com.mydomain.caloriecalcapp.entity.sporttypes;

/**
 * Represents cycling sport 
 * 
 * @author Pasrija.Deepak
 * @version 1.0
 */
public class Cycle implements Sport
{
	private int		burnRate			= 5;
	private String	sportDescription	= "Land";

	public Cycle()
	{

	}

	public Cycle( int bRate, String sDescription )
	{
		this.setBurnRate( bRate );
		this.setSportDescription( sDescription );
	}
	
	/*
	 * This method returns that rate at which the calories are burnt
	 * for the cycling sport.
	 */
	public int getBurnRate()
	{
		return burnRate;
	}
	
	/*
	 * Set the rate at which the calories are burnt
	 * for the cycling sport.
	 */
	public void setBurnRate( int burnRate )
	{
		this.burnRate = burnRate;
	}

	@Override
	public float getCalories( int duration )
	{
		return burnRate * duration;
	}

	@Override
	public String getSportDescription()
	{
		return sportDescription;
	}

	/*
	 * Sets the description or details that provide different details 
	 * of the sport
	 */
	public void setSportDescription( String sdesc )
	{
		this.sportDescription = sdesc;
	}

}
