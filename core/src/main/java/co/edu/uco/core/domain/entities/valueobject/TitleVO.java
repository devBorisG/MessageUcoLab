package co.edu.uco.core.domain.entities.valueobject;

import co.edu.uco.utils.exception.customexception.SizeTitleLessThanTenException;
import co.edu.uco.utils.exception.customexception.SizeTitleMoreThanFiftyException;
import co.edu.uco.utils.exception.customexception.TitleCanNotBeEmptyException;
import lombok.Getter;

@Getter
public class TitleVO {
    private String title;

    public TitleVO(String title) {
        setTitle(title);
    }

    public void setTitle(String title) {

        validateTitle(title);
        validateSizeMoreThanFifty(title);
        validateSizeLessThanTen(title);

        this.title = title;
    }

    private void validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            TitleCanNotBeEmptyException.report();
        }
    }

    private void validateSizeMoreThanFifty(String title) {
        if (title.length() > 50) {
            SizeTitleMoreThanFiftyException.report();
        }
    }

    private void validateSizeLessThanTen(String title) {
        if (title.length() < 10) {
            SizeTitleLessThanTenException.report();
        }
    }
}
