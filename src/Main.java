import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Elevator> elevators = new ArrayList<Elevator>();

        System.out.print("Hello and welcome!");

        Elevator elevator0 = new Elevator(1);
        Elevator elevator1 = new Elevator(2);

        elevators.add(elevator0);
        elevators.add(elevator1);


        for (Elevator elevator : elevators){
            System.out.print(elevator.getElevatorId());
        }
    }
}