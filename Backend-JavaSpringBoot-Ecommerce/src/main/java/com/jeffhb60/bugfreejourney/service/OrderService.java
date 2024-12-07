package com.jeffhb60.bugfreejourney.service;

import com.jeffhb60.bugfreejourney.dto.OrderDTO;

public interface OrderService {
    OrderDTO placeOrder(String emailId, Long addressId, String paymentMethod, String pgName, String pgPaymentId,
                        String pgStatus, String pgResponseMessage);
}
