FROM openjdk:17
WORKDIR /app
COPY . /app
ENV DISPLAY=:0.0
RUN shopt -s globstar && javac **/*.java
CMD ["java","ui.Drawing"]

