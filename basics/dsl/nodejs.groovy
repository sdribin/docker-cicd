job('NodeJS example') {
    scm {
        git('git://github.com/sdribin/docker-cicd.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('sdribin')
            node / gitConfigEmail('jenkins-dsl@newtech.academy')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('NodeJS') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        shell("npm install")
    }
}

