import Requests.RequestBase;

import java.util.List;
import java.util.ArrayList;
public class Elevator {

    private int elevatorId;
    private int currentFloor;
    private int destinationFloor;
    private boolean isMoving;
    private RequestBase currentlyProceedingRequest;
    private List<RequestBase> myRequests = new ArrayList<>();

    public Elevator(int elevatorId) {
        this.elevatorId = elevatorId;
        this.currentFloor = 0;
        this.destinationFloor = 0;
        this.isMoving = false;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
    public int getDestinationFloor() {
        return destinationFloor;
    }
    public boolean isMoving() {
        return isMoving;
    }

    private void chooseRequestToProceed(){
        RequestBase requestToProceed = null;
        int betweenFloorsDistance = Integer.MAX_VALUE;
        for (RequestBase request : myRequests){
            int distance = Math.abs(currentFloor - request.getCallingFloor());
            if(distance<betweenFloorsDistance){
                requestToProceed = request;
                betweenFloorsDistance = distance;
            }
        }
        currentlyProceedingRequest = requestToProceed;
        this.destinationFloor = requestToProceed != null ? requestToProceed.getCallingFloor() : currentFloor;
    }

    public void updateIsMoving(){
        this.isMoving =  (currentlyProceedingRequest != null);
    }

    public void addRequest(RequestBase request){
        myRequests.add(request);
        chooseRequestToProceed();
        updateIsMoving();
    }

    private void deleteRequestsForThisFloor(int finishingRequestFloor){
        myRequests.removeIf(request -> request.getCallingFloor() == finishingRequestFloor);
        updateIsMoving();
    }

    public void move() {
        if(currentlyProceedingRequest != null){
            if (currentFloor < destinationFloor) {
                currentFloor++;
            } else if (currentFloor > destinationFloor) {
                currentFloor--;
            }
            if (isThere()){
                System.out.print("Request finished!");
                deleteRequestsForThisFloor(currentlyProceedingRequest.getCallingFloor());
                chooseRequestToProceed();
            }
        }
    }

    private boolean isThere() {
        return (currentFloor == destinationFloor);
    }

    @Override
    public String toString() {
        List<String> requestsStrings = new ArrayList<>();
        for (RequestBase request : myRequests) {
            requestsStrings.add(request.toString());
        }

        return "\n Elevator{" +
                "elevatorId=" + elevatorId +
                ", currentFloor=" + currentFloor +
                ", destinationFloor=" + destinationFloor +
                ", requests" + requestsStrings +
                '}';
    }
}