#!/bin/bash
./gradlew bootRun &
BACKEND_PID=$!


sleep 10


cd src/main/frontend/gui
npm start


kill $BACKEND_PID
