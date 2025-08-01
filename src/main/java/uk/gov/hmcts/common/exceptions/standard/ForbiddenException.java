package uk.gov.hmcts.common.exceptions.standard;

import org.springframework.http.HttpStatus;
import uk.gov.hmcts.common.exceptions.BaseRuntimeException;

public class ForbiddenException extends BaseRuntimeException {

    public ForbiddenException(String title, String detail) {
        this(title, detail, null);
    }

    public ForbiddenException(String title, String detail, Throwable cause) {
        super(HttpStatus.FORBIDDEN, title, detail, cause);
        setWarning(false);
    }
}
