package uk.gov.hmcts.common.exceptions.bespoke;

import uk.gov.hmcts.common.exceptions.standard.UnprocessableEntityException;

public class BusinessRuleViolationException extends UnprocessableEntityException {

    public BusinessRuleViolationException(String title, String detail) {
        super(title, detail);
        setLogError(false);
    }

    public BusinessRuleViolationException(String title, String detail, Throwable cause) {
        super(title, detail, cause);
    }
}
