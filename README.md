<<<<<<< HEAD
Clémence Starosta & Héloise Bellahcene

# **Web & android development project - Web part**
# Famous women in Paris - Portraits - Paris Data

#### This projet is deploy on Clever Cloud in 'ISMIN CS' - 'Women - CSHB'
## This project contains the following files

- A `Woman` interface containing 7 string attributes:
  - `name` (string)
  - `category` (string)
  - `desc1` (string)
  - `desc2` (string)
  - `desc3` (string)
  - `desc4` (string)
  - `desc5` (string)

A `ApiWoman`interface containing 7 string attributes:
  - `name` (string)
  - `category` (string)
  - `desc1` (string)
  - `desc2` (string)
  - `desc3` (string)
  - `desc4` (string)
  - `desc5` (string)

A `main` contains the bootstrap of the application with :
  - The module to start 
  - The port that the server will listen : port 8080

A `woman.controller` receives and processes requests
  - `Get `  provide all women
  - ` Post - createWoman` Adding a new woman to the API
  - ` Get - WomanByName` Return a woman according to her name
  - ` Get - getWomanDescr` Return a descrpition of a woman using her name
  - ` Delete - DeleteWoman` Delete a woman by her name

A `woman.service` classes containing
  -` async loadWomenFromAPI()` Loads all women from the API
  - `addWoman(woman: Woman)`
  - `getWoman(name: string)` returning a `Woman`
  - `getDescriptionOf(name: string)` returning an array of `Description`s
  - `getAllWomen()` returning an array of `Woman`s
  - `getTotalNumberOfWomen()` returning a number
  - `removeWoman(name: string)`

A `woman.module` Links all Nest components

A `womanDTO` classes with the woman constructor

##  Getting Started

Open a terminal, go to the directory and run the following commands:

```sh
# This will install all needed dependencies
npm install

# This will build the source and put the transpiled code in `/dist` directory
npm run build

# This will committed the project
git add .
git commit -m "new"

# This will added new features to clever cloud
git push clever main:master

# This will start the API 
npm run start:dev
```

## For the API

```sh
# Example of request
   - See all women : `https://app-0e186a35-b187-42f9-8331-300c0017c6f9.cleverapps.io/women`
   - See information about Chana Orloff: ` https://app-0e186a35-b187-42f9-8331-300c0017c6f9.cleverapps.io/women/Chana%20Orloff`
   - See all descriptions of  Chana Orloff: `https://app-0e186a35-b187-42f9-8331-300c0017c6f9.cleverapps.io/women/Chana%20Orloff/desc` 

 ```
=======
Clémence Starosta & Héloise Bellahcene

# **Web & android development project - Web part**
# Famous women in Paris - Portraits - Paris Data

#### This projet is deploy on Clever Cloud in 'ISMIN CS' - 'Women - CSHB'
## This project contains the following files

- A `Woman` interface containing 7 string attributes:
  - `name` (string)
  - `category` (string)
  - `desc1` (string)
  - `desc2` (string)
  - `desc3` (string)
  - `desc4` (string)
  - `desc5` (string)

A `ApiWoman`interface containing 7 string attributes:
  - `name` (string)
  - `category` (string)
  - `desc1` (string)
  - `desc2` (string)
  - `desc3` (string)
  - `desc4` (string)
  - `desc5` (string)

A `main` contains the bootstrap of the application with :
  - The module to start 
  - The port that the server will listen : port 8080

A `woman.controller` receives and processes requests
  - `Get `  provide all women
  - ` Post - createWoman` Adding a new woman to the API
  - ` Get - WomanByName` Return a woman according to her name
  - ` Get - getWomanDescr` Return a descrpition of a woman using her name
  - ` Delete - DeleteWoman` Delete a woman by her name

A `woman.service` classes containing
  -` async loadWomenFromAPI()` Loads all women from the API
  - `addWoman(woman: Woman)`
  - `getWoman(name: string)` returning a `Woman`
  - `getDescriptionOf(name: string)` returning an array of `Description`s
  - `getAllWomen()` returning an array of `Woman`s
  - `getTotalNumberOfWomen()` returning a number
  - `removeWoman(name: string)`

A `woman.module` Links all Nest components

A `womanDTO` classes with the woman constructor

##  Getting Started

Open a terminal, go to the directory and run the following commands:

```sh
# This will install all needed dependencies
npm install

# This will build the source and put the transpiled code in `/dist` directory
npm run build

# This will committed the project
git add .
git commit -m "new"

# This will added new features to clever cloud
git push clever main:master

# This will start the API 
npm run start:dev
```

## For the API

```sh
# Example of request
   - See all women : `https://app-0e186a35-b187-42f9-8331-300c0017c6f9.cleverapps.io/women`
   - See information about Chana Orloff: ` https://app-0e186a35-b187-42f9-8331-300c0017c6f9.cleverapps.io/women/Chana%20Orloff`
   - See all descriptions of  Chana Orloff: `https://app-0e186a35-b187-42f9-8331-300c0017c6f9.cleverapps.io/women/Chana%20Orloff/desc` 

 ```
>>>>>>> 3c3a10b4f6e4738c522558416c642eb9528ef68a
