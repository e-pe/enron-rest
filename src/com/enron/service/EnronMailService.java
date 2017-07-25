package com.enron.service;

import com.enron.service.dto.EnronMailDtoResult;

public interface EnronMailService {
    EnronMailDtoResult searchMails(String query);
}
