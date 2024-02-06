pipeline{
    agent docker { image 'maven:3.6.3-openjdk-11-slim' }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean'
                sh 'mvn package'
                sh 'ls -lR target'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true, onlyIfSuccessful: true
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true, onlyIfSuccessful: true
                }
            }
        }
    }

}