package com.mydomain.caloriecalcapp.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mydomain.caloriecalcapp.entity.UserData;
import com.mydomain.caloriecalcapp.entity.WorkoutData;
import com.mydomain.caloriecalcapp.entity.sportfactory.SportFactory;
import com.mydomain.caloriecalcapp.entity.sporttypes.Sport;
import com.mydomain.caloriecalcapp.service.CalorieCalculatorService;
import com.mydomain.caloriecalcapp.service.ICalorieCalculatorService;

public class CalorieCalculatorServiceTest
{

	private static ICalorieCalculatorService	service	= null;
	private static final Logger					logger	= Logger.getLogger( "MyLog" );

	@BeforeClass
	public static void setUp() throws Exception
	{
		// Create singleton object of calculator service using Spring IOC
		service = new CalorieCalculatorService();
	}

	@AfterClass
	public static void testCleanup()
	{
		service = null;
	}

	@Test
	public void testCycling()
	{
		UserData userData = new UserData();
		userData.setWeightInKgs( 50 );
		List< WorkoutData > list = new ArrayList< WorkoutData >();
		Sport cycleSport = SportFactory.getExerciseFactory().getSport( "CYCLING" );
		WorkoutData workout = new WorkoutData( false, 20, cycleSport );
		list.add( workout );
		userData.setWorkoutDetails( list );
		assertEquals( 0, Float.compare( 100.0f, service.getCaloriesBurnt( userData ) ) );

	}

	@Test
	public void testCyclingInMorning()
	{
		UserData userData = new UserData();
		userData.setWeightInKgs( 50 );
		List< WorkoutData > list = new ArrayList< WorkoutData >();
		Sport cycleSport = SportFactory.getExerciseFactory().getSport( "CYCLING" );
		WorkoutData workout = new WorkoutData( true, 20, cycleSport );
		list.add( workout );
		userData.setWorkoutDetails( list );
		logger.log( Level.INFO,
				"Calorie burnt in cycling in morning: " + service.getCaloriesBurnt( userData ) );
		assertEquals( 0, Float.compare( 110.0f, service.getCaloriesBurnt( userData ) ) );

	}

	@Test
	public void testCyclingLessTimeThan15MinsWtMoreThan40()
	{
		UserData userData = new UserData();
		userData.setWeightInKgs( 50 );
		List< WorkoutData > list = new ArrayList< WorkoutData >();
		Sport cycleSport = SportFactory.getExerciseFactory().getSport( "CYCLING" );
		WorkoutData workout = new WorkoutData( false, 10, cycleSport );
		list.add( workout );
		userData.setWorkoutDetails( list );
		assertEquals( 0, Float.compare( 50.0f, service.getCaloriesBurnt( userData ) ) );

	}

	@Test
	public void testCyclingLessTimeThan15MinsWtLessThan40()
	{
		UserData userData = new UserData();
		userData.setWeightInKgs( 30 );
		List< WorkoutData > list = new ArrayList< WorkoutData >();
		Sport cycleSport = SportFactory.getExerciseFactory().getSport( "CYCLING" );
		WorkoutData workout = new WorkoutData( false, 10, cycleSport );
		list.add( workout );
		userData.setWorkoutDetails( list );
		assertEquals( 0, Float.compare( 0.0f, service.getCaloriesBurnt( userData ) ) );

	}

	@Test
	public void testSwimming()
	{
		UserData userData = new UserData();
		userData.setWeightInKgs( 50 );
		List< WorkoutData > list = new ArrayList< WorkoutData >();
		Sport swimSport = SportFactory.getExerciseFactory().getSport( "SWIMMING" );
		WorkoutData workout = new WorkoutData( false, 20, swimSport );
		list.add( workout );
		userData.setWorkoutDetails( list );
		logger.log( Level.INFO, "Calorie burnt in swimming: " + service.getCaloriesBurnt( userData ) );
		assertEquals( 0, Float.compare( 105.0f, service.getCaloriesBurnt( userData ) ) );

	}

	@Test
	public void testSwimmingInMorning()
	{
		UserData userData = new UserData();
		userData.setWeightInKgs( 50 );
		List< WorkoutData > list = new ArrayList< WorkoutData >();
		Sport swimSport = SportFactory.getExerciseFactory().getSport( "SWIMMING" );
		WorkoutData workout = new WorkoutData( true, 20, swimSport );
		list.add( workout );
		userData.setWorkoutDetails( list );
		logger.log( Level.INFO,
				"Calorie burnt in swimming in morning: " + service.getCaloriesBurnt( userData ) );
		assertEquals( 0, Float.compare( 115.0f, service.getCaloriesBurnt( userData ) ) );

	}

