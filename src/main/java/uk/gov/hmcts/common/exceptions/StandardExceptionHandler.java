package uk.gov.hmcts.common.exceptions;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
@ConditionalOnProperty(
    prefix = "hmcts.common.exceptions",
    name = "enable-exception-handler",
    havingValue = "true",
    matchIfMissing = true
)
public class StandardExceptionHandler {


    @ExceptionHandler(BaseRuntimeException.class)
    public ResponseEntity<ProblemDetail> handleFeatureDisabledException(BaseRuntimeException ex) {
        return ResponseEntity.status(ex.getStatus())
            .contentType(MediaType.APPLICATION_PROBLEM_JSON)
            .body(ex.createProblemDetail());
    }
}
