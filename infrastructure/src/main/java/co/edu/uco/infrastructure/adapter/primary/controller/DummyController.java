package co.edu.uco.infrastructure.adapter.primary.controller;

import co.edu.uco.core.messages.MessageCatalog;
import co.edu.uco.core.messages.MessageCatalogEnum;
import co.edu.uco.core.messages.properties.MessagesPropertiesCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messageucolab/v1/dummy")
public class DummyController {

    private final MessageCatalog catalogMessagesProperties;

    @Autowired
    public DummyController(MessagesPropertiesCatalog catalogMessagesProperties) {
        this.catalogMessagesProperties = catalogMessagesProperties;
    }

    @RequestMapping
    public String dummy() {
        return catalogMessagesProperties.getMessage(MessageCatalogEnum.USR_002.getKey());
    }
}
