package io.vicevil4.grpc;

import io.grpc.stub.StreamObserver;
import io.vicevil4.grpc.proto.EventRequest;
import io.vicevil4.grpc.proto.EventResponse;
import io.vicevil4.grpc.proto.NewdataServiceGrpc;
import org.springframework.stereotype.Service;

@Service
public class NewdataServiceImpl extends NewdataServiceGrpc.NewdataServiceImplBase {

    @Override
    public void unaryEvent(EventRequest request, StreamObserver<EventResponse> responseObserver) {
        super.unaryEvent(request, responseObserver);
    }

    @Override
    public void serverStreamingEvent(EventRequest request, StreamObserver<EventResponse> responseObserver) {
        super.serverStreamingEvent(request, responseObserver);
    }

    @Override
    public StreamObserver<EventRequest> clientStreamingEvent(StreamObserver<EventResponse> responseObserver) {
        return super.clientStreamingEvent(responseObserver);
    }

    @Override
    public StreamObserver<EventRequest> biStreamingEvent(StreamObserver<EventResponse> responseObserver) {
        return super.biStreamingEvent(responseObserver);
    }
}
