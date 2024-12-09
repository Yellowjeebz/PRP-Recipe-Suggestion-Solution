# First stage:
FROM gradle:8.11.1 as stage-0
# Refer to the name + version of an existing image that is in our container registry somewhere (pull this if we don't already have it locally)
WORKDIR /usr/src/ssh_rss
# Docker creates a new directory "/usr/src/ssh_rss" if it doesn't already exist
COPY . .
#copies local files on our working directory into the base image
RUN gradle installDist --no-daemon
#builds the code (as well as a few artefacts that result from this)

# debugging(checks the build output)
RUN ls -R /usr/src/ssh_rss/build/install

#Second stage:
FROM openjdk:17-jdk-slim as stage-1
# Start with a new base image - from the registry
WORKDIR /root/
COPY --from=stage-0 /usr/src/ssh_rss/build/install/PRP-Recipe-Suggestion-Solution .
#Copying some files from the first image we created. from=0 as it's got no name. 
CMD ["./bin/PRP-Recipe-Suggestion-Solution"]
#instructs the container runtime to execute the script and start
