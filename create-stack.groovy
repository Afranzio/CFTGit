pipeline {
    agent any

    stages {
        stage('git_check') {
            steps {
                //sh "cd /tmp"
                git branch: 'main', url: 'https://github.com/Afranzio/CFT.git'   
            }
		}
		stage('AWS-CFT'){
			steps {	
			    sh """
			        #cd /tmp/CFTGit
			        export PATH=/usr/local/bin:$PATH
			        pwd
			        aws cloudformation create-stack --stack-name NewStack --template-body file://t2.yml
			    """
			}
        }
    }
}