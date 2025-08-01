package uk.gov.hmcts.common.exceptions.standard;

import org.springframework.http.HttpStatus;
import uk.gov.hmcts.common.exceptions.BaseRuntimeException;

public class InternalServerErrorException extends BaseRuntimeException {
    public InternalServerErrorException(String title, String detail) {
        this(title, detail, null);
    }

    public InternalServerErrorException(String title, String detail, Throwable cause) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, title, detail, cause);
        setWarning(false);
    }
}
