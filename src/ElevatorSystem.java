import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    private List<Elevator> systemElevators;

    public ElevatorSystem(int numElevators) {
        systemElevators = new ArrayList<>();
        for (int i = 0; i < numElevators; i++) {
            systemElevators.add(new Elevator(i));
        }
    }

    public void pickup(int callingFloor, boolean goUp) {
        Elevator closestElevator = chooseClosestElevator(callingFloor, goUp);

    }

    private Elevator chooseClosestElevator(int callingFloor, boolean goUp){
        Elevator closestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : systemElevators) {
            int distance = Math.abs(elevator.getCurrentFloor() - callingFloor);
            boolean couldGoThisDirection = (elevator.isMoving() && goUp && elevator.getDestinationFloor() >= elevator.getCurrentFloor())
                    || (elevator.isMoving() && !goUp && elevator.getDestinationFloor() <= elevator.getCurrentFloor())
                    || (!elevator.isMoving());

            if (couldGoThisDirection && distance < minDistance) {
                closestElevator = elevator;
                minDistance = distance;
            }
        }
        return closestElevator;
    }
}
