# grpc-ex

## Prepare Spring-Boot Project

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

## Create proto schema

create new proto schema
- [event.proto](./event.proto)

## gRPC source generate

## References

- [gRPC 사용법, gRPC 예제 코드 실행해보기, 원리는 몰라도 gRPC 입문은 가능하다 (grpc java example)](https://jeong-pro.tistory.com/192)
- [what-is-grp](https://grpc.io/docs/what-is-grpc/introduction/)
