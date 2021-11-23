#TODO
- super class for aircrafts
- separate payment method from order (flightorder), create payment super class
- ScheduledFlight overload constructor with flight parameter

# Flight Reservation Service

This repository contains a simple application that provides a ticket reservation service for flights.
It contains ...
  * ... entities for various types of air-travel e.g., 
    descriptions of planes (``flight.reservation.plane.*``), 
    airports (``flight.reservation.Airport``), and 
    flights and schedule (``flight.reservation.flight.*``)
  * ... customer (``flight.reservation.Customer``) and passenger (``flight.reservation.Passenger``) entities
  * ... classes for 
    the reservation (``flight.reservation.order.*``)
    and payment (``flight.reservation.payment.*``)
    of tickets
    
The functionality currently includes ...
  * ... creating flights from one airport to another with a certain aircraft 
  * ... scheduling flights for a specific date and time.
  * ... booking a reservation for a customer on a specific scheduled flight 
  * ... processing the payment (by credit card or PayPal) and closing/finalizing the order.

There is no interface for the service yet. Instead, test were written for ...
  * ... scheduling flights (on unit level)
  * ... booking scenarios (on acceptance level)

### Background story

This prototype version of a reservation service has all functionality it needs right now. 
However, the quality of the code is not very good, and it gets hard to maintain and extend. 
Many instances of structural flaws can be found in the code.


## Task - refactoring

The task is simple: Find structural flaws and refactor the code.
You can add, change, move classes, interfaces, and methods
to enhance maintainability and extendability.

### Procedure

1. Create a fork of this repository
1. Refactor/extend the code
  * Javadoc and extensive error handling can be disregarded for the purpose of this exercise
  * Adjust the test code so that all tests succeed after refactoring
3. Create a pull request to submit you proposals

## How to build and run

### Required technologies
To run the application, the following should be installed:
* [git](https://git-scm.com/downloads)
* JDK (e.g., [AdoptOpenJDK](https://adoptopenjdk.net/))
* [Apache Maven](https://maven.apache.org/install.html)

### Run from source

In the command line run the following: 

```
git clone https://github.com/fortiss-cce/flight-reservation.git
cd flight-reservation
```

This project has no interface yet.
You can run the tests to see if the application can be executed and still behaves as intended.

In the command line, run the following:

``./mvnw clean install``

For a better visualization of the tests you can also use the test runner from IntelliJ 
which displays the tests in a behaviour driven manner.
