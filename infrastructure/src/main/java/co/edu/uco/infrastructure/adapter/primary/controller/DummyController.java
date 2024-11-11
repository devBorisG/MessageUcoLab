package co.edu.uco.infrastructure.adapter.primary.controller;

import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.port.out.repository.CacheMessageRepository;
import co.edu.uco.core.domain.port.out.repository.DataBaseMessageRepository;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import co.edu.uco.core.message.strategy.MessageCatalogStrategy;
import co.edu.uco.infrastructure.adapter.AbstractRestController;
import co.edu.uco.utils.exception.BusinessException;
import co.edu.uco.utils.helper.UtilText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messageucolab/v1/dummy")
public class DummyController extends AbstractRestController {
    private static final Logger log = LoggerFactory.getLogger(DummyController.class);
    private final MessageCatalogStrategy messageCatalogStrategy;
    private final DataBaseMessageRepository repository;
    private final CacheMessageRepository cacheMessageRepository;
    @Autowired
    public DummyController(MessageCatalogStrategy messageCatalogStrategy, DataBaseMessageRepository repository, CacheMessageRepository cacheMessageRepository) {
        this.messageCatalogStrategy = messageCatalogStrategy;
        this.repository = repository;
        this.cacheMessageRepository = cacheMessageRepository;
    }

//    @RequestMapping
//    public String dummy(@RequestParam String codeMessage) {
//        try {
//            return messageCatalogStrategy.getMessage(UtilText.trim(codeMessage));
//        } catch (CrossWordsException e) {
//            codeMessage = String.format(e.getTechnicalMessage(), codeMessage);
//            log.error(codeMessage);
//        }
//        return codeMessage;
//    }

    @RequestMapping("/cache")
    public String test(@RequestParam String codeMessage, @RequestParam String application) {
        return messageCatalogStrategy.getMessage(UtilText.trim(codeMessage), UtilText.trim(application)).getContent();
    }

    @RequestMapping("/list")
    public ResponseEntity<SimplePage<MessageData>> list(@RequestParam String application, @ModelAttribute SimplePageRequest request) {
        return ResponseEntity.ok(messageCatalogStrategy.getMessages(application, request));
    }
}