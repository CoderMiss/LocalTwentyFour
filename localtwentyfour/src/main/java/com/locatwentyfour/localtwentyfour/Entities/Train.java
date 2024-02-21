package com.locatwentyfour.localtwentyfour.Entities;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Train {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


	private String number;
    private String name;

    @ElementCollection
    private List<String> stationNames;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getStationNames() {
		return stationNames;
	}

	public void setStationNames(List<String> stationNames) {
		this.stationNames = stationNames;
	}
	
	
	  // Default constructor
    public Train() {
    }

    public Train(String number, String name, List<String> stationNames) {
		super();
		this.number = number;
		this.name = name;
		this.stationNames = stationNames;
	}

    
  
    
	@Override
	public String toString() {
		return "Train [id=" + id + ", number=" + number + ", name=" + name + ", stationNames=" + stationNames + "]";
	}
}
