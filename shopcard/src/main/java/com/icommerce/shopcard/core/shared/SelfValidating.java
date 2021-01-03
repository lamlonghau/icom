package com.icommerce.shopcard.core.shared;

import javax.validation.*;
import java.util.Set;

public abstract class SelfValidating<T> {

  private Validator validator;

  public SelfValidating() {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }

  /**
   * Evaluates all Bean Validations on the attributes of this instance.
   */
  public void validateSelf(Class<?> ...groups) {
    Set<ConstraintViolation<T>> violations = validator.validate((T) this, groups);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }
  }
}
