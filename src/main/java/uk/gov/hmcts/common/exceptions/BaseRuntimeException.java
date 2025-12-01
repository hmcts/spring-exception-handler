package uk.gov.hmcts.common.exceptions;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import uk.gov.hmcts.common.util.LogUtil;

import java.net.URI;

@Slf4j
@Getter
public class BaseRuntimeException extends RuntimeException {

    @Setter
    private boolean logError = true;
    @Setter
    private boolean isWarning = true;
    @Setter
    private boolean isRetryable = false;
    private final HttpStatus status;
    private final String title;
    private final String detail;
    private final String type;

    public BaseRuntimeException(HttpStatus status, String title, String detail, String type, Throwable cause) {
        super(detail, cause);
        this.status = status;
        this.title = title;
        this.detail = detail;
        this.type = type == null ? getClass().getSimpleName() : type;
    }

    public BaseRuntimeException(HttpStatus status, String title, String detail, Throwable cause) {
        this(status, title, detail, null, cause);
    }

    public BaseRuntimeException(HttpStatus status, String title, String detail) {
        this(status, title, detail, null, null);
    }


    public ProblemDetail createProblemDetail() {
        String operationId = LogUtil.getOrCreateOperationId();
        if (logError) {
            log.error("An error has occurred ID {}:", operationId, this);
        }
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status, detail);
        problemDetail.setTitle(title);
        problemDetail.setType(URI.create("https://hmcts.gov.uk/problems/" + type));
        problemDetail.setInstance(URI.create("https://hmcts.gov.uk/problems/instance/" + operationId));

        problemDetail.setProperty("operation_id", operationId);
        problemDetail.setProperty("is_warning", isWarning);
        problemDetail.setProperty("is_retryable", isRetryable);
        return problemDetail;
    }
}
