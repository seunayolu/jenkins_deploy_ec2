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

        stage (deploy_to_ec2) {
            steps {
                script {
                    def apache_install = 'sudo apt update && sudo apt install apache2'
                    sshagent(['ec2-key']) {
                        sh "scp -o StrictHostKeyChecking=no -r 2137_barista_cafe/* ubuntu@54.194.76.102:/home/ubuntu"
                    }
                }
            }
        }
    }
}
