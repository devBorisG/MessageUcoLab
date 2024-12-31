package co.edu.uco.core.domain.usecase.handling;

public interface HandlingFindMessageByCodeMessagePort {
    void execute(String codeMessage, String application);
}