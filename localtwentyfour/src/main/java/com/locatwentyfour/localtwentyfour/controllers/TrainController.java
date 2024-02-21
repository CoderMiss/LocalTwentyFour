package com.locatwentyfour.localtwentyfour.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.locatwentyfour.localtwentyfour.Entities.Train;
import com.locatwentyfour.localtwentyfour.services.TrainService;


@RestController
public class TrainController {

	  @Autowired
	    private TrainService trainService;

	  @PostMapping("/addTrain")
	    public ResponseEntity<Train> addTrain(@RequestBody Train train) {
	        Train addedTrain = trainService.addTrain(train);
	        return new ResponseEntity<>(addedTrain, HttpStatus.CREATED);
	    }
	
	  
	  // Endpoint to delete train by number
	    @DeleteMapping("/removeTrain")
	    public void deleteTrainByNumber(@RequestBody String trainNumber) {
	        trainService.deleteTrainByNumber(trainNumber);
	    }
	    
	
	    @PostMapping("/updateTrain/{number}")
	    public ResponseEntity<Train> updateTrain(@PathVariable String number,
	                                             @RequestBody Train request) {
	        Train updatedTrain = trainService.updateTrain(number, request.getName(), request.getStationNames());
	        return new ResponseEntity<>(updatedTrain, HttpStatus.OK);
	    }

	   

	  
	    @PostMapping("/trains-between-stations")
	    public List<Train> findTrainsBetweenStations(@RequestBody Map<String, String> request) {
	        String sourceStation = request.get("sourceStation");
	        String destinationStation = request.get("destinationStation");
	        
	        return trainService.findTrainsBetweenStations(sourceStation, destinationStation);
	    }
	    
}
