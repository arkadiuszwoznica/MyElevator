package Requests;

public abstract class RequestBase {

    protected int callingFloor;

    public int getCallingFloor() {
        return callingFloor;
    }
    @Override
    public String toString() {
        return "{" +
                "callingFloor=" + callingFloor +
                '}';
    }
}

