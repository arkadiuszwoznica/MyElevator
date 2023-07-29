import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ElevatorSystem elevatorSystem = new ElevatorSystem(16);

        for (Elevator elevator : elevatorSystem.systemElevators){
            System.out.print(elevator.getElevatorId());
        }

        //System.out.print(elevatorSystem.getStatus());

        elevatorSystem.createRequest(3, true);
        elevatorSystem.createRequest(3, true);
        elevatorSystem.createRequest(3, false);
        elevatorSystem.createRequest(4, true);

        System.out.print(elevatorSystem.getStatus());
        System.out.println();

        for (int i = 0; i < 5; i++) {
            elevatorSystem.step();
        }


        System.out.print(elevatorSystem.getStatus());

    }
}