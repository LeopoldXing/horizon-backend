package com.leopoldhsing.horizon.model.dto;

import java.util.Objects;

public class CategoryDto {

    private String categoryName;
    private String description;
    private String categoryCode;

    public CategoryDto() {
    }

    public CategoryDto(String categoryName, String description, String categoryCode) {
        this.categoryName = categoryName;
        this.description = description;
        this.categoryCode = categoryCode;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                '}';
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryDto that = (CategoryDto) o;
        return Objects.equals(categoryName, that.categoryName) && Objects.equals(description, that.description) && Objects.equals(categoryCode, that.categoryCode);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(categoryName);
        result = 31 * result + Objects.hashCode(description);
        result = 31 * result + Objects.hashCode(categoryCode);
        return result;
    }
}
