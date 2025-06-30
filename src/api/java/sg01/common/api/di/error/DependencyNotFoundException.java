package sg01.common.api.di.error;

public class DependencyNotFoundException extends DependencyCreateException {

    public DependencyNotFoundException(String message) {
        super(message);
    }

    public DependencyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
