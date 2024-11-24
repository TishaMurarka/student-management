pipeline {
    agent any
    stages {
        stage('Checkout Code') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: 'main']], 
                          userRemoteConfigs: [[url: 'https://github.com/your-github-repo/student-management.git']]])
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Deploy to AWS') {
            steps {
                withCredentials([sshUserPrivateKey(credentialsId: 'aws-ssh-key', keyFileVariable: 'SSH_KEY')]) {
                    sh '''
                        scp -i $SSH_KEY target/student-management-0.0.1-SNAPSHOT.jar ec2-user@<EC2_IP>:/home/ec2-user/
                        ssh -i $SSH_KEY ec2-user@<EC2_IP> 'nohup java -jar /home/ec2-user/student-management-0.0.1-SNAPSHOT.jar &'
                    '''
                }
            }
        }
    }
}
