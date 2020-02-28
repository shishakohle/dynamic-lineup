package at.dyndonau.lineup;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JerseysetCreator
{
	private String jerseysetName;
	private List<Jersey> jerseys;
	
	public void getJerseysetFromUser()
	{
		Scanner userinputScanner = new Scanner(System.in);
		
		while(this.jerseysetName==null || this.jerseysetName.isEmpty())
		{
			System.out.print("Please enter a name for your new jersey set: ");
			this.jerseysetName = userinputScanner.nextLine();
		}
		
		boolean allJerseysRecorded = false;
		
		while(!allJerseysRecorded)
		{
			System.out.print("Number of jersey (press Enter only if finished): ");
			String number = userinputScanner.nextLine();
			
			if(number==null || number.isEmpty())
			{
				allJerseysRecorded = true;
			}
			else
			{
				String sizeStr;
				Size size=null;
				
				while(size == null)
				{
					System.out.print("Size of Jersey number " + number + ": ");
					sizeStr = userinputScanner.nextLine();
					size = Size.asSize(sizeStr);
					if (size==null)
					{
						if (sizeStr!=null && !sizeStr.isEmpty())
						{
							System.out.print("There's no size " + sizeStr + ". ");
						}
						System.out.println("Please choose on one of these: " + Size.printAllSizes());
					}
				}
				
				if (jerseys==null)
					jerseys = new ArrayList<Jersey>();
				
				jerseys.add( new Jersey(number, size) );
			}
		}
		
		userinputScanner.close();
	}
	
	public void saveJerseysetToFile()
	{
		// TODO get Filepath from User, this is just a temporary mock:
		String filepath = "../jerseys/" + jerseysetName + ".xml";
		
		saveJerseysetToFile(filepath);
	}
	
	public void saveJerseysetToFile(String filepath)
	{
		File file = new File(filepath);
		System.out.println("Writing to: " + file.getAbsolutePath());
		
		try
		{
			BufferedWriter output = new BufferedWriter( new FileWriter(file) );
			
			output.write("<?xml version='1.0' encoding='utf-8'?>\n");
			output.write("<!-- created by Dynamic Lineup -->\n\n");
			
			if (jerseysetName != null && !jerseysetName.isEmpty())
				output.write("<jerseyset name=\"" + jerseysetName + "\">\n");
			else
				output.write("<jerseyset name=\"" + "Untitled jersey set" + "\">\n");
			
			
			if (jerseys!=null)
			{
				for(Jersey jersey : jerseys)
				{
					output.write("\t<jersey>\n");
					output.write("\t\t<number>" + jersey.getNumber() + "</number>\n");
					output.write("\t\t<size>" + jersey.getSize().getAbbreviation() + "</size>\n");
					output.write("\t</jersey>\n");
				}
			}
			
			output.write("</jerseyset>\n");
			
			output.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
