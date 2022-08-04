package com.example.qrcode.agent;

import com.example.qrcode.qrcode.QrCodeSubmitRequestModel;
import com.google.zxing.WriterException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class AgentController {

    private final AgentService agentService;

    @PostMapping(value = "/agent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Agent addAgent(@RequestBody Agent agent) throws IOException, WriterException {
        return agentService.addAgent(agent);
    }

    @GetMapping(value = "/agent/{agentId}")
    public byte[] getEncodedQrCode(@PathVariable int agentId) throws IOException, WriterException {
        return agentService.getEncodedQrCode(agentId);
    }

    @PostMapping(value = "/agent/qr", produces = MediaType.APPLICATION_JSON_VALUE)
    public Agent getAgentInfo(@RequestBody QrCodeSubmitRequestModel qrCodeSubmitRequestModel) {
        return agentService.getAgentInfo(qrCodeSubmitRequestModel);
    }
}
