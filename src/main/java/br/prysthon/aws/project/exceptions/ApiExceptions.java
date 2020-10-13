package br.prysthon.aws.project.exceptions;

public class ApiExceptions extends RuntimeException{
    protected Integer status = 400;

    public ApiExceptions() {}

    public ApiExceptions(String message) {
        super(message);
    }

    public ApiExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
