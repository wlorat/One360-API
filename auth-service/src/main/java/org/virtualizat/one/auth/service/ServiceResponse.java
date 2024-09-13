package org.virtualizat.one.auth.service;

import org.virtualizat.one.auth.service.util.MessageCode;

public interface ServiceResponse<T> {

    MessageCode getMessageCode();
    T getEntity();
    void setMessageCode(MessageCode messageCode);
    void setEntity(T entity);
}
