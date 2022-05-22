package io.vicevil4.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class GrpcRunner implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(GrpcRunner.class);
    private Server server;
    private int port = 9090;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        server = ServerBuilder.forPort(port)
//                .addService(new NewdataServiceImpl())
                .build();
        server.start();
        logger.info("gRPC Server Listening on port " + port);
        server.awaitTermination();
    }
}
