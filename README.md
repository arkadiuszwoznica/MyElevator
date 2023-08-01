#  Java MyElevator App - elevator system simulator

Java MyElevator App is a simple simulator of elevators system. I created it using object-oriented programming in Java with polymorphic classes to provide you solution aligned with the rules of clean code.

After reading `Getting started` section, which will allow you to run this app, familiarize yourself with a detailed description of how each class works which I provided in `Classes` section.

## Getting Started

Follow the instructions below to clone, compile, and run the Java Console App.

### Clone the Repository

If you have Git installed, you can clone the repository with the following command:

```bash
git clone https://github.com/arkadiuszwoznica/MyElevator
```

### Run the Application

If you've installed IDE with operating with JAVA, I strongly recommend you using it to run this app, so you can recreate main and add your own requests to elevators.

You can also run this app from command line with requests added by me to generally see how it works. To achieve this, keep following steps:

1. Navigate to the project folder and make sure you are in the src/main/java folder. Path should look like this:
```bash
/Users/<yourName>/<yourFolder>MyElevator/src/main/java
```

2. Compile the Java source files using `javac`:

```bash
javac *.java
```

3. Run the compiled application using the `java` command:

```bash
java Main
```


## Classes

### Class 1: Main

This class is for simulating requests to elevators. You can recreate it as you want to see how it works. Keep in mind, that inside requests should only be added to elevators first called on exact floor (it's how it works in real life, you can call only the elevator you are in :) )


### Class 2: ElevatorSystem

This class is holding most of the application logic. System has a list of its elevators, method for returning statuses of all elevators and methods for creating both outside and inside requests.

To create outside request, system first checks which elevator is the closest one and could take the passenger. It assumes elevator can take passenger if is currently not moving or is moving in the same way the passenger wants to go, what is based on arrowUp property. After that, system is assigning request to chosen elevator.

To create inside request logic is similar, but instead of choosing the closest elevator system takes elevator with given id. This is because inside request is given always inside concrete elevator and only this elevator could handle it. 

### Class 3: Elevator

Class elevator is class which represents single elevator and its properties such as id, current and destination floor, currently proceeding move, list of assigned requests and isMoving property. 

Inside is also logic for adding and deleting requests for elevator; choosing request to proceed first basing on distance which is to each request calling floor; and move for one step of simulation.

### Package of classes: Requests

Package contains three classes with concept of inheritance. Adding this mechanism allows us to deal with outside and inside requests in the same time, although they don't have the same properties

#### Class 4: Request Base 

This is an abstract class which contains same property for both inside and outside request which is calling floor. It doesn't contain constructor, because you can't make request without specifying if it is inside or outside.

#### Class 5: OutsideRequest

This is class extending RequestBase with property isArrowUp. It's simulation of two types of calling elevator (to go up or down) and allows system to deal with them properly.

#### Class 6: InsideRequest

This is class extending RequestBase with property assignedElevatorId. This is because inside requests are always made from the concrete elevator and to simulate it we need to provide its id for allowing system to deal with these requests properly.

