package com.mydomain.caloriecalcapp.decorate;

import com.mydomain.caloriecalcapp.entity.sporttypes.Sport;

/**
 * This class lets application calculate the addition calories 
 * that can be burn while performing the routine in morning
 * 
 * @author Pasrija.Deepak
 * @version 1.0
 */
public class MorningSportDecorator extends SportDecorator
{

	private int	extraBurnRate	= 10;

	public MorningSportDecorator( Sport sportType )
	{
		super( sportType );
	}

	@Override
	public float getCalories( int duration )
	{
		float calorieBurnt = super.getCalories( duration );
		return ( getExtraBurnRate() * calorieBurnt / 100 ) + calorieBurnt;
	}

	public int getExtraBurnRate()
	{
		return extraBurnRate;
	}

	public void setExtraBurnRate( int extraBurnRate )
	{
		this.extraBurnRate = extraBurnRate;
	}

}
