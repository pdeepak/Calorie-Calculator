package com.mydomain.caloriecalcapp.service;

import java.util.List;

import com.mydomain.caloriecalcapp.decorate.MorningSportDecorator;
import com.mydomain.caloriecalcapp.decorate.WaterSportDecorator;
import com.mydomain.caloriecalcapp.entity.UserData;
import com.mydomain.caloriecalcapp.entity.WorkoutData;
import com.mydomain.caloriecalcapp.entity.sporttypes.Sport;
import com.mydomain.caloriecalcapp.util.ConfigReader;

public class CalorieCalculatorService implements ICalorieCalculatorService
{

	@Override
	public float getCaloriesBurnt( UserData userdata )
	{
		float caloriesBurnt = 0.0f;
		int totalDurationOfWorkout = 0;
		List< WorkoutData > userDetailsList = userdata.getWorkoutDetails();
		for ( WorkoutData userDetails : userDetailsList )
		{
			Sport sportType = userDetails.getSportType();
			int durationOfSports = userDetails.getDurationInMins();
			totalDurationOfWorkout += durationOfSports;
			// Check if exercise routines which are done in the morning, 
			// add addition calories
			if ( userDetails.isSportTimeMorning() )
			{
				sportType = new MorningSportDecorator( sportType );
			}
			//Check if exercise is water based exercise,
			//5 extra calories are burned
			//TODO Assumption both workout is performed in morning and is of type  
			//water than morning rule is applied first
			if ( isSportTypeWater( sportType.getSportDescription() ) )
			{
				sportType = new WaterSportDecorator( sportType );
			}
			//add to total calories if  of 40 kgs wt and time of exercise < 15 mins
			if ( isWeightTimeThresHoldValid( userdata.getWeightInKgs(),
					userDetails.getDurationInMins() ) )
			{
				caloriesBurnt += sportType.getCalories( durationOfSports );
			}
		}
		// add additional calories burnt total duration of exercises > 2 hrs
		if ( totalDurationOfWorkout > ConfigReader.THRESHOLD_TIME_EXTRABURN )
		{
			caloriesBurnt += getExtraCaloriesBurntInDay( caloriesBurnt,
					ConfigReader.EXTRA_WORKOUT_BURN_PERCENTAGE );
		}
		return caloriesBurnt;
	}

	/*
	 * Rule to check if the weight of the person is less than 40 Kg and the exercise,
	 * time for a particular routine < 15 minutes return false
	 * @param weight of person in kgs
	 * @duration of routine in mins 
	 */
	//
	public boolean isWeightTimeThresHoldValid( int weight, int duration )
	{
		boolean isCalorieConsumned = true;
		if ( weight < ConfigReader.THRESHOLD_WEIGHT_NOCALORIEBURNT_INKGS
				&& duration < ConfigReader.THRESHOLD_TIME_NOCALORIEBURNT_INMINS )
		{
			isCalorieConsumned = false;
		}
		return isCalorieConsumned;
	}

	/*
	 * Rule to check if the total duration of the exercises done in a day
	 * exceeds 2 hours, calculate additional calories are burned.
	 * @param calorieBurnt:Total calories already burnt
	 * @extraBurnRate: Rate at which additional calories are burnt
	 * @return  number of addition calories burnt 
	 */
	public float getExtraCaloriesBurntInDay( float calorieBurnt, int extraBurnRate )
	{

		return ( extraBurnRate * calorieBurnt / 100 );
	}

	/*
	 * check if type of sport is of type water based on description of that
	 * sport 
	 */
	private boolean isSportTypeWater( String sdesc )
	{
		return SPORT_TYPE_WATER.equals( sdesc );
	}

	private static final String SPORT_TYPE_WATER = "Water";
}
