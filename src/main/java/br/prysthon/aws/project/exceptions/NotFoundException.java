package br.prysthon.aws.project.exceptions;

public class NotFoundException extends ApiExceptions {
    public static final Integer STATUS_CODE = 404;

    public NotFoundException(String message) {
        super(message);
        this.status = STATUS_CODE;
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
