timeout(time: 30, unit: 'MINUTES') {
    dir ("ci/jenkins/scripts") {
        sh "./coverage.sh -s ${env.WORKSPACE}/milvus/core -o /opt/milvus -u root -p 123456 -t \$POD_IP"
    }
}

