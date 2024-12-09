# Stage 0: Build the application
FROM gradle:8.11.1 as stage-0
WORKDIR /usr/src/ssh_rss
COPY . .
RUN gradle installDist --no-daemon

# Debugging: Verify the build output
RUN ls -R /usr/src/ssh_rss/build/install

# Stage 1: Prepare the runtime image
FROM openjdk:17-jdk-slim as stage-1
WORKDIR /root/
COPY --from=0 /usr/src/ssh_rss/build/install/PRP-Recipe-Suggestion-Solution .
CMD ["./bin/PRP-Recipe-Suggestion-Solution"]
