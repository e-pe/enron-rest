package com.enron.service.dto;

import java.util.Vector;

public class EnronMailDtoResult {
    private Integer count;
    private Vector<EnronMailDto> mails;

    public EnronMailDtoResult() {
        this.mails = new Vector<>();
    }

    public Vector<EnronMailDto> getMails() {
        return this.mails;
    }

    public Integer getCount() {
        return this.count;
    }

    public EnronMailDtoResult setCount(Integer count) {
        this.count = count;

        return this;
    }
}
