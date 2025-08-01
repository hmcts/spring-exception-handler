package uk.gov.hmcts.common.exceptions.standard;

import org.springframework.http.HttpStatus;
import uk.gov.hmcts.common.exceptions.BaseRuntimeException;

public class MethodNotAllowedException extends BaseRuntimeException {
    public MethodNotAllowedException(String title, String detail) {
        this(title, detail, null);
    }

    public MethodNotAllowedException(String title, String detail, Throwable cause) {
        this(title, detail, null, cause);
    }

    public MethodNotAllowedException(String title, String detail, String type, Throwable cause) {
        super(HttpStatus.METHOD_NOT_ALLOWED, title, detail, type, cause);
        setWarning(false);
    }
}
