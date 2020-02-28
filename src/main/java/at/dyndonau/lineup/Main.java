package at.dyndonau.lineup;

import java.util.Map;

import org.apache.log4j.PropertyConfigurator;

public class Main
{
	public static void main(String[] args)
	{
		// configure logger
		String log4jConfPath = "./src/main/resources/log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		
		/*
		JerseysetCreator mySetCreator = new JerseysetCreator();
		mySetCreator.getJerseysetFromUser();
		mySetCreator.saveJerseysetToFile();
		*/
		
		Player miaHamm = new Player("Mia Margaret Hamm-Garciaparra", "Mia");
		miaHamm.addFavoredSize(2, Size.Medium);
		miaHamm.addFavoredSize(6, Size.Large);
		miaHamm.addFavoredSize(4, Size.Small);
		
		
		Map<Integer,Size> miasFavoredSizes = miaHamm.getFavoredSizes();
		
		System.out.println(miasFavoredSizes);
	}
}
