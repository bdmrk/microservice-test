package info.kausar.os.api.controller;

import info.kausar.os.api.common.TransactionRequest;
import info.kausar.os.api.common.TransactionResponse;
import info.kausar.os.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")

public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
        return  orderService.orderSave(request);
    }
}
