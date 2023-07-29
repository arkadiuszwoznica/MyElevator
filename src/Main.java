import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ElevatorSystem elevatorSystem = new ElevatorSystem(4);


        for (Elevator elevator : elevatorSystem.systemElevators){
            System.out.print(elevator.getElevatorId());
        }

        //potrzebna jest funkcja w elevator system ktora bedzie tworzyc requesty
    }
}