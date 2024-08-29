package co.edu.uco.infrastructure.adapter.primary.controller;

import co.edu.uco.core.messages.MessageCatalogStrategy;
import co.edu.uco.utils.helper.UtilText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messageucolab/v1/dummy")
public class DummyController {

    private final MessageCatalogStrategy messageCatalogStrategy;

    @Autowired
    public DummyController(MessageCatalogStrategy messageCatalogStrategy) {
        this.messageCatalogStrategy = messageCatalogStrategy;
    }

    @RequestMapping
    public String dummy() {
        return UtilText.getDefault(messageCatalogStrategy.getMessage("USR_004"),"El mensaje no ha sido encontrado");
    }
}