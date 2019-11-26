#!/bin/bash

git log --decorate | head -n 1 | sed 's/.*(\(.*\))/\1/'
git log --decorate | head -n 1 | sed 's/.*(\(.*\))/\1/' | sed 's/.*, //'
git log --decorate | head -n 1 | sed 's/.*(\(.*\))/\1/' | sed 's/.*, //' | sed 's=[a-zA-Z]*\/==g'