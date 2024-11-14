package co.edu.uco.core.domain.usecase;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.domains.MessageDomain;
import co.edu.uco.core.domain.port.out.presenter.message.ListMessageByApplicationPresenter;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import co.edu.uco.core.domain.usecase.handling.HandlingListMessageByApplicationPort;
import co.edu.uco.core.mapper.entity.EntityMapper;
import co.edu.uco.core.message.strategy.MessageCatalogStrategy;
import org.springframework.stereotype.Component;

@Component
public final class ListMessageByApplicationUseCase implements HandlingListMessageByApplicationPort {
    private final MessageCatalogStrategy messageCatalogStrategy;
    private final EntityMapper<MessageData,MessageDomain,MessageDTO> entityMapper;
    private final ListMessageByApplicationPresenter presenter;
    public ListMessageByApplicationUseCase(MessageCatalogStrategy messageCatalogStrategy, EntityMapper<MessageData, MessageDomain, MessageDTO> entityMapper, ListMessageByApplicationPresenter presenter) {
        this.messageCatalogStrategy = messageCatalogStrategy;
        this.entityMapper = entityMapper;
        this.presenter = presenter;
    }
    @Override
    public void execute(String application, SimplePageRequest pageRequest) {
        var page = messageCatalogStrategy.getMessages(application, pageRequest);
        var messages = page.getData().stream().map(entityMapper::mapperDTO).toList();
        presenter.present(SimplePage.of(messages, page.getCurrentPage(), page.getPageSize(),page.getTotalItems(), page.getTotalPages()));
    }
}