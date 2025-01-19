package br.com.seguro.unimed.service;

import br.com.seguro.unimed.exception.GlobalException;
import br.com.seguro.unimed.models.mapper.MapStructMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;

@Slf4j
public abstract class AbstractService<Entity, View, Form> {

    protected abstract JpaRepository<Entity, Long> getRepository();
    protected abstract MapStructMapper<Entity, View, Form> getMapper();

    public View saveToView(Form form) {
        try {
            log.info(">> SALVAR [form={}] ", form);
            Entity t = getMapper().formToEntity(form);
            t = getRepository().save(t);
            log.info("<< SALVAR [t={}] ", t);
            View view =  getMapper().entityToView(t);
            log.info("<< SALVAR [view={}] ", view);
            return view;
        } catch (Exception e) {
            log.error("<< SALVAR [error={}]", e.getMessage(), e);
            throw new GlobalException(e.getMessage());
        }
    }

    public Entity saveToEntity(Entity entity) {
        try {
            log.info(">> SALVAR [entity={}] ", entity);
            entity = getRepository().save(entity);
            log.info("<< SALVAR [entity={}] ", entity);
            return entity;
        } catch (Exception e) {
            log.error("<< SALVAR [error={}]", e.getMessage(), e);
            throw new GlobalException(e.getMessage());
        }
    }

    public View saveEntityToView(Entity entity) {
        try {
            log.info(">> SALVAR [entity={}] ", entity);
            entity = getRepository().save(entity);
            log.info("<< SALVAR [entity={}] ", entity);
            return getMapper().entityToView(entity);
        } catch (Exception e) {
            log.error("<< SALVAR [error={}]", e.getMessage(), e);
            throw new GlobalException(e.getMessage());
        }
    }
}
