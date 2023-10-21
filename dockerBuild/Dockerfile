# Use an official base image from Docker Hub
FROM ubuntu:20.04

# Install additional libraries or packages if required
RUN apt-get update && apt-get install -y \
    openjdk-17-jre \
    libxext6 \
    libxrender1 \
    libxtst6 \
    libxi6

# Set environment variables for X11

ENV DISPLAY=:0.0
ENV GDK_BACKEND=x11
ENV LIBGL_ALWAYS_INDIRECT=1


# Set the working directory
WORKDIR /app

# Copy compiled .class files and any other necessary files into the container
COPY target/ /app/

# Run the Java GUI application
CMD ["java", "-cp", "/app/", "com.standings.ui.Drawing"]
