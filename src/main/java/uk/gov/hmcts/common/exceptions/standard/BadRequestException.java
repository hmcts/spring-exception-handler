package uk.gov.hmcts.common.exceptions.standard;

import org.springframework.http.HttpStatus;
import uk.gov.hmcts.common.exceptions.BaseRuntimeException;

public class BadRequestException extends BaseRuntimeException {

    public BadRequestException(String title, String detail) {
        this(title, detail, null);
    }

    public BadRequestException(String title, String detail, Throwable cause) {
        super(HttpStatus.BAD_REQUEST, title, detail, cause);
    }
}
