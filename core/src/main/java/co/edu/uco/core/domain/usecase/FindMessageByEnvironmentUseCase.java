package co.edu.uco.core.domain.usecase;

import co.edu.uco.core.application.catalog.strategy.MessageCatalogStrategy;
import co.edu.uco.core.application.catalog.strategy.inmemory.enums.DetailMessageEnum;
import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.application.mapper.entity.DataMapper;
import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.domains.MessageDomain;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import co.edu.uco.core.domain.usecase.handling.HandlingFindMessageEnvironmentPort;
import co.edu.uco.utils.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public final class FindMessageByEnvironmentUseCase implements HandlingFindMessageEnvironmentPort {
    private final MessageCatalogStrategy messageCatalogStrategy;
    private final DataMapper<MessageData, MessageDomain,MessageDTO> entityMapper;

    public FindMessageByEnvironmentUseCase(MessageCatalogStrategy messageCatalogStrategy, DataMapper<MessageData, MessageDomain, MessageDTO> entityMapper) {
        this.messageCatalogStrategy = messageCatalogStrategy;
        this.entityMapper = entityMapper;
    }

    @Override
    public SimplePage<MessageDTO> execute(String environment, SimplePageRequest pageRequest) {
        try {
            var page = messageCatalogStrategy.getMessagesWithEnvironment(environment, pageRequest);
            var messages = page.getData().stream().map(entityMapper::mapperDTO).toList();
            return SimplePage.of(messages, page.getCurrentPage(), page.getPageSize(),page.getTotalItems(), page.getTotalPages());
        }catch (Exception exception){
            var errorMessage = String.format(DetailMessageEnum.FUN_011.getContent(), environment);
            log.error(errorMessage);
            throw BusinessException.buildUserException(errorMessage);
        }
    }
}
