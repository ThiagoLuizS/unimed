package br.com.seguro.unimed.service;

import br.com.seguro.unimed.exception.GlobalException;
import br.com.seguro.unimed.models.mapper.MapStructMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@Slf4j
public abstract class AbstractService<Entity, View, Form> implements IService<Entity, View, Form> {

    protected abstract JpaRepository<Entity, Long> getRepository();
    protected abstract MapStructMapper<Entity, View, Form> getMapper();

    private static final String messageErrorConstraint = "Alguns itens informados não existem na base de dados. Verifique se existe algum valor nulo e tente novamente.";
    private static final String messageErrorNotFount = "Nenhum registro encontrado";

    @Override
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
            if(e instanceof DataIntegrityViolationException) {
                throw new GlobalException(messageErrorConstraint);
            }
            throw new GlobalException(e.getMessage());
        }
    }

    @Override
    public Entity saveToEntity(Entity entity) {
        try {
            log.info(">> SALVAR [entity={}] ", entity);
            entity = getRepository().save(entity);
            log.info("<< SALVAR [entity={}] ", entity);
            return entity;
        } catch (Exception e) {
            log.error("<< SALVAR [error={}]", e.getMessage(), e);
            if(e instanceof DataIntegrityViolationException) {
                throw new GlobalException(messageErrorConstraint);
            }
            throw new GlobalException(e.getMessage());
        }
    }

    @Override
    public View saveEntityToView(Entity entity) {
        try {
            log.info(">> SALVAR [entity={}] ", entity);
            entity = getRepository().save(entity);
            log.info("<< SALVAR [entity={}] ", entity);
            return getMapper().entityToView(entity);
        } catch (Exception e) {
            log.error("<< SALVAR [error={}]", e.getMessage(), e);
            if(e instanceof DataIntegrityViolationException) {
                throw new GlobalException(messageErrorConstraint);
            }
            throw new GlobalException(e.getMessage());
        }
    }

    @Override
    public Page<View> getAll(Pageable pageable) {
        log.info(">> PAGE [pageable={}] ", pageable);
        Page<View> page = getRepository().findAll(pageable)
                .map(getMapper()::entityToView);
        log.info("<< PAGE [page={}] ", page);
        return page;
    }

    @Override
    public View getByIdToView(Long id) {
        log.info(">> View [id={}] ", id);
        View view = getRepository().findById(id)
                .map(getMapper()::entityToView)
                .orElseThrow(() -> new GlobalException(messageErrorNotFount));
        log.info("<< View [view={}] ", view);
        return view;
    }

    @Override
    public Entity getById(Long id) {
        log.info(">> entity [id={}] ", id);
        Entity entity = getRepository().findById(id)
                .orElseThrow(() -> new GlobalException(messageErrorNotFount));
        log.info("<< entity [entity={}] ", entity);
        return entity;
    }

    @Override
    public View update(Long id, Form form) {
        log.info(">>[id={}, form={}] ", id, form);
        Entity entity = getRepository().findById(id)
                .orElseThrow(() -> new GlobalException(messageErrorNotFount));
        getMapper().updateToEntity(entity, form);
        entity = saveToEntity(entity);
        log.info("<<[entity={}, id={}, form={}] ", entity, id, form);
        return getMapper().entityToView(entity);
    }
}
