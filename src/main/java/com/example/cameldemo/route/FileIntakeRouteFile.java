package com.example.cameldemo.route;


import com.example.cameldemo.model.RawFileEnvelope;
import com.example.cameldemo.model.enums.SourceChannel;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


import java.time.Instant;

@Component
public class FileIntakeRouteFile extends RouteBuilder {
    public void configure() throws Exception{
        from("file:input").routeDescription("this route manage FILE canal").process(exchange -> {
            RawFileEnvelope envelope = new RawFileEnvelope();
            envelope.setRwaByte(exchange.getIn().getBody(Byte[].class));
            envelope.setReceivedAt(Instant.now());
            envelope.setFileName(exchange.getIn().getHeader(Exchange.FILE_NAME,String.class));
            envelope.setSourceChannel(SourceChannel.FILE);
        }).to("output");
    }
}
