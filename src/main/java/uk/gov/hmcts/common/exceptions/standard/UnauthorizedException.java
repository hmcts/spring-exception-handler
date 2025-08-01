package uk.gov.hmcts.common.exceptions.standard;

import org.springframework.http.HttpStatus;
import uk.gov.hmcts.common.exceptions.BaseRuntimeException;

public class UnauthorizedException extends BaseRuntimeException {
    public UnauthorizedException(String title, String detail) {
        this(title, detail, null);
    }

    public UnauthorizedException(String title, String detail, Throwable cause) {
        super(HttpStatus.UNAUTHORIZED, title, detail, cause);
    }
}
