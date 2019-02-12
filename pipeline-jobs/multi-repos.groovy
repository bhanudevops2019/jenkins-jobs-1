node('SLAVE') {
    stage('One') {
      dir('CODE') {
        git 'https://github.com/citb34/studentapp-ui.git'
        sh 'ls'
      }
    }

    stage('Two') {
      dir('TERRAFORM') {
        git 'https://github.com/citb34/Terraform.git'
        sh 'ls'
      }
    }
    stage('Three') {
        sh 'ls'
    }
}