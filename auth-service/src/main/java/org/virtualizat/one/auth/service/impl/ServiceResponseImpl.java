package org.virtualizat.one.auth.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.virtualizat.one.auth.service.ServiceResponse;
import org.virtualizat.one.auth.service.util.MessageCode;

@AllArgsConstructor
@NoArgsConstructor
public class ServiceResponseImpl<T> implements ServiceResponse<T> {

    private MessageCode messageCode;
    private T entity;

    @Override
    public MessageCode getMessageCode() {
        return messageCode;
    }

    @Override
    public T getEntity() {
        return entity;
    }

    @Override
    public void setMessageCode(MessageCode messageCode) {
        this.messageCode = messageCode;
    }

    @Override
    public void setEntity(T entity) {
        this.entity = entity;
    }
}