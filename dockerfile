FROM gradle:8.11.1 
#refer to the name + version of an existing image that is in our container registry somewhere (pull this if we don't already have it locally)
WORKDIR /usr/src/ssh_rss 
#Docker creates a new directory "/usr/src/ssh_rss" if it doesn't already wxist
COPY . . 
#copies local files on our working directory into the base image. 
RUN gradle installDist
#builds code (as well as a few artefacts that result from this)

#Second stage:
FROM gradle:jre12
WORKDIR /root/
#Start with a new base image - from the registry
COPY --from=0 /usr/src/ssh_rss/app/build/install/app .
#Copying some files from the first image we created. from=0 as it's got no name. 
CMD ["./bin/app"] 
#instructs the container runtime to execute the script and start
#For testing (remove above COPY and CMD and use these instead):
#COPY --from=0 /usr/src/ssh_rss
#CMD ["gradle", "run"]