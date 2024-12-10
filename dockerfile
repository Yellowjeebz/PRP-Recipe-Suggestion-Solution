# First stage:
FROM gradle:8.11.1 as stage-0
# Refer to the name + version of an existing image that is in our container registry somewhere (pull this if we don't already have it locally)
WORKDIR /usr/src/ssh_rss
# Docker creates a new directory "/usr/src/ssh_rss" if it doesn't already exist
COPY . .
# Copies local files on our working directory into the base image
RUN gradle installDist --no-daemon
# Builds the code (as well as a few artefacts that result from this)

# Debugging: (check on the build output in the first stage)
RUN echo "Checking contents of /usr/src/ssh_rss/build/install:" && \
    ls -R /usr/src/ssh_rss/build/install

#Second stage:
FROM openjdk:21-jdk-slim as stage-1
# Start with a new base image - from the registry
WORKDIR /root/
COPY --from=stage-0 /usr/src/ssh_rss/build/install/PRP-Recipe-Suggestion-Solution .
# Copying some files from the first image we created. from=0 as it's got no name.

# Third stage (docker-compose):
RUN apt-get update && apt-get install -y \
    curl \
    python3 \
    pip \
    && pip install docker-compose \
    && apt-get clean && rm -rf /var/lib/apt/lists/*

# Debugging (optional: check installed versions)
RUN docker-compose --version

# Command to start the application (can be overridden in docker-compose.yml)
CMD ["./bin/PRP-Recipe-Suggestion-Solution"]
