package at.dyndonau.lineup;

public enum Size
{
	ExtraExtraSmall("XXS"),
	ExtraSmall("XS"),
	Small("S"),
	Medium("M"),
	Large("L"),
	ExtraLarge("XL"),
	ExtraExtraLarge("XXL");
	
	private String size;
	
	private Size(String size)
	{
		this.size = size;
	}
	
	public String getAbbreviation()
	{
		return this.size;
	}
	
	public static Size asSize(String sizeAbbreviation)
	{
		for (Size size : Size.values())
		{
			if ( size.getAbbreviation().equalsIgnoreCase(sizeAbbreviation) )
				return size;
		}
		
		return null;
	}
	
	public static String printAllSizes()
	{
		String allSizes = "[ ";
		
		for (Size size : Size.values())
		{
			allSizes += size.getAbbreviation() + " ";
		}
		
		allSizes += "]";
		
		return allSizes;
	}
}
