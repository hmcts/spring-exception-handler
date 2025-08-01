package uk.gov.hmcts.common.exceptions.standard;

import org.springframework.http.HttpStatus;
import uk.gov.hmcts.common.exceptions.BaseRuntimeException;

public class ServiceUnavailableException extends BaseRuntimeException {
    public ServiceUnavailableException(String title, String detail) {
        this(title, detail, null);
    }

    public ServiceUnavailableException(String title, String detail, Throwable cause) {
        super(HttpStatus.SERVICE_UNAVAILABLE, title, detail, cause);
        setWarning(false);
    }
}
