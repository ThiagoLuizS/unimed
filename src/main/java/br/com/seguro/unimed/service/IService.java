package br.com.seguro.unimed.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IService<Entity, View, Form> {
    View saveToView(Form form);
    Entity saveToEntity(Entity entity);
    View saveEntityToView(Entity entity);
    View getByIdToView(Long id);
    Entity getById(Long id);
    Page<View> getAll(Pageable pageable);
    View update(Long id, Form form);
}
