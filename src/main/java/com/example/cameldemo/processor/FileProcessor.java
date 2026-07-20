package com.example.cameldemo.processor;

import com.example.cameldemo.model.RawFileEnvelope;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class FileProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        RawFileEnvelope env = new RawFileEnvelope();

    }
}
