package com.example.cameldemo.route;


import com.example.cameldemo.model.RawFileEnvelope;
import com.example.cameldemo.model.enums.SourceChannel;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


import java.time.Instant;

@Component
public class FileIntakeRouteFile extends RouteBuilder {
    public void configure() throws Exception {
        from("file:input?delay=2000&noop=true").log("file name : ${header.CamelFileName}")
                .process(exchange -> {
            RawFileEnvelope envelope = new RawFileEnvelope();
            envelope.setRawByte(exchange.getIn().getBody(byte[].class));
            envelope.setReceivedAt(Instant.now());
            envelope.setFileName(exchange.getIn().getHeader(Exchange.FILE_NAME,String.class));
            envelope.setSourceChannel(SourceChannel.FILE);

            exchange.getIn().setBody(envelope.toString());
        })
            .to("file:output");
    }
}
