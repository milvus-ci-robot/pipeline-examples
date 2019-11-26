#!/bin/bash

git log --decorate | head -n 1 | sed 's/.*(\(.*\))/\1/'
git log --decorate | head -n 1 | sed 's/.*(\(.*\))/\1/' | sed 's/.*, //'
git log --decorate | head -n 1 | sed 's/.*(\(.*\))/\1/' | sed 's/.*, //' | sed 's=[a-zA-Z]*\/==g'

if [[ ${BRANCH_NAME} =~ "PR-" && ! -n ${CHANGE_BRANCH} ]];then
    echo "BRANCH_NAME: ${BRANCH_NAME} CHANGE_BRANCH: ${CHANGE_BRANCH}"
else
    echo "BRANCH_NAME: ${BRANCH_NAME}"
fi
