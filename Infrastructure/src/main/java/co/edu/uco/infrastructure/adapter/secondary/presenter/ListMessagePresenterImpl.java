package co.edu.uco.infrastructure.adapter.secondary.presenter;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.port.out.presenter.ListMessagePresenter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListMessagePresenterImpl implements ListMessagePresenter{

    @GetMapping
    public ResponseEntity<String> execute(MessageDTO messageDTO) {
        return new ResponseEntity<>("asd", HttpStatus.OK);
    }
}
