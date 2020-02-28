package at.dyndonau.lineup;

import org.apache.log4j.PropertyConfigurator;

public class Main
{
	public static void main(String[] args)
	{
		// configure logger
		String log4jConfPath = "./src/main/resources/log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		
		JerseysetCreator mySetCreator = new JerseysetCreator();
		mySetCreator.getJerseysetFromUser();
		mySetCreator.saveJerseysetToFile();
	}
}
