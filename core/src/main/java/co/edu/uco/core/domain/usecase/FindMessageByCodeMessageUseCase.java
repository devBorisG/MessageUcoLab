package co.edu.uco.core.domain.usecase;

import co.edu.uco.core.application.catalog.strategy.MessageCatalogStrategy;
import co.edu.uco.core.application.catalog.strategy.inmemory.enums.DetailMessageEnum;
import co.edu.uco.core.application.dto.message.MessageDTO;
import co.edu.uco.core.application.mapper.entity.DataMapper;
import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.domains.MessageDomain;
import co.edu.uco.core.domain.usecase.handling.HandlingFindMessageByCodeMessagePort;
import co.edu.uco.utils.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public final class FindMessageByCodeMessageUseCase implements HandlingFindMessageByCodeMessagePort {
    private final MessageCatalogStrategy messageCatalogStrategy;
    private final DataMapper<MessageData, MessageDomain, MessageDTO> entityMapper;
    public FindMessageByCodeMessageUseCase(MessageCatalogStrategy messageCatalogStrategy, DataMapper<MessageData, MessageDomain, MessageDTO> entityMapper) {
        this.messageCatalogStrategy = messageCatalogStrategy;
        this.entityMapper = entityMapper;
    }
    @Override
    public MessageDTO execute(String codeMessage, String application) {
        try {
            MessageData messageData = messageCatalogStrategy.getMessage(codeMessage, application);
            return entityMapper.mapperDTO(messageData);
        } catch (Exception exception) {
            var errorMessage = String.format(DetailMessageEnum.FUN_012.getContent(), codeMessage, application);
            log.error(errorMessage);
            throw BusinessException.buildUserException(errorMessage);
        }
    }
}