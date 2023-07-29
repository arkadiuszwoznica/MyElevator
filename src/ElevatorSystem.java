import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ElevatorSystem {
    public List<Elevator> systemElevators;
//    private List<Request> requests;

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

//    public void createRequest(int cartFloor, boolean isArrowUp){
//        Request request = new Request(cartFloor, isArrowUp);
//        requests.add(request);
//        assignRequest(request);
//    }
//
//    public void deleteRequest(Request request){
//
//    }

    private void assignRequest(Request request){
        Elevator closestElevator = chooseClosestAvailableElevator(request.getCartFloor(), request.isArrowUp());
        request.setAssignedElevatorId(closestElevator.getElevatorId());
    }

//    public void pickup(int callingFloor, boolean arrowUp) {
//        Elevator closestElevator = chooseClosestAvailableElevator(callingFloor, arrowUp);
//
//        closestElevator.setDestinationFloor(callingFloor);
//        closestElevator.setIsMoving(true);
//    }

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

    public void step() {
        for (Elevator elevator : systemElevators) {
            elevator.move();
        }
    }
}
