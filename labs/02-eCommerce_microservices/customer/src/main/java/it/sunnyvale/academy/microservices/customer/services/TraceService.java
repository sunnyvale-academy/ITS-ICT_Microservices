package it.sunnyvale.academy.microservices.customer.services;

import brave.Span;
import brave.Tracer;
import org.springframework.stereotype.Service;


@Service
public class TraceService {
    Tracer tracer;

    public TraceService(Tracer tracer) {
        this.tracer = tracer;
    }

    public String getTraceId() {
        Span span = tracer.currentSpan();
        String traceId = span.context().traceIdString();
        return traceId;
    }
}
