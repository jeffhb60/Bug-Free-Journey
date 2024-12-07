package com.jeffhb60.bugfreejourney.dto;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class PaymentDTO {
    private Long paymentId;
    private String pgPaymentId;
    private String pgStatus;
    private String pgResponseMessage;
    private String pgName;
}
