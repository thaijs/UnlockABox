package unlockABox;

import java.util.ArrayList;

public class Level
{
	String levelName;
	Difficulty difficultyLevel;
	ArrayList challenges = new ArrayList<>();
	
	/**
	 * Constructor used to setup levels
	 * @param difficultyLevel
	 * @param levelName
	 * @param challenges
	 */
	public Level(Difficulty difficultyLevel, String levelName, ArrayList challenges)
	{
		this.difficultyLevel = difficultyLevel;
		this.levelName = levelName;
		this.challenges = challenges;
		
	}

	/**
	 * 
	 * @return the levelName
	 */
	public String getLevelName()
	{
		return levelName;
	}

	/**
	 * @param levelName the levelName to set
	 */
	public void setLevelName(String levelName)
	{
		this.levelName = levelName;
	}

	/**
	 * @return the difficultyLevel
	 */
	public Difficulty getDifficultyLevel()
	{
		return difficultyLevel;
	}

	/**
	 * @param difficultyLevel the difficultyLevel to set
	 */
	public void setDifficultyLevel(Difficulty difficultyLevel)
	{
		this.difficultyLevel = difficultyLevel;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Level: " + levelName + ", difficultyLevel: " + difficultyLevel + ", challenges: " + challenges;
	}
	
	
	
	
	
}