	@Test
	public void testSwimmingWtLess40DuartionLess15()
	{
		UserData userData = new UserData();
		userData.setWeightInKgs( 30 );
		List< WorkoutData > list = new ArrayList< WorkoutData >();
		Sport swimSport = SportFactory.getExerciseFactory().getSport( "SWIMMING" );
		WorkoutData workout = new WorkoutData( false, 10, swimSport );
		list.add( workout );
		userData.setWorkoutDetails( list );
		logger.log(
				Level.INFO,
				"Calorie burnt in swimming wt less 40kgs and time less than 15mins: "
						+ service.getCaloriesBurnt( userData ) );
		assertEquals( 0, Float.compare( 0.0f, service.getCaloriesBurnt( userData ) ) );

	}
	
	@Test
	public void testSwimmingMorning()
	{
		UserData userData = new UserData();
		userData.setWeightInKgs( 50 );
		List< WorkoutData > list = new ArrayList< WorkoutData >();
		Sport swimSport = SportFactory.getExerciseFactory().getSport( "SWIMMING" );
		WorkoutData workout = new WorkoutData( true, 50, swimSport );

		list.add( workout );
		// list.add( workoutRun );
		userData.setWorkoutDetails( list );
		logger.log(
				Level.INFO,
				"Calorie burnt in swimming more than 2hours in morning "
						+ service.getCaloriesBurnt( userData ) );
		assertEquals( 0, Float.compare( 280.0f, service.getCaloriesBurnt( userData ) ) );
	}
	@Test
	public void testCyclingAndRunning()
	{
		UserData userData = new UserData();
		userData.setWeightInKgs( 50 );
		List< WorkoutData > list = new ArrayList< WorkoutData >();
		Sport cycleSport = SportFactory.getExerciseFactory().getSport( "CYCLING" );
		WorkoutData workout = new WorkoutData( false, 20, cycleSport );
		Sport runSport = SportFactory.getExerciseFactory().getSport( "RUNNING" );
		WorkoutData workoutRun = new WorkoutData( false, 20, runSport );

		list.add( workout );
		list.add( workoutRun );
		userData.setWorkoutDetails( list );
		logger.log( Level.INFO,
				"Calorie burnt in running and cycling " + service.getCaloriesBurnt( userData ) );
		assertEquals( 0, Float.compare( 200.0f, service.getCaloriesBurnt( userData ) ) );

	}

	@Test
	public void testCyclingAndRunningInMorning()
	{
		UserData userData = new UserData();
		userData.setWeightInKgs( 50 );
		List< WorkoutData > list = new ArrayList< WorkoutData >();
		Sport cycleSport = SportFactory.getExerciseFactory().getSport( "CYCLING" );
		WorkoutData workout = new WorkoutData( false, 20, cycleSport );
		Sport runSport = SportFactory.getExerciseFactory().getSport( "RUNNING" );
		WorkoutData workoutRun = new WorkoutData( true, 20, runSport );

		list.add( workout );
		list.add( workoutRun );
		userData.setWorkoutDetails( list );
		logger.log(
				Level.INFO,
				"Calorie burnt in running in morning and cycling "
						+ service.getCaloriesBurnt( userData ) );
		assertEquals( 0, Float.compare( 210.0f, service.getCaloriesBurnt( userData ) ) );
	}

	@Test
	public void testRunningAndSwimming()
	{
		UserData userData = new UserData();
		userData.setWeightInKgs( 50 );
		List< WorkoutData > list = new ArrayList< WorkoutData >();
		Sport swimSport = SportFactory.getExerciseFactory().getSport( "SWIMMING" );
		WorkoutData workout = new WorkoutData( false, 20, swimSport );
		Sport runSport = SportFactory.getExerciseFactory().getSport( "RUNNING" );
		WorkoutData workoutRun = new WorkoutData( false, 20, runSport );

		list.add( workout );
		list.add( workoutRun );
		userData.setWorkoutDetails( list );
		logger.log( Level.INFO,
				"Calorie burnt in running and swimming " + service.getCaloriesBurnt( userData ) );
		assertEquals( 0, Float.compare( 205.0f, service.getCaloriesBurnt( userData ) ) );
	}

	

