package exception;

public class ParkingLotAlreadyExistsException extends Exception{

    public ParkingLotAlreadyExistsException() {
    }
    public ParkingLotAlreadyExistsException(final String message) {
        super(message);
    }
    public ParkingLotAlreadyExistsException(final String message, final Throwable cause) {
        super(message, cause);
    }
    public ParkingLotAlreadyExistsException(final Throwable cause) {
        super(cause);
    }
    public ParkingLotAlreadyExistsException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
