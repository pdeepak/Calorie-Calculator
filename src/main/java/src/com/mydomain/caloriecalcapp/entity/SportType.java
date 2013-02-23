package com.mydomain.caloriecalcapp.entity;

public enum SportType
{

	SWIMMING( "SWIMMING" ), 
	RUNNING( "RUNNING" ),
	CYCLING( "CYCLING" ),
	JUMPING( "JUMPING" ),
	SKIPPING("SKIPPING" );

	private final String	name;

	private SportType( String s )
	{
		name = s;
	}

	public boolean equalsName( String otherName )
	{
		return ( otherName == null ) ? false : name.equals( otherName );
	}

	public String toString()
	{
		return name;
	}

}
