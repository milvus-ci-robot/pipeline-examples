timeout(time: 60, unit: 'MINUTES') {
    dir ("milvus") {
        checkout([$class: 'GitSCM', branches: [[name: "${SEMVER}"]], userRemoteConfigs: [[url: "https://github.com/milvus-io/milvus.git", name: 'origin', refspec: "+refs/heads/${SEMVER}:refs/remotes/origin/${SEMVER}"]]])
    }
    dir ("ci/jenkins/scripts") {
        sh "./build.sh -s ${env.WORKSPACE}/milvus/core -l"
        withCredentials([usernamePassword(credentialsId: "${params.JFROG_CREDENTIALS_ID}", usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
            sh "export JFROG_ARTFACTORY_URL='${params.JFROG_ARTFACTORY_URL}' && export JFROG_USER_NAME='${USERNAME}' && export JFROG_PASSWORD='${PASSWORD}' && ./build.sh -s ${env.WORKSPACE}/milvus/core -t ${params.BUILD_TYPE} -o /opt/milvus -d /opt/milvus -j -u -c"
        }
    }
}

