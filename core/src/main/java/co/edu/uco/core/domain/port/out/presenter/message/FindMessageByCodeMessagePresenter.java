package co.edu.uco.core.domain.port.out.presenter.message;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.port.out.Response;
import co.edu.uco.core.domain.port.out.presenter.Presenter;

public interface FindMessageByCodeMessagePresenter extends Presenter<Response<MessageDTO>> {
}
