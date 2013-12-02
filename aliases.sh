#!/bin/bash

alias branch="git branch -a"
alias log="git log --oneline"
alias logn="git log --oneline | head -n "
alias checkout="git checkout"
alias commit="git commit -m "
alias push="git push"
alias pull="git pull"
alias fetch="git fetch"
alias localBranches="git branch -a | grep -v remotes"
alias remoteBranches="git branch -a | grep remotes"
alias copyAliases="cp /t/Colin/aliases.sh .; source aliases.sh"
alias updateAliases="cp aliases.sh /t/Colin/aliases.sh"

commit=$(git log --oneline | head -n 1 | cut -d ' ' -f 1)
alias revertLC="git revert $commit"


