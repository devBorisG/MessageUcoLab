package co.edu.uco.core.domain.usecase;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.application.validator.message.ListMessageValidator;
import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.domains.MessageDomain;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import co.edu.uco.core.domain.usecase.handling.HandlingListMessageByApplicationPort;
import co.edu.uco.core.application.mapper.entity.EntityMapper;
import co.edu.uco.core.application.catalog.strategy.MessageCatalogStrategy;
import co.edu.uco.utils.exception.BusinessException;
import co.edu.uco.utils.exception.CrossWordsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public final class ListMessageByApplicationUseCase implements HandlingListMessageByApplicationPort {
    private final MessageCatalogStrategy messageCatalogStrategy;
    private final EntityMapper<MessageData,MessageDomain,MessageDTO> entityMapper;
    private final ListMessageValidator listMessageValidator;
    public ListMessageByApplicationUseCase(MessageCatalogStrategy messageCatalogStrategy, EntityMapper<MessageData, MessageDomain, MessageDTO> entityMapper, ListMessageValidator listMessageValidator){
        this.messageCatalogStrategy = messageCatalogStrategy;
        this.entityMapper = entityMapper;
        this.listMessageValidator = listMessageValidator;
    }
    @Override
    public SimplePage<MessageDTO> execute(String application, SimplePageRequest pageRequest) {
        try {
            listMessageValidator.validate(pageRequest);
            var page = messageCatalogStrategy.getMessages(application, pageRequest);
            var messages = page.getData().stream().map(entityMapper::mapperDTO).toList();
            return SimplePage.of(messages, page.getPage(), page.getSize(),page.getTotalItems(), page.getTotalPages());
        }catch (BusinessException businessException) {
            var errorMessage = String.format(businessException.getUserMessage(), application);
            log.error(errorMessage);
            throw businessException;
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw CrossWordsException.build(exception.getMessage());
        }
    }
}