package org.example.test.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * 密码检测验证器
 */
public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {
    @Override
    public void initialize(ValidPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null) {
            return false;
        }
        // 自定义密码格式校验逻辑，例如：至少8个字符，包含大小写字母和数字
        return password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$");
    }
}
