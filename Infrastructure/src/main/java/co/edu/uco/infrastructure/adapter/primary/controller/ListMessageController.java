package co.edu.uco.infrastructure.adapter.primary.controller;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.entities.MessageEntity;
import co.edu.uco.core.domain.usecase.ListMessageUseCase;
import co.edu.uco.core.port.in.ListMessageInPort;
import co.edu.uco.core.port.out.presenter.ListMessagePresenter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class ListMessageController {

    private final ListMessageInPort useCase;
    public ListMessageController(ListMessageInPort useCase) {
        this.useCase = useCase;
    }

    @GetMapping
    public void execute(@RequestParam String codigoMensaje) {
        System.out.println("Entro");
        MessageEntity message = new MessageEntity(codigoMensaje, "Mensaje de prueba");
        useCase.execute(message);
    }
}
