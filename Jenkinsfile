pipeline{
    agent any
    tools{
        maven 'maven'
    }
    stages{
        stage('Maven Build'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Bhavyanth/Animalia']])
                bat 'mvn clean install'
            }
        }
        stage('Build Docker Image'){
            steps{
                script{
                    bat 'docker build -t bhavyanth02/animalia .'
                }
            }
        }
        stage('Push Image to Docker Hub'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerpwd', variable: 'dockerPassword')]) {
                        bat "docker login -u bhavyanth02 -p ${dockerPassword}"
                    }
                        bat 'docker push bhavyanth02/animalia'
                }
            }
        }
    }
}