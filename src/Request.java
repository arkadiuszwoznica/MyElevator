public class Request {
    private int cartFloor;
    private boolean isArrowUp;
    private Integer assignedElevatorId;

    public Request(int floor, boolean arrow){
        cartFloor = floor;
        isArrowUp = arrow;
    }

    public int getCartFloor() {
        return cartFloor;
    }

    public boolean isArrowUp() {
        return isArrowUp;
    }

    public Integer getAssignedElevatorId() {
        return assignedElevatorId;
    }

    public void setCartFloor(int cartFloor) {
        this.cartFloor = cartFloor;
    }

    public void setArrowUp(boolean arrowUp) {
        isArrowUp = arrowUp;
    }

    public void setAssignedElevatorId(Integer assignedElevatorId) {
        this.assignedElevatorId = assignedElevatorId;
    }
}
