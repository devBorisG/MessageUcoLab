package co.edu.uco.core.domain.entities.valueobject;

import co.edu.uco.utils.exception.customexception.*;
import lombok.Getter;

@Getter
public class ContentVO {
    private String content;

    public ContentVO(String content) {
        setContent(content);
    }

    public void setContent(String content) {
        validateContent(content);
        validateSizeLessThanTen(content);
        validateSizeMoreThanOneHundred(content);

        this.content = content;
    }

    private void validateContent(String content) {
        if (content == null || content.trim().isEmpty()) {
            ContentCanNotBeEmptyException.report();
        }
    }

    private void validateSizeMoreThanOneHundred(String content) {
        if (content.length() > 100) {
            SizeContentMoreThanOneHundred.report();
        }
    }

    private void validateSizeLessThanTen(String content) {
        if (content.length() < 10) {
            SizeContentLessThanTenException.report();
        }
    }
}
