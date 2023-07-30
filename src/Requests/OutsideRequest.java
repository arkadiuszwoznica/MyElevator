package Requests;

public class OutsideRequest extends RequestBase {
        private boolean isArrowUp;

        public OutsideRequest(int floor, boolean arrow){
            callingFloor = floor;
            isArrowUp = arrow;
        }
        
        public boolean isArrowUp() {
            return isArrowUp;
        }
}