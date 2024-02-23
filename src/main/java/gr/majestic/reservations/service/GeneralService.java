package gr.majestic.reservations.service;

import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

public interface GeneralService<T, K> {
    T create(T model) throws Exception;
    List<T> read();
    T read(K modelId);
    T update(K modelId, T newModel);
    T delete(K modelId);
}
