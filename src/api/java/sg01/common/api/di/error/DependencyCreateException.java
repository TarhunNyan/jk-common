package sg01.common.api.di.error;

public class DependencyCreateException extends RuntimeException {

    public DependencyCreateException(String message) {
        super(message);
    }

    public DependencyCreateException(String message, Throwable cause) {
        super(message, cause);
    }

}
