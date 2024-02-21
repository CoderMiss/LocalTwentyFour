package com.locatwentyfour.localtwentyfour.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.locatwentyfour.localtwentyfour.Entities.Train;

@Repository
public interface TrainRepostitory extends JpaRepository<Train,Long> {

	
	 void deleteByNumber(String trainNumber);
	 Train findByNumber(String number);
	 
}
