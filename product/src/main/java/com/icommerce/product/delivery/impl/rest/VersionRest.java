package com.icommerce.product.delivery.impl.rest;

import com.icommerce.product.core.shared.ConstantUtils;
import com.icommerce.product.delivery.VersionController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionRest implements VersionController {

    @GetMapping(ConstantUtils.RESOURCE_VERSION)
    @Override
    public String getVersion() {
        return "v.1.0.0";
    }
}
