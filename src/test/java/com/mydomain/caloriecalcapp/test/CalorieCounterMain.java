package com.mydomain.caloriecalcapp.test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mydomain.caloriecalcapp.entity.UserData;
import com.mydomain.caloriecalcapp.entity.WorkoutData;
import com.mydomain.caloriecalcapp.entity.sportfactory.SportFactory;
import com.mydomain.caloriecalcapp.entity.sporttypes.Sport;
import com.mydomain.caloriecalcapp.service.CalorieCalculatorService;
import com.mydomain.caloriecalcapp.service.ICalorieCalculatorService;

public class CalorieCounterMain
{

	private Logger	logger	= Logger.getLogger( "MyLog" );

	public static void main( String args[] )
	{
		int weightInKgs = 0;
		List< String > workoutType = new ArrayList< String >( 5 );
		int[] duration = new int[5];
		boolean[] isWorkoutInMorning = new boolean[5];

		try
		{
			if ( args.length < 4
					|| ( args[0].equals( "--help" ) || args[0].equals( "-h" ) || args[0]
							.equals( "/?" ) ) )
			{
				System.out.println( "Usage: CalorieCounterMain <options>" );
				System.out.println();
				System.out.println( "Options:" );
				System.out.println();
				System.out
						.println( "--weightInKgs=60                   The directory containing the input files for the" );
				System.out.println( "                              CalorieCounterMain" );
				System.out
						.println( "--workOutType1=Runnning/Swimming/Jumping/Skipping/Cycling                  Type of Workout" );
				System.out.println( "                              Hadoop job will be stored" );
				System.out
						.println( "--durationOfWorkoutInMins1=20               Duration of workout in mins" );
				System.out.println( "                              e.g.- 20" );
				System.out
						.println( "--workoutTimeInMorning=true/false               Duration of workout in mins" );
				System.out.println( "                              e.g.- true" );

				System.out.println( "--workOutType2=         Type of Workout" );
				System.out
						.println( "--durationOfWorkoutInMins2=30               Duration of workout in mins" );
				System.out.println( "                              e.g.- 30" );
				System.out.println();
				System.out.println();
			}
			else
			{
				if ( args.length >= 4 )
				{
					for ( String arg : args )
					{
						if ( arg.startsWith( "--weightInKgs=" ) )
						{
							weightInKgs = Integer.parseInt( CalorieCounterMain.getArgValue( arg ) );
						}
						else if ( arg.startsWith( "--workOutType1=" ) )
						{
							workoutType.add( CalorieCounterMain.getArgValue( arg ).toUpperCase() );
						}
						else if ( arg.startsWith( "--durationOfWorkoutInMins1=" ) )
						{
							duration[0] = Integer.parseInt( CalorieCounterMain.getArgValue( arg ) );
						}
						else if ( arg.startsWith( "--workoutInMorning1=" ) )
						{
							isWorkoutInMorning[0] = Boolean.parseBoolean( CalorieCounterMain
									.getArgValue( arg ) );
						}
						else if ( arg.startsWith( "--workOutType2=" ) )
						{
							workoutType.add( CalorieCounterMain.getArgValue( arg ).toUpperCase() );
						}
						else if ( arg.startsWith( "--durationOfWorkoutInMins2=" ) )
						{
							duration[1] = Integer.parseInt( CalorieCounterMain.getArgValue( arg ) );
						}
						else if ( arg.startsWith( "--workoutInMorning2=" ) )
						{
							isWorkoutInMorning[1] = Boolean.getBoolean( CalorieCounterMain
									.getArgValue( arg ) );
						}
						else if ( arg.startsWith( "--workOutType3=" ) )
						{
							workoutType.add( CalorieCounterMain.getArgValue( arg ).toUpperCase() );
						}
						else if ( arg.startsWith( "--durationOfWorkoutInMins3=" ) )
						{
							duration[2] = Integer.parseInt( CalorieCounterMain.getArgValue( arg ) );
						}
						else if ( arg.startsWith( "--workoutInMorning3=" ) )
						{
							isWorkoutInMorning[2] = Boolean.getBoolean( CalorieCounterMain
									.getArgValue( arg ) );
						}
						else if ( arg.startsWith( "--workOutType4=" ) )
						{
							workoutType.add( CalorieCounterMain.getArgValue( arg ).toUpperCase() );
						}
						else if ( arg.startsWith( "--durationOfWorkoutInMins4=" ) )
						{
							duration[1] = Integer.parseInt( CalorieCounterMain.getArgValue( arg ) );
						}
						else if ( arg.startsWith( "--workoutInMorning4=" ) )
						{
							isWorkoutInMorning[4] = Boolean.getBoolean( CalorieCounterMain
									.getArgValue( arg ) );
						}
					}
					CalorieCounterMain main = new CalorieCounterMain();
					main.performCalaorieCalculations( weightInKgs, workoutType, duration,
							isWorkoutInMorning );
				}
			}
		}
		catch ( Exception ex )
		{
			System.out.println( "exception while parsing parameters" + ex.getMessage() );
		}

	}

	public void performCalaorieCalculations( int weightInKgs, List<String> workoutList, int[] duration,
			boolean[] sportTimeMorning )
	{

		UserData userData = new UserData();
		userData.setWeightInKgs( weightInKgs );
		List< WorkoutData > list = new ArrayList< WorkoutData >();
		for ( int i = 0; i < workoutList.size(); i++ )
		{
			Sport sport = SportFactory.getExerciseFactory().getSport(
					( String ) workoutList.get( i ) );
			WorkoutData workOutData = new WorkoutData( sportTimeMorning[i], duration[i], sport );
			list.add( workOutData );
		}
		userData.setWorkoutDetails( list );
		ICalorieCalculatorService calc = new CalorieCalculatorService();
		logger.log( Level.INFO, "Calorie count is: " + calc.getCaloriesBurnt( userData ) );
	}

	private static String getArgValue( String arg )
	{
		String result = null;

		String[] tokens = arg.split( "=" );
		if ( tokens.length > 1 )
		{
			result = tokens[1].replace( "'", "" ).replace( "\"", "" );
		}

		return result;
	}
}
