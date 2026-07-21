package com.example.cameldemo.model;


import com.example.cameldemo.model.enums.SourceChannel;
import jakarta.persistence.Entity;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class RawFileEnvelope {
    byte[] rawByte;
    String fileName;
    SourceChannel sourceChannel ;
    String sourceBank;
    Instant receivedAt;
    UUID connectorId;
}
