package pholib.web;

/**
 * Created by melina on 4/1/17.
 */
public class FlashMessage {
    private String message;
    private Status status;

    public FlashMessage(String message, Status status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public Status getStatus() {
        return status;
    }

    public static enum Status {
        SUCCESS, FAILURE
    }

}
