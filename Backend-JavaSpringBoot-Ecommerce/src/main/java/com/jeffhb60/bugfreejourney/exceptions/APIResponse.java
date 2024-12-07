package com.jeffhb60.bugfreejourney.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class APIResponse {
    public String message;
    private boolean status;
}
