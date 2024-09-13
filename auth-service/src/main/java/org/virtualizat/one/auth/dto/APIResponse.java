package org.virtualizat.one.auth.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.virtualizat.one.auth.exceptionhandler.ApiError;
import org.virtualizat.one.auth.service.util.MessageCode;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class APIResponse<T> {

    private MessageCode status;
    private List<ApiError> errors;
    private T results;

}
