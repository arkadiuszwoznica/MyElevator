public class Main {
    public static void main(String[] args) {
        ElevatorSystem elevatorSystem = new ElevatorSystem(16);


        elevatorSystem.createOutsideRequest(4, true);
        elevatorSystem.createOutsideRequest(3, true);
        elevatorSystem.createOutsideRequest(3, false);


        System.out.print(elevatorSystem.getStatus());
        System.out.println();

        for (int i = 0; i < 3; i++) {
            elevatorSystem.step();
        }

        elevatorSystem.createInsideRequest(5, 1);
        System.out.print(elevatorSystem.getStatus());

        for (int i = 0; i < 3; i++) {
            elevatorSystem.step();
        }

        System.out.print(elevatorSystem.getStatus());
    }
}