package com.asso.Utils;

import javax.validation.constraints.NotEmpty;

public class PhoneNumber {

    @NotEmpty
    private String value;

    @NotEmpty
    private String locale;
}