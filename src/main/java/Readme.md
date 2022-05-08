# Information Searcher App classes

---

Interfaces:
-
- InformationSearcher

List of classes:
-

- FlightInformation
- AirportInformation
- FlightEntity
- FlightParser
- Cargo
- CargoEntity
- CargoParser
- InformationSearcherApplication
- WeightUtil
- DateUtil

---

## FlightInformation class

It is a data class that contains **requested** data about flight (returned from `.getFlightInformationById()` function):

Contains next data:
 
- Flight Number
- Date of flight
- Cargo weight of flight
- Baggage weight of flight
- Total weight of flight

### Constructors

    // Default constructor to build an empty Flight Information class
    FlightInformation() {}

    // Constructor with arguments
    FlightInformation(long flightNumber, LocalDate date, 
        double cargoWeight, double baggageWeight, double totalWeight)

Parameters:

- flightNumber - Number of flight that we provide to get information
- date - Date that we provide to get information
- cargoWeight - All weight of cargo in particular flight
- baggageWeight - All weight of baggage in particular flight
- totalWeight - Total weight of cargo and baggage

### Public methods

    // Getters for all fields:
    public long getFlightNumber();
    public LocalDate getDate();
    public double getCargoWeight();
    public double getBaggageWeight();
    public double getTotalWeight();
    
    // Equals method
    public boolean equals(Object obj);
    
    // Method to get information in message representation
    public String getInformation();

    // toString method 
    public String toString();

---

## AirportInformation class

It is a data class that contains **requested** data for Airport (returned from `.getAirportInformationByIATACode()` method).

Contains next data:

- IATACode
- Date
- Departure flights
- Arrival flights
- Arrival Baggage(Pieces)
- Departure Baggage(Pieces)

### Constructors

    // Default constructor to build an empty Airport Information class
    AirportInformation();

    // Constructor with arguments
    AirportInformation(String IATACode, LocalDate date, int departureNumber,
        int arrivalsNumber, long arrivalBaggagePieces, long departureBaggagePieces);

Parameters:

- IATACode - Code of Airport that we need to get information about
- date - Date that we provide to get information
- departureNumber - number of departure flights
- arrivalsNumber - number of arrival flights
- arrivalBaggagePieces - total number of arrival baggage pieces.
- departureBaggagePieces - total number of arrival baggage pieces.

### Public methods

    // Getters for all fields:
    public long getIATACode();
    public LocalDate getDate();
    public int  getDepartureFlights();
    public int  getArrivalFlights();
    public long getArrivalBaggagePieces();
    public long getDepartureBaggagePieces()

    // Equals method
    public boolean equals(Object obj);
    
    // Method to get information in message representation
    public String getInformation();

    // toString method 
    public String toString();

---

## FlightEntity class

Class that represents Flight Entity. Contain next data:

- Flight id
- Flight number
- Departure IATACode
- Arrival IATACode
- Departure date

### Constructor
    // Constructor with arguments
    FlightEntity(long id, long flightNumber, String departureIATACode, 
            String arrivalIATACode, LocalDate departureDate);

Parameters are corresponding to data that is contained in this class.

---

## FlightParser class

Parser for Flight Entities. 

Parses in next way:

> *Parsing JSONArray as FlightEntities Array* > *Parsing each JSONObject as FlightEntity*

### Public methods

    // Method to parse Array List of Flight Entity objects from JSON file
    public static void parseFlightEntities(String flightFilePath, 
                                            ArrayList<FlightEntity> flightEntities)

Throws: IOException, ParseException.

---

## Cargo class

It is a data class that represents cargo item. Contains next data:

- ID
- Weight
- Weight unit
- Pieces

### Constructor

    // Constructor with arguments
    Cargo(long id, long weight, String weightUnit, long pieces);

Arguments correspond to data contained in this class.

### Public methods

    // Getters for all fields
    public long getId();
    public double getWeight();
    public String getWeightUnit();
    public long getPieces();

    // toString method
    public String toString();
---

## CargoEntity class

It is a data class for Cargo Entity object. Contains next data:

- Flight ID
- List of Baggage objects
- List of Cargo objects

Baggage and Cargo objects are sharing the same Cargo class.

### Constructor

    // Constructor with arguments
    CargoEntity(long flightId, List<Cargo> baggage, List<Cargo> cargos);

### Public methods

    // Getters for all fields
    public long getFlightId();
    public List<Cargo> getBaggage();
    public List<Cargo> getCargos();

    // Calculating and getting all baggage pieces
    public long getAllBaggagePieces();
---

## CargoParser class

Parser for Cargo Entities. 

Parses in next way:

> *Parses JSONArray of all CargoEntities as Array List of CargoEntities* >
> *Parses JSONObject of Cargo Entity* > *Parses a JSONArray as Lists of Cargo objects* >
> *Parses JSONObject as Cargo object*

### Public methods
     // Parse Array of Cargo objects
     public static void parseCargoEntities(String cargoEntitiesFilePath, 
                                            ArrayList<CargoEntity> cargoEntities);

Throws: IOException, ParseException.

---

## InformationSearcherApplication class

Main class for searching and getting data about Airports and particular flights.

Contain next data:

- List of Flight Entities
- List of Cargo Entities

### Constructor
    // Constructor with arguments that parses flights and corresponding cargo entities to them
    public InformationSearcherApplication(String flightFilePath, String cargoFilePath)

Parameters:

- flightFilePath - path to JSON file that contain information about flights
- cargoFilePath - path to JSON file that contain information about Cargo Entities

### Public methods

Method for getting flight information (Cargo Weight for requested Flight, 
Baggage Weight for requested Flight, Total Weight for requested Flight)

    public FlightInformation getFlightInformationById(int flightNumber, LocalDate flightDate)

Parameters:

- flightNumber - number of flight that we want to get information about
- flight date - date in which flight was

Method for getting Airport information (Number of flights departing from this airport,
Number of flights arriving to this airport, Total number (pieces) of baggage arriving to this airport,
Total number (pieces) of baggage departing from this airport.)

    public AirportInformation getAirportInformation(String IATACode, LocalDate date)

Parameters:

- IATACode - code for a specific Airport
- date - specific date in which we want to get information

---

##  WeightUtil class

Utility class, that helps to convert weight.

### Public methods

    // Method to convert kilograms to pounds
    public static double kgTolb(long kg)

     // Method to convert pounds to kilograms
    public static double lbTokg(long lb)

---

## DateUtil class

Utility class, that helps to parse Date form Strings.  

### Public methods

    // Method to parse Strings to a LocalDate objects
    public static LocalDate parseDate(String date_str)

---
