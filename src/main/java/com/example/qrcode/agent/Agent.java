package com.example.qrcode.agent;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Agent {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;

    private String name;

    private String tradeLicenseNo;

    private String contactNumber;

    private String shopAddress;
}
