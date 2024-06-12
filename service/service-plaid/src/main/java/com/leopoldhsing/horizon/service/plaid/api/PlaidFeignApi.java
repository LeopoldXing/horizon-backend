package com.leopoldhsing.horizon.service.plaid.api;

import com.leopoldhsing.horizon.model.dto.ProcessorTokenCreationDto;
import com.leopoldhsing.horizon.service.plaid.service.IPlaidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequestMapping("/api/v1/inner/plaid")
@RestController
public class PlaidFeignApi {

    @Autowired
    private IPlaidService plaidService;

    @DeleteMapping("/access-token")
    public void deleteAccessToken() {
        plaidService.deleteAccessToken();
    }

    @PostMapping("/processor-token")
    public String getProcessorToken(@RequestBody ProcessorTokenCreationDto processorTokenCreationDto) {
        String processorToken = "";
        try {
            processorToken = plaidService
                    .getProcessorToken(processorTokenCreationDto.getUserDto(), processorTokenCreationDto.getAccountDto());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return processorToken;
    }
}
