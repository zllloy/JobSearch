package kg.zllloy.jobsearch.service;

import kg.zllloy.jobsearch.exceptions.ErrorResponseBody;
import org.springframework.validation.BindingResult;

public interface ErrorService {
    ErrorResponseBody makeResponse(BindingResult bindingResult);

    ErrorResponseBody makeResponse(Exception ex);
}
