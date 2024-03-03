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
                    sshagent (['EC2-KEY']) {
                        sh "scp -o StrictHostKeyChecking=no websetup.sh ubuntu@3.252.83.53:/home/ubuntu"
                        sh "ssh -o StrictHostKeyChecking=no ubuntu@3.252.83.53 ${shellCmd}"
                    }
                }
            }
        }
    }
}