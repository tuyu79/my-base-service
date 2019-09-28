package com.turan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GlobalSequenceService
{
    @Autowired
    private SequenceGenerator sequenceGenerator;

    public Long nextId()
    {
        return sequenceGenerator.nextId();
    }
}
