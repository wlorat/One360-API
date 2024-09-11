package org.virtualizat.one.plugin.service.util;

import lombok.Getter;

@Getter
public enum MessageCode {

    // Códigos de éxito
    CREATED("SUCCESS_001", "The entity was successfully created."),
    UPDATED("SUCCESS_002", "The entity was successfully updated."),
    DELETED("SUCCESS_003", "The entity was successfully deleted."),
    FOUND("SUCCESS_004", "The entity was successfully found."),

    // Códigos de advertencia (warnings)
    ALREADY_EXISTS("WARNING_001", "The entity already exists."),
    NOT_MODIFIED("WARNING_002", "No changes were made to the entity."),

    // Códigos de error
    NOT_FOUND("ERROR_001", "The entity was not found."),
    VALIDATION_FAILED("ERROR_002", "The entity failed validation."),
    OPERATION_FAILED("ERROR_003", "The operation could not be completed."),
    INTERNAL_ERROR("ERROR_004", "An internal error occurred."),

    // Códigos de autenticación/autorización
    UNAUTHORIZED("AUTH_001", "User is not authorized."),
    FORBIDDEN("AUTH_002", "Access to the resource is forbidden."),
    TOKEN_EXPIRED("AUTH_003", "The authentication token has expired.");

    private final String code;
    private final String description;

    MessageCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

}
