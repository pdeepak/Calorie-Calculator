package com.mydomain.caloriecalcapp.entity.sportfactory;

import com.mydomain.caloriecalcapp.entity.SportType;
import com.mydomain.caloriecalcapp.entity.sporttypes.Cycle;
import com.mydomain.caloriecalcapp.entity.sporttypes.Jump;
import com.mydomain.caloriecalcapp.entity.sporttypes.Run;
import com.mydomain.caloriecalcapp.entity.sporttypes.Skip;
import com.mydomain.caloriecalcapp.entity.sporttypes.Sport;
import com.mydomain.caloriecalcapp.entity.sporttypes.Swim;

/**
 * Returns the instance of specific sport type 
 * 
 * @author Pasrija.Deepak
 * @version 1.0
 */
public class SportFactory
{
	private static SportFactory	sportFactoryInstance;

	private SportFactory()
	{
	}

	
	public static synchronized SportFactory getExerciseFactory()
	{
		if ( sportFactoryInstance == null )
		{
			sportFactoryInstance = new SportFactory();
		}
		return sportFactoryInstance;
	}
	
	/*
	 * This class returns the specific sport type based on the input string
	 */
	public Sport getSport( String inputSport )
	{
		Sport sportObj = null;
		if ( SportType.CYCLING.toString().equals( inputSport ) )
		{
			sportObj = new Cycle();
		}
		else if ( SportType.SWIMMING.toString().equals( inputSport ) )
		{
			sportObj = new Swim();
		}
		else if ( SportType.JUMPING.toString().equals( inputSport ) )
		{
			sportObj = new Jump();
		}
		else if ( SportType.RUNNING.toString().equals( inputSport ) )
		{
			sportObj = new Run();
		}
		else if ( SportType.SKIPPING.toString().equals( inputSport ) )
		{
			sportObj = new Skip();
		}
		else
		{
			throw new RuntimeException( "This workout is not supported" );
		}
		return sportObj;
	}
}
