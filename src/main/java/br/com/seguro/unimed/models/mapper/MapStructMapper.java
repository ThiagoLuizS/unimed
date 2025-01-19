package br.com.seguro.unimed.models.mapper;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@MapperConfig(unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface MapStructMapper<Entity, View, Form> {
    View entityToView(Entity t);
    Entity formToEntity(Form form);
}
