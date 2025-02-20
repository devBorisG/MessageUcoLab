package co.edu.uco.core.application.validator.page;

import co.edu.uco.core.application.catalog.strategy.inmemory.enums.DetailMessageEnum;
import co.edu.uco.core.application.validator.Validator;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import co.edu.uco.utils.exception.BusinessRuleException;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public final class SortColumnValidator implements Validator<SimplePageRequest> {
    private final List<String> validColumns;
    public SortColumnValidator(Class<?> modelClass) {
        this.validColumns = Arrays.stream(modelClass.getDeclaredFields())
                .map(Field::getName)
                .toList();
    }
    @Override
    public void validate(SimplePageRequest data) throws BusinessRuleException {
        if (!validColumns.contains(data.getColumnSort())) {
            throw BusinessRuleException.buildUserException(String.format(DetailMessageEnum.FUN_027.getContent(), data.getColumnSort()));
        }
    }
}