package co.edu.uco.core.domain.aggregate.entities.valueobject;

import co.edu.uco.core.domain.customexception.SizeTitleLessThanTenException;
import co.edu.uco.core.domain.customexception.SizeTitleMoreThanFiftyException;
import co.edu.uco.core.domain.customexception.TitleCanNotBeEmptyException;
import co.edu.uco.utils.helper.UtilNumeric;
import co.edu.uco.utils.helper.UtilText;
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
        if (UtilText.getUtilText().isEmpty(title) || UtilText.getUtilText().isNull(title)) {
            TitleCanNotBeEmptyException.report();
        }
    }

    private void validateSizeMoreThanFifty(String title) {
        if (UtilNumeric.getUtilNumeric().isGreaterThan(title.length(), 50)) {
            SizeTitleMoreThanFiftyException.report();
        }
    }

    private void validateSizeLessThanTen(String title) {
        if (UtilNumeric.getUtilNumeric().isLessThan(title.length(), 10)) {
            SizeTitleLessThanTenException.report();
        }
    }
}