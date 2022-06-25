#!/bin/bash

if ! which shellcheck &>/dev/null; then
  echo "shellcheck not found. Install shellcheck."
  exit 1
fi

exclude="SC2086"

for f in *; do
  is_shell=$(head -n1 "$f" | grep -E "^[#][!].+bin.+sh")
  if [ -n "$is_shell" ]; then
    echo ===============================================================================
    echo "Linting $f ..."
    shellcheck "$f" -e $exclude
  fi
done
