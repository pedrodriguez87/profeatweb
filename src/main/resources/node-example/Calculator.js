console.log("Testing in js");

class Calculator {
    constructor() {
        this.value = 0;
    }

    add(amount) {
        this.value += amount;
    }
}

module.exports = Calculator; //exports the calculator class

/*
* Mònica@LAPTOP-98JU0OBT MINGW64 ~/profeatweb/src/main/resources/node-example (mas                                                                                                                                  ter)
$ node --version
v10.15.3

Mònica@LAPTOP-98JU0OBT MINGW64 ~/profeatweb/src/main/resources/node-example (mas                                                                                                                                  ter)
$ npm init -y
Wrote to C:\Users\Mònica\profeatweb\src\main\resources\node-example\package.json                                                                                                                                  :

{
  "name": "node-example",
  "version": "1.0.0",
  "description": "",
  "main": "test.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "keywords": [],
  "author": "",
  "license": "ISC"
}



Mònica@LAPTOP-98JU0OBT MINGW64 ~/profeatweb/src/main/resources/node-example (mas                                                                                                                                  ter)
$ npm install --save-dev jest

npm notice created a lockfile as package-lock.json. You should commit this file.
npm WARN node-example@1.0.0 No description
npm WARN node-example@1.0.0 No repository field.

+ jest@24.5.0
added 488 packages from 388 contributors and audited 476662 packages in 54.023s
found 0 vulnerabilities


Mònica@LAPTOP-98JU0OBT MINGW64 ~/profeatweb/src/main/resources/node-example (mas                                                                                                                                  ter)
$

Mònica@LAPTOP-98JU0OBT MINGW64 ~/profeatweb/src/main/resources/node-example (mas                                                                                                                                  ter)
$ mv test.js Calculator.js

Mònica@LAPTOP-98JU0OBT MINGW64 ~/profeatweb/src/main/resources/node-example (mas                                                                                                                                  ter)
$ npm run test

> node-example@1.0.0 test C:\Users\Mònica\profeatweb\src\main\resources\node-exa                                                                                                                                  mple
> jest

PASS ./Calculator.test.js
  √ Calculator can add numbers (6ms)

  console.log Calculator.js:1
    Testing in js

Test Suites: 1 passed, 1 total
Tests:       1 passed, 1 total
Snapshots:   0 total
Time:        3.748s
Ran all test suites.*/
