package com.mouhammeddbs.covid19;


/**
 * Created by Mouhammed Dbs on 13/8/2020
 */

public class Model
{
	private String country;
	private float cases;
	private float deaths;
	private float todayCases;
	private float todayDeaths;
	private float recoverd;
	private float active;
	private float critical;
	private float casesPerOneMillion;
	private float deathsPerOneMillion;

	public Model(String country, float cases, float deaths, float todayCases, float todayDeaths, float recoverd, float active, float critical, float casesPerOneMillion, float deathsPerOneMillion)
	{
		this.country = country;
		this.cases = cases;
		this.deaths = deaths;
		this.todayCases = todayCases;
		this.todayDeaths = todayDeaths;
		this.recoverd = recoverd;
		this.active = active;
		this.critical = critical;
		this.casesPerOneMillion = casesPerOneMillion;
		this.deathsPerOneMillion = deathsPerOneMillion;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCases(float cases)
	{
		this.cases = cases;
	}

	public float getCases()
	{
		return cases;
	}

	public void setDeaths(float deaths)
	{
		this.deaths = deaths;
	}

	public float getDeaths()
	{
		return deaths;
	}

	public void setTodayCases(float todayCases)
	{
		this.todayCases = todayCases;
	}

	public float getTodayCases()
	{
		return todayCases;
	}

	public void setTodayDeaths(float todayDeaths)
	{
		this.todayDeaths = todayDeaths;
	}

	public float getTodayDeaths()
	{
		return todayDeaths;
	}

	public void setRecoverd(float recoverd)
	{
		this.recoverd = recoverd;
	}

	public float getRecoverd()
	{
		return recoverd;
	}

	public void setActive(float active)
	{
		this.active = active;
	}

	public float getActive()
	{
		return active;
	}

	public void setCritical(float critical)
	{
		this.critical = critical;
	}

	public float getCritical()
	{
		return critical;
	}

	public void setCasesPerOneMillion(float casesPerOneMillion)
	{
		this.casesPerOneMillion = casesPerOneMillion;
	}

	public float getCasesPerOneMillion()
	{
		return casesPerOneMillion;
	}

	public void setDeathsPerOneMillion(float deathsPerOneMillion)
	{
		this.deathsPerOneMillion = deathsPerOneMillion;
	}

	public float getDeathsPerOneMillion()
	{
		return deathsPerOneMillion;
	}



}
