package com.example.TH_buoi2.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @NotNull(message = "ID không được để trống")
    @Min(value = 1, message = "ID phải là số nguyên dương lớn hơn 0")
    private int id;

    @NotBlank(message = "Tiêu để không được để trống")
    @Size(max = 100, message = "Tiêu đề không được vượt quá 100 ký tự")
    private String title;

    @NotBlank(message = "Tác giả không được để trống")
    @Size(max = 100, message = "Tác giả không được vượt quá 100 ký tự")
    private String author;

    @NotNull(message = "Giá không được để trống")
    @Min(value = 0, message = "Giá phải là một số không âm")
    private Double price;

    @NotBlank(message = "Tác giả không được để trống")
    @Pattern(regexp = "^[A-Za-z]+$",message = "Thể loại chỉ chấp nhận chữ cái và khoảng trắng")
    private String category;
}
