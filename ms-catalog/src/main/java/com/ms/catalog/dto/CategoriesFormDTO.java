package com.ms.catalog.dto;

import com.sun.istack.internal.NotNull;
import lombok.Data;

@Data
public class CategoriesFormDTO {

    @NotNull
    private String name;

    @NotNull
    private Boolean active;
}
