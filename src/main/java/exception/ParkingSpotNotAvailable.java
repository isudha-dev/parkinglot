package exception;

public class ParkingSpotNotAvailable extends Exception {

    public ParkingSpotNotAvailable() {
    }
    public ParkingSpotNotAvailable(final String message) {
        super(message);
    }
    public ParkingSpotNotAvailable(final String message, final Throwable cause) {
        super(message, cause);
    }
    public ParkingSpotNotAvailable(final Throwable cause) {
        super(cause);
    }
    public ParkingSpotNotAvailable(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
