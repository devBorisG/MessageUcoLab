package co.edu.uco.infrastructure.adapter.primary.controller;

import co.edu.uco.core.messages.strategy.MessageCatalogStrategy;
import co.edu.uco.utils.exception.CrossWordsException;
import co.edu.uco.utils.helper.UtilText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messageucolab/v1/dummy")
public class DummyController {

    private static final Logger log = LoggerFactory.getLogger(DummyController.class);
    private final MessageCatalogStrategy messageCatalogStrategy;

    @Autowired
    public DummyController(MessageCatalogStrategy messageCatalogStrategy) {
        this.messageCatalogStrategy = messageCatalogStrategy;
    }

    @RequestMapping
    public String dummy(@RequestParam String codeMessage) {
        try {
            return messageCatalogStrategy.getMessage(UtilText.trim(codeMessage));
        } catch (CrossWordsException e) {
            codeMessage = String.format(e.getTechnicalMessage(), codeMessage);
            log.error(codeMessage);
        }
        return codeMessage;
    }

    @RequestMapping("/test")
    public String test() {
        return "Test";
    }
}