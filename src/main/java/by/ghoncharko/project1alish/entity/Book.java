package by.ghoncharko.project1alish.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    @NotNull(message = "Поле не должно быть пустым")
    private final Long id;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 1, max = 1000,message = "Превышена максимальная длина от 0 до 1000 символов")
    private final String name;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 1, max = 1000,message = "Превышена максимальная длина от 0 до 1000 символов")
    private final String author;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 1, max = 500,message = "Превышена максимальная длина от 0 до 500 символов")
    private final String year;
    @NotNull(message = "Поле не должно быть пустым")
    private final Human human;
}
