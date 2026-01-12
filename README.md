# hmcts-spring-exception-handler
Common library for exception handling in spring applications.


Exception handling is done using a `@ControllerAdvice` class that handles exceptions thrown by controllers and services. It provides a consistent way to handle exceptions and return appropriate HTTP responses.
The library includes the following features:

Standard Exceptions: 4XX
- `BadRequestException`: Represents a 400 Bad Request error.
- `UnauthorizedException`: Represents a 401 Unauthorized error.
- `ForbiddenException`: Represents a 403 Forbidden error.
- `NotFoundException`: Represents a 404 Not Found error.
- `MethodNotAllowedException`: Represents a 405 Method Not Allowed error.
- `ConflictException`: Represents a 409 Conflict error.
- `UnprocessableEntityException`: Represents a 422 Unprocessable Entity error.
- `BusinessRuleViolationException`: Represents a business rule violation. (Extends UnprocessableEntityException)
- `FeatureDisabledException`: Represents a disabled feature error. (Extends MethodNotAllowedException)
  Standard Exceptions: 5XX
- `BadGatewayException`: Represents a 502 Bad Gateway error.
- `ServiceUnavailableException`: Represents a 503 Service Unavailable error.
- `InternalServerErrorException`: Represents a 500 Internal Server Error.


# Publishing

This library can be published to the Azure Maven repository by using the `Publish to Azure Artifacts` Action in
the GitHub repo.
