pipeline {
    agent any

    stages {
        stage ('fetch code') {
            steps {
                script {
                    echo "Pull source code from Git"
                    git branch: 'jenkins', url: 'https://github.com/seunayolu/jenkins_deploy_ec2.git'
                }
            }
        }
        
        stage ('deploy to EC2') {
            steps {
                script {
                    echo "deploying to shell-script to ec2"
                    def shellCmd = "bash ./websetup.sh"
                    sshagent (['ec2-server-key']) {
                        sh "scp websetup.sh ubuntu@34.244.52.132:/home/ubuntu"
                        sh "ssh -o StrictHostKeyChecking=no ubuntu@34.244.52.132 ${shellCmd}"
                    }
                }
            }
        }
    }
}