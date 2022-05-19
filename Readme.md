# Information Searcher App

Application to get information about flights and Airports written in **Java**.

## What it does

1. Application parses a flights and cargo data from provided *JSON* objects (e.g. *flights.json* and *cargo.json*).
2. Returns required data by calling corresponding methods: `.getFlightInformationById()` 
and `.getAirportInformationByIATACode()`.

Libraries used:
-

- **JSON simple** - library for parsing JSON objects.
- **JUNIT5** - library to perform unit-testing

## Usage

All source files are packed in 
[jar](https://github.com/ShockJake/InformationSearcherApp/blob/master/out/artifacts/FlightInformator_jar/InformationSearcher.jar "InformationSearcher.jar") 
file and in case of using it you need to add jar file to your project.

#### Example of use

```Java
import utils.DateUtil;

class App {
    public static void main(String[] args) {
        InformationSearcher searcher =
                new InformationSearcherApplication("Flights.json", "Cargos.json");

        // Showing result for particular flight
        System.out.println(searcher.getFlightInformationById(9203,
                DateUtil.parseDate("2021-06-15T07:03:47-02:00")).toString());

        // Showing result for particular Airport
        System.out.println(searcher.getAirportInformation("SEA",
                DateUtil.parseDate("2021-06-15T07:03:47-02:00")));
    }
}
```

#### How to use in console:

> java -cp InformationSearcher.jar Main **flightsFilePath** **cargoFilePath**

Examples of use:

![Example 1](./png/Example1.png 'First Example of use')
![Example 2](./png/Example2.png 'Second Example of use')

### [Get more information about classes](https://github.com/ShockJake/InformationSearcherApp/tree/master/src/main/java "Classes")


