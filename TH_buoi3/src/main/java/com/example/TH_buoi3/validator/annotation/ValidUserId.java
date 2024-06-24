package com.example.TH_buoi3.validator.annotation;

import com.example.TH_buoi3.validator.ValidUserIdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

//TYPE: Áp dụng cho các loại lớp (class, interface, enum)
//FIELD: Áp dụng cho các trường (field) của lớp
@Target({TYPE, FIELD})
//@Retention xác định bao lâu annotation này được giữ lại
@Retention(RUNTIME)
//@Constraint xác định rằng annotation này là một ràng buộc xác thực
//Ở đây, ValidUserIdValidator.class là lớp validator sẽ chứa logic để kiểm tra tính hợp lệ của dữ liệu
@Constraint(validatedBy = ValidUserIdValidator.class)
@Documented
public @interface ValidUserId {
    String message() default "Invalid User ID";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
