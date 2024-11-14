package co.edu.uco.core.domain.port.out.presenter.message;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.port.out.presenter.Presenter;
import co.edu.uco.core.domain.port.out.repository.SimplePage;

public interface ListMessageByApplicationPresenter extends Presenter<SimplePage<MessageDTO>> {
}