# LocalTwentyFour
Java spring boot backend for a train scheduling system.
================================================================================================

- I have used mysql database 
- To connect to database on your local machine please edit application.properties file , create database with  same name i have created it  with name ===> "localtwentyfour"  
  and change username and password in same file as per your machines mysql settings


===============================================================================================
# 1)url to add train(post request)  ->  localhost:8080/addTrain     
--------------------------------------------------------------------------------------------------
payload ->   {
"number" : "20664",
"name" : "SBC VANDE BHARAT Train",
"stationNames" : [
"Dharwar Railway Station",
"Hubli Junction",
"Davangere Railway Station",
"Bangalore Yesvantpur Junction",
"Bangalore City Junction"
]
}

----------------------------------------------------------------------------------------------------
output =>   {
    "id": 13,
    "number": "20664",
    "name": "SBC VANDE BHARAT Train",
    "stationNames": [
        "Dharwar Railway Station",
        "Hubli Junction",
        "Davangere Railway Station",
        "Bangalore Yesvantpur Junction",
        "Bangalore City Junction"
    ]
}
===========================================================================================================


# 2) url to remove train(delete request)  -> localhost:8080/removeTrain

----------------------------------------------------------------------------------------------------------

 payload -> {
"number" : "20663"}

==========================================================================================================

# 3) url to update train(post request)->   localhost:8080/updateTrain/{number}
-----------------------------------------------------------------------------------------------------------
   Description => if train with given number exists it wil update the given data and if train is not  present it  will return null  object with train with given number not found 
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
payload -> 
   {
  "name": "New Train Name",
  "stationNames": ["Station D", "Station E"]
  
}
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
====================================================================================================================================================================================
# 4)  url to find stations between source statuion  and destination station ->  http://localhost:8080/trains-between-stations

-----------------------------------------------------------------------------------------------------------------------------
payload -> {
    "sourceStation": "Davangere Railway Station",
    "destinationStation": "Bangalore City Junction"
}

------------------------------------------------------------------------------------------------------------------------------

output => [
   
    {
        "id": 4,
        "number": "20662",
        "name": "SBC VANDE BHARAT Train",
        "stationNames": [
            "Dharwar Railway Station",
            "Hubli Junction",
            "Davangere Railway Station",
            "Bangalore Yesvantpur Junction",
            "Bangalore City Junction"
        ]
    },
    {
        "id": 5,
        "number": "20663",
        "name": "SBC VANDE BHARAT Train",
        "stationNames": [
            "Dharwar Railway Station",
            "Hubli Junction",
            "Davangere Railway Station",
            "Bangalore Yesvantpur Junction",
            "Bangalore City Junction"
        ]
    },
  
]
=========================================================================================================================================================
   
