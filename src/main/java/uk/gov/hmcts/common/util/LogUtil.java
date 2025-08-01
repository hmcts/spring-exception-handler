package uk.gov.hmcts.common.util;

import com.microsoft.applicationinsights.extensibility.context.OperationContext;
import com.microsoft.applicationinsights.telemetry.BaseTelemetry;
import com.microsoft.applicationinsights.telemetry.TelemetryContext;
import com.microsoft.applicationinsights.web.internal.RequestTelemetryContext;
import com.microsoft.applicationinsights.web.internal.ThreadContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import java.util.Optional;
import java.util.UUID;

@Slf4j
public final class LogUtil {

    private LogUtil() {

    }

    public static String getOrCreateOperationId() {
        return getOperationContext()
            .map(OperationContext::getId)
            .orElseGet(LogUtil::createOperation);
    }

    public static String createOperation() {
        String operationId = UUID.randomUUID().toString().replace("-", "");
        log.debug("Created new operation with ID: {}", operationId);

        //Update the operation context if it exists, otherwise use MDC
        Optional<OperationContext> operationContextOpt = getOperationContext();
        if (operationContextOpt.isPresent()) {
            OperationContext operationContext = operationContextOpt.get();
            operationContext.setId(operationId);
            return operationId;
        } else {
            MDC.put("operation_id", operationId);
        }
        return operationId;
    }

    private static Optional<OperationContext> getOperationContext() {
        return Optional.ofNullable(ThreadContext.getRequestTelemetryContext())
            .map(RequestTelemetryContext::getHttpRequestTelemetry)
            .map(BaseTelemetry::getContext)
            .map(TelemetryContext::getOperation);
    }
}
