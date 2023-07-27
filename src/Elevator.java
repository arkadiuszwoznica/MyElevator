import java.io.Console;

public class Elevator {

    private int elevatorId;
    private int currentFloor;
    private int destinationFloor;

    private boolean isMoving;


    public Elevator(int elevatorId) {
        this.elevatorId = elevatorId;
        this.currentFloor = 0;
        this.destinationFloor = 0;
        this.isMoving = false;
    }
    public int getElevatorId() {return elevatorId;}

    public int getCurrentFloor() {return currentFloor;}

    public int getDestinationFloor() {return destinationFloor;}

    public void setDestinationFloor(int destinationFloor) {this.destinationFloor = destinationFloor;}

    public boolean isMoving() {return isMoving;}

    public void setIsMoving(boolean bool) {this.isMoving = bool;}


    public void move() {
        if (currentFloor < destinationFloor) {
            currentFloor++;
        } else if (currentFloor > destinationFloor) {
            currentFloor--;
        }
        if (isThere()){
            System.out.print("I'm on the right floor");
        }
    }

    private boolean isThere() {
        return (currentFloor == destinationFloor);
    }
}
