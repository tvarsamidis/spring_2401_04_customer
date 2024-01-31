package gr.majestic.reservations.exception;

public class NoCustomerUpdateException extends RuntimeException {

    public NoCustomerUpdateException(String message) {
        super(message);
    }

    public NoCustomerUpdateException() {
        super();
    }

}
