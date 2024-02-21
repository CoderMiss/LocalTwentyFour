package com.locatwentyfour.localtwentyfour.services;




import java.util.List;

import com.locatwentyfour.localtwentyfour.Entities.Train;


public interface TrainService {

	Train addTrain(Train train);


	    public void deleteTrainByNumber(String trainNumber) ;


		Train updateTrain(String trainNumber, String newName, List<String> newStations);


		List<Train> findTrainsBetweenStations(String sourceStation, String destinationStation);






		


	
      
	  


 
	
}
