#!/bin/bash

git log --decorate | head -n 1 | sed 's/.*(\(.*\))/\1/'
git log --decorate | head -n 1 | sed 's/.*(\(.*\))/\1/' | sed 's/.*, //'
git log --decorate | head -n 1 | sed 's/.*(\(.*\))/\1/' | sed 's/.*, //' | sed 's=[a-zA-Z]*\/==g'

if [[ -n ${CHANGE_BRANCH} && ${BRANCH_NAME} == "PR-*"  ]];then
    echo "BRANCH_NAME: ${BRANCH_NAME} CHANGE_BRANCH: ${CHANGE_BRANCH}"
else
    echo "BRANCH_NAME: ${BRANCH_NAME}"
fi
