package co.edu.uco.infrastructure.adapter.primary.controller;

import co.edu.uco.core.messages.CatalogMessageEnum;
import co.edu.uco.core.messages.properties.CatalogMessagesProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messageucolab/v1/dummy")
public class DummyController {

    private final CatalogMessagesProperties catalogMessagesProperties;

    @Autowired
    public DummyController(CatalogMessagesProperties catalogMessagesProperties) {
        this.catalogMessagesProperties = catalogMessagesProperties;
    }

    @RequestMapping
    public String dummy() {
        return catalogMessagesProperties.getMessage(CatalogMessageEnum.USR_001);
    }
}
