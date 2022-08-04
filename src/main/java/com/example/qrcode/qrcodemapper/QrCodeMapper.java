package com.example.qrcode.qrcodemapper;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class QrCodeMapper {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private int agentId;

    private String qrText;
}
