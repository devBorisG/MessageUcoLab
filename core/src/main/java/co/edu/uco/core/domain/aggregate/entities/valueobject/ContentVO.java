package co.edu.uco.core.domain.aggregate.entities.valueobject;

import co.edu.uco.core.domain.customexception.ContentCanNotBeEmptyException;
import co.edu.uco.core.domain.customexception.SizeContentLessThanTenException;
import co.edu.uco.core.domain.customexception.SizeContentMoreThanOneHundred;
import co.edu.uco.utils.helper.UtilNumeric;
import co.edu.uco.utils.helper.UtilText;
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
        if (UtilText.getUtilText().isEmpty(content) || UtilText.getUtilText().isNull(content)) {
            ContentCanNotBeEmptyException.report();
        }
    }

    private void validateSizeMoreThanOneHundred(String content) {
        if (UtilNumeric.getUtilNumeric().isGreaterThan(content.length(), 100)) {
            SizeContentMoreThanOneHundred.report();
        }
    }

    private void validateSizeLessThanTen(String content) {
        if (UtilNumeric.getUtilNumeric().isLessThan(content.length(), 10)) {
            SizeContentLessThanTenException.report();
        }
    }
}
