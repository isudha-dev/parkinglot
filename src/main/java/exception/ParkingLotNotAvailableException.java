package exception;

public class ParkingLotNotAvailableException extends Exception{

    public ParkingLotNotAvailableException() {
    }
    public ParkingLotNotAvailableException(final String message) {
        super(message);
    }
    public ParkingLotNotAvailableException(final String message, final Throwable cause) {
        super(message, cause);
    }
    public ParkingLotNotAvailableException(final Throwable cause) {
        super(cause);
    }
    public ParkingLotNotAvailableException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
