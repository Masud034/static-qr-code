package com.example.qrcode.qrcode;

import com.example.qrcode.agent.Agent;
import com.google.zxing.WriterException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class QrCodeController {

    private final QrCodeService qrCodeService;

    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";


    @GetMapping(value = "/")
    public void generateQRCode(@RequestParam String content) throws IOException, WriterException {
        qrCodeService.generateQRCodeImage(content, 200, 300, QR_CODE_IMAGE_PATH);
    }

    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public byte [] getQrCode(String text) throws IOException, WriterException {
        return qrCodeService.getQRCodeImage(text, 300, 300);
    }

}
