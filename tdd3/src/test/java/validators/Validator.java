package validators;

public interface Validator<T> extends RequiredFieldValidator {
    void check(T t);
}
