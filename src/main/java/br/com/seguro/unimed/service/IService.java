package br.com.seguro.unimed.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IService<Entity, View, Form> {
    View save(Form form);
    View getById(Long id);
    Page<View> getAll(Pageable pageable);
}
