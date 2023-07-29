import java.io.Console;
import java.util.List;
import java.util.ArrayList;
public class Elevator {

    private int elevatorId;
    private int currentFloor;
    private int destinationFloor;
    private boolean isMoving;

    private Request currentlyProceedingRequest;

    private List<Request> requests = new ArrayList<>();

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

    private void chooseRequestToProceed(){
        Request requestToProceed = null;
        int betweenFloorsDistance = Integer.MAX_VALUE;
        for (Request request : requests){
            int distance = Math.abs(currentFloor - request.getCartFloor());
            if(distance<betweenFloorsDistance){
                requestToProceed = request;
            }
        }
        currentlyProceedingRequest = requestToProceed;
    }

    private void deleteRequest(Request request){
        this.requests.remove(request);
    }


    public void move() {
        if (currentFloor < currentlyProceedingRequest.getCartFloor()) {
            currentFloor++;
        } else if (currentFloor > currentlyProceedingRequest.getCartFloor()) {
            currentFloor--;
        }
        if (isThere()){
            System.out.print("I'm on the right floor to pick up passenger!");
        }
    }

    private boolean isThere() {
        return (currentFloor == destinationFloor);
    }


    @Override
    public String toString() {
        return "Elevator{" +
                "elevatorId=" + elevatorId +
                ", currentFloor=" + currentFloor +
                ", destinationFloor=" + destinationFloor +
                '}';
    }
}