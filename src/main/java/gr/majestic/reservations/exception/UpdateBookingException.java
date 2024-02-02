package gr.majestic.reservations.exception;

public class UpdateBookingException extends RuntimeException {
    public UpdateBookingException(String message) {
        super(message);
    }

    public UpdateBookingException() {
        super();
    }
}
