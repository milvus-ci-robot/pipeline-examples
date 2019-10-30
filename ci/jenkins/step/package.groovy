timeout(time: 5, unit: 'MINUTES') {
    def packageName = "${PROJECT_NAME}-ee-${PACKAGE_VERSION}.tar.gz"
    sh "tar -zcvf ./${packageName} -C /opt/ milvus"
    withCredentials([usernamePassword(credentialsId: "${params.JFROG_CREDENTIALS_ID}", usernameVariable: 'JFROG_USERNAME', passwordVariable: 'JFROG_PASSWORD')]) {
        def uploadStatus = sh(returnStatus: true, script: "curl -u${JFROG_USERNAME}:${JFROG_PASSWORD} -T ./${packageName} ${params.JFROG_ARTFACTORY_URL}/milvus/package/${packageName}")
        if (uploadStatus != 0) {
            error("\" ${packageName} \" upload to \" ${params.JFROG_ARTFACTORY_URL}/milvus/package/${packageName} \" failed!")
        }
    }
}
