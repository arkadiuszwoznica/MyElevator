package Requests;

public class OutsideRequest {

        private int callingFloor;
        private boolean isArrowUp;

        public OutsideRequest(int floor, boolean arrow){
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
            return "Requests.RequestBase.Request{" +
                    "callingFloor=" + callingFloor +
                    ", isArrowUp=" + isArrowUp +
                    '}';
        }
}
