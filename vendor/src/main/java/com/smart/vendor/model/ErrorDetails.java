package com.smart.vendor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Choudhury Subham on 21-06-2022
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {

    private Integer errorCode;
    private String details;
    private Date date;

}
