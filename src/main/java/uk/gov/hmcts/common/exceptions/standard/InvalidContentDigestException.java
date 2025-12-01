package uk.gov.hmcts.common.exceptions.standard;

public class InvalidContentDigestException
    extends BadRequestException {
    public InvalidContentDigestException(String title, String detail) {
        super(title, detail);
    }
}
