package com.icommerce.order.delivery.impl.rest;

import com.icommerce.order.delivery.VersionController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionRest implements VersionController {

    @GetMapping("/version")
    @Override
    public String getVersion() {
        return "v.1.0.0";
    }
}
