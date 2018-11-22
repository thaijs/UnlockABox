package unlockABox;

public class Challenge
{
	/*
	 * Parameters for class
	 */
	private String name;
	private String description;
	private String answer;
	//for testing purposes
	private boolean answerFlag;
	private String image;
	private String hint;
	
	/**
	 * Constructor initializes parameters for challenges
	 * @param n
	 * @param d
	 * @param a
	 * @param af
	 * @param b
	 * @param h
	 */
	public Challenge(String n, String d, String a, boolean af, String i, String h)
	{
		name = n;
		description = d;
		answer = a;
		answerFlag = af;
		image = i;
		hint = h;
	}

	public String getAnswer()
	{
		return answer;
	}

	public void setAnswer(String answer)
	{
		this.answer = answer;
	}

	/**
	 * Get data in parameter name
	 * @return
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Set data in parameter name
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Get data in parameter description
	 * @return
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * Set data in parameter
	 * @param description
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * Get data in parameter box
	 * @return
	 */
	public String getImage()
	{
		return image;
	}
	
	/**
	 * Set data in parameter
	 * @param box
	 */
	public void setBox(String box)
	{
		this.image = image;
	}
	
	/**
	 * Takes hardcoded hint data and returns it
	 * @param h
	 * @return
	 */
	public String getHint()
	{
		return hint;
	}
	
	/**
	 * To format output for Challenge if needed
	 */
	public String toString()
	{
		return "default";
	}
}
