package com.enron.rest;
;
import javax.ws.rs.core.Response;

public interface EnronMailController {
    Response searchMails(String query);
}
