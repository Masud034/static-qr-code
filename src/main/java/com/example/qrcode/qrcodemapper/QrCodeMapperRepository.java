package com.example.qrcode.qrcodemapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QrCodeMapperRepository extends JpaRepository<QrCodeMapper, Integer> {
    QrCodeMapper findByQrText(String qrText);

    QrCodeMapper findByAgentId(int agentId);
}
