import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    public List<Elevator> systemElevators;
    private List<Request> requests = new ArrayList<>();

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

    public void createRequest(int cartFloor, boolean isArrowUp){
        Request request = new Request(cartFloor, isArrowUp);
        //requests.add(request);
        assignRequest(request);
    }


    private void assignRequest(Request request){
        Elevator closestElevator = chooseClosestAvailableElevator(request.getCartFloor(), request.isArrowUp());
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

    public void step() {
        for (Elevator elevator : systemElevators) {
            elevator.move();
        }
    }
}
