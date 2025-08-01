package uk.gov.hmcts.common.exceptions.bespoke;

import uk.gov.hmcts.common.exceptions.standard.MethodNotAllowedException;

public class FeatureDisabledException extends MethodNotAllowedException {
    public FeatureDisabledException(String title, String detail) {
        super(title, detail);
        setLogError(false);
        setWarning(false);
    }

    public FeatureDisabledException() {
        super("Feature Disabled", "The requested feature is not currently available", "feature-disabled", null);
    }
}
