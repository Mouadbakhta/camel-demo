package com.example.cameldemo.entity;


import com.example.cameldemo.entity.enums.SourceChannel;

import java.time.Instant;
import java.util.UUID;

public class RawFileEnvelope {
    Byte[] rwaByte;
    String fileName;
    SourceChannel sourceChannel ;
    String sourceBank;
    Instant receivedAt;
    UUID connectorId;
}
