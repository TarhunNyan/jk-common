package sg01.common.api.di.error;

public class ConstructorNotFoundException extends DependencyCreateException {

    public ConstructorNotFoundException(String message) {
        super(message);
    }

    public ConstructorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
