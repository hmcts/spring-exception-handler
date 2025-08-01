package uk.gov.hmcts.common.exceptions.standard;

import org.springframework.http.HttpStatus;
import uk.gov.hmcts.common.exceptions.BaseRuntimeException;

public class ConflictException extends BaseRuntimeException {
    public ConflictException(String title, String detail) {
        this(title, detail, null);
    }

    public ConflictException(String title, String detail, Throwable cause) {
        super(HttpStatus.CONFLICT, title, detail, cause);
    }
}
