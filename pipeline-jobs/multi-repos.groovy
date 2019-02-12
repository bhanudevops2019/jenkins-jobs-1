node('SLAVE') {
    stage('One') {
        git 'https://github.com/citb34/studentapp-ui.git'
        sh 'ls'
    }
    stage('Two') {
        git 'https://github.com/citb34/Terraform.git'
        sh 'ls'
    }
    stage('Three') {
        sh 'ls'
    }
}