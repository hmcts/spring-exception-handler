
package uk.gov.hmcts.common.exceptions.standard;

import org.springframework.http.HttpStatus;
import uk.gov.hmcts.common.exceptions.BaseRuntimeException;

public class NotFoundException extends BaseRuntimeException {
    public NotFoundException(String title, String detail) {
        this(title, detail, null);
    }

    public NotFoundException(String title, String detail, Throwable cause) {
        super(HttpStatus.NOT_FOUND, title, detail, cause);
    }
}
