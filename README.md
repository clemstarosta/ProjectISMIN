- A `Woman` interface containing 7 string attributes:
  - `name`
  - `category`
  - `desc1`
  - `desc2`
  - `desc3`
  - `desc4`
  - `desc5`
-  A `WomenList` class that internally store women and have the following public functions:
  - `addWoman(woman: Woman)`
  - `getWoman(name: string)` returning a `Woman`
  - `getDescriptionOf(name: string)` returning an array of `Description`s
  - `getAllWomen()` returning an array of `Woman`s
  - `getTotalNumberOfWomen()` returning a number



## 🚀 Getting Started

Open a terminal, go to the directory of this TP and run the following commands:

```sh
# This will install all needed dependencies
npm install

# This will run the tests once
npm run test

OR

# This will run the tests everytime a change is made in the source code
npm run test:watch

# This will build the source and put the transpiled code in `/dist` directory
npm run build
```
