package co.edu.uco.core.domain.usecase;

import co.edu.uco.core.application.catalog.strategy.MessageCatalogStrategy;
import co.edu.uco.core.application.catalog.strategy.inmemory.enums.DetailMessageEnum;
import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.application.mapper.entity.DataMapper;
import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.domains.MessageDomain;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import co.edu.uco.core.domain.usecase.handling.HandlingFindMessageByIdEnvironmentPort;
import co.edu.uco.utils.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@Slf4j
public final class FindMessageByIdEnvironmentUseCase implements HandlingFindMessageByIdEnvironmentPort {
    private final MessageCatalogStrategy messageCatalogStrategy;
    private final DataMapper<MessageData, MessageDomain, MessageDTO> entityMapper;

    public FindMessageByIdEnvironmentUseCase(MessageCatalogStrategy messageCatalogStrategy,
            DataMapper<MessageData, MessageDomain, MessageDTO> entityMapper) {
        this.messageCatalogStrategy = messageCatalogStrategy;
        this.entityMapper = entityMapper;
    }

    @Override
    public SimplePage<MessageDTO> execute(UUID id, SimplePageRequest pageRequest) {
        try {
            SimplePage<MessageData> messageDataSimplePage = messageCatalogStrategy.findByIdEnvironment(id, pageRequest);

            // Transformar cada MessageData a MessageDTO
            List<MessageDTO> messageDTOList = messageDataSimplePage.getData().stream()
                    .map(entityMapper::mapperDTO)
                    .collect(Collectors.toList());

            // Crear un nuevo SimplePage con los DTOs
            return SimplePage.of(
                    messageDTOList,
                    messageDataSimplePage.getCurrentPage(),
                    messageDataSimplePage.getPageSize(),
                    messageDataSimplePage.getTotalItems(),
                    messageDataSimplePage.getTotalPages());
        } catch (Exception exception) {
            var errorMessage = String.format(DetailMessageEnum.FUN_012.getContent(), id);
            log.error(errorMessage);
            throw BusinessException.buildUserException(errorMessage);
        }
    }
}