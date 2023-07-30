public class Request {
    private int callingFloor;
    private boolean isArrowUp;

    public Request(int floor, boolean arrow){
        callingFloor = floor;
        isArrowUp = arrow;
    }

    public int getCallingFloor() {
        return callingFloor;
    }

    public boolean isArrowUp() {
        return isArrowUp;
    }

    @Override
    public String toString() {
        return "Request{" +
                "callingFloor=" + callingFloor +
                ", isArrowUp=" + isArrowUp +
                '}';
    }
}