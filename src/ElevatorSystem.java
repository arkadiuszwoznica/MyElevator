import Requests.InsideRequest;
import Requests.OutsideRequest;
import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    public List<Elevator> systemElevators;

    public ElevatorSystem(int numElevators) {
        systemElevators = new ArrayList<>();
        for (int i = 0; i < numElevators; i++) {
            systemElevators.add(new Elevator(i));
        }
    }

    public List<String> getStatus(){
        List<String> statuses = new ArrayList<>();
        for(Elevator elevator : systemElevators){
            statuses.add(elevator.toString());
        }
        return statuses;
    }

    public void createOutsideRequest(int callingFloor, boolean isArrowUp){
        OutsideRequest request = new OutsideRequest(callingFloor, isArrowUp);
        assignOutsideRequest(request);
    }

    private void assignOutsideRequest(OutsideRequest request){
        Elevator closestElevator = chooseClosestAvailableElevator(request.getCallingFloor(), request.isArrowUp());
        closestElevator.addRequest(request);
    }

    private Elevator chooseClosestAvailableElevator(int callingFloor, boolean arrowUp){
        Elevator closestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : systemElevators) {
            int distance = Math.abs(elevator.getCurrentFloor() - callingFloor);
            boolean couldGoThisDirection = !elevator.isMoving() ||
                    (arrowUp && elevator.getDestinationFloor() >= elevator.getCurrentFloor() ||
                    !arrowUp && elevator.getDestinationFloor() <= elevator.getCurrentFloor());

            if (couldGoThisDirection && distance < minDistance) {
                closestElevator = elevator;
                minDistance = distance;
            }
        }
        return closestElevator;
    }

    public void createInsideRequest(int callingFloor, int elevatorId){
        InsideRequest insideRequest = new InsideRequest(callingFloor, elevatorId);
        assignInsideRequest(insideRequest);
    }

    private void assignInsideRequest(InsideRequest request){
        Elevator elevatorForRequest = getElevatorFromId(request.getAssignedElevatorId());
        elevatorForRequest.addRequest(request);
    }

    private Elevator getElevatorFromId(int id){
        Elevator elevatorToReturn = null;
        for (Elevator elevator : systemElevators){
            if (elevator.getElevatorId() == id){
                elevatorToReturn = elevator;
            }
        }
        if(elevatorToReturn == null) {
            throw new NullPointerException();
        }
        return elevatorToReturn;
    }

    public void step() {
        for (Elevator elevator : systemElevators) {
            elevator.move();
        }
    }
}