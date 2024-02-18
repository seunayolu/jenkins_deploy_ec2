/*def COLOR_MAP = [
    'SUCCESS': 'good', 
    'FAILURE': 'danger',
]*/

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

        stage ('Install Apache') {
            steps {
                script {
                    // Install Apache 2 On Ubuntu Server
                    def apache_install = echo "jenkins" | sshpass -p  "ssh -o StrictHostKeyChecking=no jenkins@172.31.33.221 'sudo -S apt update && sudo -S apt install -y apache2'"
                    sshagent(['EC2-KEY']) {
                        sh "${apache_install}"
                    }
                }
            }
        }
    }
}
