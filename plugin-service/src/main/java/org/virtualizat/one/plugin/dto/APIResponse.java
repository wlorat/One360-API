package org.virtualizat.one.plugin.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.virtualizat.one.plugin.exceptionhandler.ApiError;
import org.virtualizat.one.plugin.service.util.MessageCode;

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
