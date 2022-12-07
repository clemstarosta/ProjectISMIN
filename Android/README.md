Clémence Starosta & Héloise Bellahcene

# **Web & android development project - Web part**
# Famous women in Paris - Portraits - Paris Data

## This project contains the following files

- 3 fragments:
    - A `CreateWomanFragment` class
        - `edtName` EditText : Name of the woman
        - `edtCategory` EditText : Category of the woman
        - `edtPlace` EditText : Place of the woman
        - `edtDesc1 edtDesc2, edtDesc3, edtDesc4, edtDesc` EditText : Short description of the woman
        - `edtLat edtLong` EditText: GPS coord of the woman
        - `edtURL` EditText : Picture URL of the woman
    Fragment that manages the display of the creation of a woman
        
    - A `DetailFragment` class
    Fragment that manages the display of the detail part of each woman
    
    - A `MapFragment` class
    Fragment that manages the display of the map
    - A `WomanListFragment` class
    Fragment that manages the display of the list of women

- 3 activity:
    - A `CreatorActivity` class
    Creative activity of a woman
    - A `InfoDetailActivity` class
    Activity that gives the information of a woman
    - A `MainActivity` class
    Main activity

- A `ListCallBack` class
Callback management in fragments

- 2 adapter:
    - A `ViewMenuAdapter` class
    Manages the display of the menu bar at the bottom "détail - women - map"
    - A `WomanAdapter` class
    Manages the display of the list of women

- A `Woman` class
    - `name` String : Name of the woman
    - `category` String : Category of the woman
    - `place` String : Place of the woman
    - `desc1 desc2, desc3, desc4, desc` String : Short description of the woman
    - `lat long` Number: GPS coord of the woman
    - `thumb_url` String : Picture URL of the woman
    - `fav` Boolean : if the woman is favorite or no

- A `WomanCreator` interface
- A `WomanList` class
Management function for women in the database

- A `WomanService` class
Query management

- A `WomanViewHolder` class
    - `name`: TextView
    - `place` : TextView
    - `category`: TextView
    - `image`: ImageView
    - `favori`: ImageView
    - `more`: ImageView

##  Getting Started


```sh
Open Android Studio and launch via the green arrow
```

## Working

Automatically the application launches on the main page with the list of women. Press on the logo below the heart to get more information about a woman.
The heart allows you to bookmark a woman.

On the map part you will have the exact position on the map.

In detail you will have a little more detail about the application.




