package co.edu.uco.core.application.builder;

import co.edu.uco.core.application.dto.CategoryDTO;

import java.util.UUID;

public class CategoryDTOBuilder {
    private UUID id;
    private String name;

    private CategoryDTOBuilder() {
        super();
    }

    public static CategoryDTOBuilder getInstance() {
        return new CategoryDTOBuilder();
    }

    public UUID getId() {
        return id;
    }

    public CategoryDTOBuilder setId(final UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public final CategoryDTOBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public final CategoryDTO build(final UUID id, final String name) {
        return CategoryDTO.create(id, name);
    }
}
