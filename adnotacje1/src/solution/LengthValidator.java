package solution;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
public @interface LengthValidator {
	int minLength() default 5;
	int maxLength() default 10;
}
