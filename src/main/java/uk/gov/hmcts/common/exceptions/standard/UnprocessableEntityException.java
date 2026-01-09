package uk.gov.hmcts.common.exceptions.standard;

import org.springframework.http.HttpStatus;
import uk.gov.hmcts.common.exceptions.BaseRuntimeException;

public class UnprocessableEntityException extends BaseRuntimeException {
    public UnprocessableEntityException(String title, String detail) {
        this(title, detail, null);
    }

    public UnprocessableEntityException(String title, String detail, Throwable cause) {
        this(title, detail, null, cause);
    }

    public UnprocessableEntityException(String title, String detail, String type, Throwable cause) {
        super(HttpStatus.UNPROCESSABLE_CONTENT, title, detail, type, cause);
    }
}
