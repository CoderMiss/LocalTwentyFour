package com.locatwentyfour.localtwentyfour.services;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.locatwentyfour.localtwentyfour.Entities.Train;
import com.locatwentyfour.localtwentyfour.repositories.TrainRepostitory;

@Service
public class TrainServiceImpl implements TrainService {

@Autowired
 TrainRepostitory trainRepository;
	@Override
	public Train addTrain(Train train) {
		// TODO Auto-generated method stub
		 return trainRepository.save(train);
	}
	@Override
	public void deleteTrainByNumber(String trainNumber) {
		// TODO Auto-generated method stub
        trainRepository.deleteByNumber(trainNumber);

		
	}
	
	
	@Override
	public Train updateTrain(String trainNumber, String newName, List<String> newStations) {
	    // Remove braces from trainNumber
	    trainNumber = trainNumber.replaceAll("[{}]", "");
	    
	    // Find the train by its number
	    Train existingTrain = trainRepository.findByNumber(trainNumber);
	    
	    if (existingTrain != null) {
	        // Update train name
	        existingTrain.setName(newName);
	        
	        // Set new stations
	        existingTrain.setStationNames(newStations);
	        
	        // Save the updated train
	        return trainRepository.save(existingTrain);
	    } else {
	    	 Train newTrain = new Train();
	         newTrain.setNumber("train with this number is not found please check train  number again");
	         newTrain.setName(null);
	         newTrain.setStationNames(null);
	         
	         return newTrain;
	    }
	}
	
	

    @Override
    public List<Train> findTrainsBetweenStations(String sourceStation, String destinationStation) {
        // Retrieve all trains from the database
        List<Train> allTrains = trainRepository.findAll();

        // Filter the trains based on the stations
        return allTrains.stream()
                .filter(train -> {
                    List<String> stations = train.getStationNames();
                    return stations.contains(sourceStation) && stations.contains(destinationStation);
                })
                .collect(Collectors.toList());
    }
}
