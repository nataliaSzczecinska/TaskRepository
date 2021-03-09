#!/usr/bin/env bash

open_chrome() {
  open -a "Google Chrome" http://localhost:8080/crud/v1/task/getTasks
}

fail() {
   echo "There were errors"
}

end() {
   echo "Work is finished"
}

if ./runcrud.sh; then
  open_chrome
  end
else
   fail
   end
fi