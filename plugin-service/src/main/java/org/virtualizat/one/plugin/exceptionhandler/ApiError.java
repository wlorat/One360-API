package org.virtualizat.one.plugin.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {
    private Integer status;
    private OffsetDateTime timestamp;
    private String detail;
    private String userMessage;
    private List<FieldError> fields;

    public record FieldError(
            String name,
            String userMessage
    ) {

    }
}