	@Test
	public void testRunningAndCyclingMoreThan2hrs()
	{
		UserData userData = new UserData();
		userData.setWeightInKgs( 50 );
		List< WorkoutData > list = new ArrayList< WorkoutData >();
		Sport cycleSport = SportFactory.getExerciseFactory().getSport( "CYCLING" );
		WorkoutData workout = new WorkoutData( false, 60, cycleSport );
		Sport runSport = SportFactory.getExerciseFactory().getSport( "RUNNING" );
		WorkoutData workoutRun = new WorkoutData( false, 70, runSport );

		list.add( workout );
		list.add( workoutRun );
		userData.setWorkoutDetails( list );
		logger.log(
				Level.INFO,
				"Calorie burnt in cycling and running more than 2hours "
						+ service.getCaloriesBurnt( userData ) );
		assertEquals( 0, Float.compare( 682.5f, service.getCaloriesBurnt( userData ) ) );
	}

	@Test
	public void testRunningAndSwimmingMoreThan2hrs()
	{
		UserData userData = new UserData();
		userData.setWeightInKgs( 50 );
		List< WorkoutData > list = new ArrayList< WorkoutData >();
		Sport cycleSport = SportFactory.getExerciseFactory().getSport( "SWIMMING" );
		WorkoutData workout = new WorkoutData( false, 60, cycleSport );
		Sport runSport = SportFactory.getExerciseFactory().getSport( "RUNNING" );
		WorkoutData workoutRun = new WorkoutData( false, 70, runSport );

		list.add( workout );
		list.add( workoutRun );
		userData.setWorkoutDetails( list );
		logger.log(
				Level.INFO,
				"Calorie burnt in swimming and running more than 2hours "
						+ service.getCaloriesBurnt( userData ) );
		assertEquals( 0, Float.compare( 687.75f, service.getCaloriesBurnt( userData ) ) );
	}

	@Test
	public void testSwimmingAndRunningMorningLessThan2Hrs()
	{
		UserData userData = new UserData();
		userData.setWeightInKgs( 50 );
		List< WorkoutData > list = new ArrayList< WorkoutData >();
		Sport swimSport = SportFactory.getExerciseFactory().getSport( "SWIMMING" );
		WorkoutData workout = new WorkoutData( true, 50, swimSport );
		Sport runSport = SportFactory.getExerciseFactory().getSport( "RUNNING" );
		WorkoutData workoutRun = new WorkoutData( true, 50, runSport );

		list.add( workout );
		list.add( workoutRun );
		userData.setWorkoutDetails( list );
		logger.log(
				Level.INFO,
				"Calorie burnt in swimming and running less than 2hours in morning "
						+ service.getCaloriesBurnt( userData ) );
		assertEquals( 0, Float.compare( 555.0f, service.getCaloriesBurnt( userData ) ) );
	}

	@Test
	public void testSwimmingAndRunningMorningMore2Hrs()
	{
		UserData userData = new UserData();
		userData.setWeightInKgs( 50 );
		List< WorkoutData > list = new ArrayList< WorkoutData >();
		Sport swimSport = SportFactory.getExerciseFactory().getSport( "SWIMMING" );
		WorkoutData workout = new WorkoutData( true, 60, swimSport );
		Sport runSport = SportFactory.getExerciseFactory().getSport( "RUNNING" );
		WorkoutData workoutRun = new WorkoutData( true, 70, runSport );

		list.add( workout );
		list.add( workoutRun );
		userData.setWorkoutDetails( list );
		logger.log(
				Level.INFO,
				"Calorie burnt in swimming and running more than 2hours in morning "
						+ service.getCaloriesBurnt( userData ) );
		assertEquals( 0, Float.compare( 756.0f, service.getCaloriesBurnt( userData ) ) );
	}

	@Test
	public void testSwimmingAndRunningLess15minsWtLess40kgs()
	{
		UserData userData = new UserData();
		userData.setWeightInKgs( 30 );
		List< WorkoutData > list = new ArrayList< WorkoutData >();
		Sport swimSport = SportFactory.getExerciseFactory().getSport( "SWIMMING" );
		WorkoutData workout = new WorkoutData( true, 10, swimSport );
		Sport runSport = SportFactory.getExerciseFactory().getSport( "RUNNING" );
		WorkoutData workoutRun = new WorkoutData( true, 10, runSport );

		list.add( workout );
		list.add( workoutRun );
		userData.setWorkoutDetails( list );
		logger.log( Level.INFO,
				"Calorie burnt in swimming and running each less than 15 mins and wt less than 40 kg "
						+ service.getCaloriesBurnt( userData ) );
		assertEquals( 0, Float.compare( 0.0f, service.getCaloriesBurnt( userData ) ) );
	}
}
