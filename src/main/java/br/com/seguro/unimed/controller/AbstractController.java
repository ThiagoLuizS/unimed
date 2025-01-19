package br.com.seguro.unimed.controller;

import br.com.seguro.unimed.resource.IResource;
import br.com.seguro.unimed.service.AbstractService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public abstract class AbstractController<Entity, View, Form> implements IResource<Entity, View, Form> {

    protected abstract AbstractService<Entity, View, Form> getService();

    @Override
    public View getById(Long id) {
        return getService().getByIdToView(id);
    }

    @Override
    public Page<View> getAll(int page, int size) {
        return getService().getAll(PageRequest.of(page, size));
    }

    @Override
    public View save(Form form) {
        return getService().saveToView(form);
    }
}
