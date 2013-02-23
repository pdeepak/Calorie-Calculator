package com.mydomain.caloriecalcapp.decorate;

import com.mydomain.caloriecalcapp.entity.sporttypes.Sport;

/**
 * This class lets application add the  calories 
 * that can be burn while performing any water related sport
 * 
 * @author Pasrija.Deepak
 * @version 1.0
 */
public class WaterSportDecorator extends SportDecorator
{

	private int	extracalorieBurn	= 5;

	public WaterSportDecorator( Sport sportType )
	{
		super( sportType );
	}

	@Override
	public float getCalories( int duration )
	{
		return super.getCalories( duration ) + this.getExtracalorieBurn();
	}

	public int getExtracalorieBurn()
	{
		return extracalorieBurn;
	}

	public void setExtracalorieBurn( int extraCalBurn )
	{
		this.extracalorieBurn = extraCalBurn;
	}

}
