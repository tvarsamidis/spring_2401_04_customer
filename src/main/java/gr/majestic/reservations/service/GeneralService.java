package gr.majestic.reservations.service;

import gr.majestic.reservations.model.Room;

import java.util.List;

public interface GeneralService<T, K> {
    T create(T model);
    List<T> read();
    T read(K modelId);
    T update(K modelId, T newModel);
    boolean delete(K modelId);
}
