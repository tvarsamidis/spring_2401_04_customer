package gr.majestic.reservations.exception;

public class CustomRedisException extends Exception{
    public CustomRedisException(String message){
        super(message);
    }
}
