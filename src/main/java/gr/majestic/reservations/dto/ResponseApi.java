package gr.majestic.reservations.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseApi<T> {
    private T data;
    private int status;
    private String message;
}
