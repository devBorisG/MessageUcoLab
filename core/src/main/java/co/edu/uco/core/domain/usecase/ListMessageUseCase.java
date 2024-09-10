package co.edu.uco.core.domain.usecase;

import co.edu.uco.core.application.dto.MessageCodeDTO;
import co.edu.uco.core.assembler.dto.DTOAssembler;
import co.edu.uco.core.domain.port.out.db.mongo.IMongoRepository;
import co.edu.uco.core.domain.domains.MessageCodeDomain;
import co.edu.uco.core.domain.port.in.ListMessageInPort;
import co.edu.uco.core.domain.port.out.presenter.ListMessagePresenter;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class ListMessageUseCase implements ListMessageInPort {

    private final ListMessagePresenter presenter;
    private final DTOAssembler<MessageCodeDTO,MessageCodeDomain> assembler;
    private final IMongoRepository mongoRepository;

    public ListMessageUseCase(ListMessagePresenter presenter, DTOAssembler<MessageCodeDTO, MessageCodeDomain> assembler, IMongoRepository mongoRepository) {
        this.presenter = presenter;
        this.assembler = assembler;
        this.mongoRepository = mongoRepository;
    }

    @Override
    public void execute(MessageCodeDomain messageDomain, HttpServletResponse response) {
        mongoRepository.findAllSelf(messageDomain.getCode()).forEach(m -> log.info("Message: {}", m.getContent()));

        MessageCodeDTO messageCodeDTO = MessageCodeDTO.create(mongoRepository.findAllSelf(messageDomain.getCode()).get(0).getContent());

        presenter.execute(messageCodeDTO, response);
    }
}
