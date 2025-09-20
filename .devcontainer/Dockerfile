FROM eclipse-temurin:21-jdk

ARG MAVEN_VERSION=3.9.11
ARG USERNAME=java
ARG USER_UID=1010
ARG USER_GID=$USER_UID

# Install tools, create user, install Maven
RUN apt-get update \
    && apt-get install -y --no-install-recommends apt-utils ca-certificates curl git sudo unzip \
    && groupadd --gid ${USER_GID} ${USERNAME} || true \
    && useradd -s /bin/bash --uid ${USER_UID} --gid ${USER_GID} -m ${USERNAME} || true \
    && echo "${USERNAME} ALL=(ALL) NOPASSWD:ALL" > /etc/sudoers.d/${USERNAME} \
    && mkdir -p /tmp/maven \
    && curl -fsSL "https://dlcdn.apache.org/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.zip" -o /tmp/maven/maven.zip \
    && unzip /tmp/maven/maven.zip -d /opt \
    && mv /opt/apache-maven-${MAVEN_VERSION} /opt/maven \
    && rm -rf /tmp/maven \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# Environment
ENV M2_HOME=/opt/maven
ENV PATH=${M2_HOME}/bin:${PATH}
ENV JAVA_HOME=/opt/java/openjdk/

# Workspace
WORKDIR /workspace

# Switch to non-root user
USER ${USERNAME}

CMD [ "bash" ]
