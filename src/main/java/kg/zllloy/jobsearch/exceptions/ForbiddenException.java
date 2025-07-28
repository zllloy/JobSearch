package kg.zllloy.jobsearch.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForbiddenException extends RuntimeException {

    public ForbiddenException() {
        super("Access is denied");
    }

    public ForbiddenException(String message) {
        super(message);
    }
}
