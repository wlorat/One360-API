package org.virtualizat.one.plugin.service;

import org.virtualizat.one.plugin.service.util.MessageCode;

public interface ServiceResponse<T> {

    MessageCode getMessageCode();
    T getEntity();
    void setMessageCode(MessageCode messageCode);
    void setEntity(T entity);
}
