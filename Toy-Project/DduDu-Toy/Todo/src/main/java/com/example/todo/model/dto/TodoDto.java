package com.example.todo.model.dto;

import com.example.todo.model.entity.Todo;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TodoDto {
    private Integer id;
    private Integer number;
    private String master;
    private String name;
    private String createdAt;
    private String status;

    public Todo toEntity() {
        return Todo.builder()
                .number(number)
                .master(master)
                .name(name)
                .status(status)
                .build();
    }
}
