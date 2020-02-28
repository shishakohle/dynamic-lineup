package at.dyndonau.lineup;

public class Jersey
{
	private String number;
	private Size size;
	
	public Jersey (String number, Size size)
	{
		this.number = number;
		this.size = size;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	public Size getSize()
	{
		return size;
	}

	public void setSize(Size size)
	{
		this.size = size;
	}
}
