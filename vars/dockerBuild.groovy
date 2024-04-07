def call(String dockerHubUsername, String imageName) {
    // Build the Docker image
    sh "docker build –-build-arg REACT_APP_RAPID_API_KEY=8ba2a8cb70msh66646143fb03b9cp1092a1jsn27926c8c79bb -t ${imageName} ."
     // Tag the Docker image
    sh "docker tag ${imageName} ${dockerHubUsername}/${imageName}:latest"
    // Push the Docker image
    withDockerRegistry([url: 'https://index.docker.io/v1/', credentialsId: 'docker']) {
        sh "docker push ${dockerHubUsername}/${imageName}:latest"
    }
}