package com.example.qrcode.agent;

import com.example.qrcode.qrcode.QrCodeService;
import com.example.qrcode.qrcode.QrCodeSubmitRequestModel;
import com.example.qrcode.qrcodemapper.QrCodeMapper;
import com.example.qrcode.qrcodemapper.QrCodeMapperRepository;
import com.google.zxing.WriterException;
import lombok.RequiredArgsConstructor;
import org.hibernate.id.UUIDGenerator;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AgentService {

    private final AgentRepository agentRepository;

    private final QrCodeService qrCodeService;

    private final QrCodeMapperRepository qrCodeMapperRepository;

    public Agent addAgent(Agent agent) throws IOException, WriterException {
        Agent savedAgent = agentRepository.save(agent);

        QrCodeMapper qrCodeMapper = new QrCodeMapper();
        qrCodeMapper.setQrText(UUID.randomUUID().toString());
        qrCodeMapper.setAgentId(agent.getId());
        qrCodeMapperRepository.save(qrCodeMapper);

        return savedAgent;
    }

    public Agent getAgentInfo(QrCodeSubmitRequestModel qrCodeSubmitRequestModel) {
        QrCodeMapper qrCodeMapper = qrCodeMapperRepository.findByQrText(qrCodeSubmitRequestModel.getEncodedData());
        Optional<Agent> agentOptional = agentRepository.findById(qrCodeMapper.getAgentId());
        if (agentOptional.isPresent()) {
            return agentOptional.get();
        }
        throw new RuntimeException("Error");
    }

    public byte [] getEncodedQrCode(int agentId) throws IOException, WriterException {
        String qrText = qrCodeMapperRepository.findByAgentId(agentId).getQrText();
        return qrCodeService.getQRCodeImage(qrText, 300, 300);
    }
}
