# grpc-ex

## Prepare Spring-Boot Project

```sh
> java -version
openjdk version "11.0.9.1" 2020-11-04
OpenJDK Runtime Environment AdoptOpenJDK (build 11.0.9.1+1)
OpenJDK 64-Bit Server VM AdoptOpenJDK (build 11.0.9.1+1, mixed mode)
```

install spring-boot-cli

```sh
> brew tap spring-io/tap
> brew install spring-boot
> spring --version
Spring CLI v2.7.0
```

initialize spring-boot project

```sh
> spring init --build=maven --java-version=11 \
    --boot-version=2.6.3 \
    --dependencies=web,webflux,devtools \
    --groupId=io.vicevil4 \
    --artifactId=grpc-server \
    --name=grpc-server \
    --package-name=io.vicevil4.grpc \
    --description="gRPC Example" \
    --packaging=jar \
    grpc-server.zip
> unzip grpc-server.zip .
```

## Add gRPC Dependencies & Build Plugins

```xml

    <dependencies>
        <!-- grpc & protobuf-->
		<dependency>
			<groupId>io.grpc</groupId>
			<artifactId>grpc-netty-shaded</artifactId>
			<version>1.21.0</version>
		</dependency>
		<dependency>
			<groupId>io.grpc</groupId>
			<artifactId>grpc-protobuf</artifactId>
			<version>1.21.0</version>
		</dependency>
		<dependency>
			<groupId>io.grpc</groupId>
			<artifactId>grpc-stub</artifactId>
			<version>1.21.0</version>
		</dependency>
		<dependency>
			<groupId>com.google.protobuf</groupId>
			<artifactId>protobuf-java</artifactId>
			<version>3.8.0</version>
		</dependency>
    </dependencies>
 

    <build>
		<extensions>
			<extension>
				<groupId>kr.motd.maven</groupId>
				<artifactId>os-maven-plugin</artifactId>
				<version>1.5.0.Final</version>
			</extension>
		</extensions>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>

			<plugin>
				<groupId>org.xolstice.maven.plugins</groupId>
				<artifactId>protobuf-maven-plugin</artifactId>
				<version>0.6.1</version>

				<configuration>
					<!-- <protocExecutable>/usr/local/bin/protoc</protocExecutable> -->
					<protocArtifact>com.google.protobuf:protoc:3.14.0:exe:${os.detected.classifier}</protocArtifact>
					<pluginId>grpc-java</pluginId>
					<pluginArtifact>io.grpc:protoc-gen-grpc-java:1.46.0:exe:${os.detected.classifier}</pluginArtifact>
				</configuration>

				<executions>
					<execution>
						<goals>
							<goal>compile</goal>
							<goal>test-compile</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>
```

## Create proto schema

create new proto schema

- [event.proto](./src/main/proto/event.proto)

## gRPC source generate

```sh
> mvn clean compile
...
> ls -1 /Users/aincc/Works/spring/grpc-ex/target/generated-sources/protobuf/java/io/vicevil4/grpc/proto
EventProto.java
EventRequest.java
EventRequestOrBuilder.java
EventResponse.java
EventResponseOrBuilder.java
```

## References

- [gRPC 사용법, gRPC 예제 코드 실행해보기, 원리는 몰라도 gRPC 입문은 가능하다 (grpc java example)](https://jeong-pro.tistory.com/192)
- [what-is-grp](https://grpc.io/docs/what-is-grpc/introduction/)
