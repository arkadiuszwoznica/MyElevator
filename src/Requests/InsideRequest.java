package Requests;

public class InsideRequest extends RequestBase{
    private int assignedElevatorId;

    public InsideRequest(int floor, int elevatorId){
        callingFloor = floor;
        assignedElevatorId = elevatorId;
    }

    public int getAssignedElevatorId() {
        return assignedElevatorId;
    }
}
