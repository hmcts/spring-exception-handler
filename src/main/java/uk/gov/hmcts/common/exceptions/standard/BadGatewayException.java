package uk.gov.hmcts.common.exceptions.standard;

import org.springframework.http.HttpStatus;
import uk.gov.hmcts.common.exceptions.BaseRuntimeException;

public class BadGatewayException extends BaseRuntimeException {
    public BadGatewayException(String title, String detail) {
        this(title, detail, null);
    }

    public BadGatewayException(String title, String detail, Throwable cause) {
        super(HttpStatus.BAD_GATEWAY, title, detail, cause);
    }
}
