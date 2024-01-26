package gr.majestic.reservations.exception;

public class EntityException extends RuntimeException {

    public EntityException(String message) {
        super(message);
    }

    public EntityException() {
        super();
    }

}
