Magic: The Gathering Java SDK - Extended
===========
[![license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/MagicTheGathering/mtg-sdk-java/blob/master/LICENSE)
[![mtg-developers on discord](https://img.shields.io/badge/discord-mtg%20developers-738bd7.svg)](https://discord.gg/qwGJNnP)


Introduction
-------------------------
Java SDK for using the [magicthegathering.io](http://magicthegathering.io) APIs.

I forked the original project from [magicthegathering.io](https://github.com/MagicTheGathering/mtg-sdk-java)
because I was missing some features. The original project was published under MIT Licence, so I refer to the
[licence](https://github.com/MagicTheGathering/mtg-sdk-java/blob/master/LICENSE) published by the developers of
[mtg-sdk-java](https://github.com/MagicTheGathering/mtg-sdk-java).

Note that API use is free and does not require authentication or registration, but some rate limits apply.
Read the official API website for more information.

### Additional Features ###

Following table shows the features which are supported, or planning to be supported soon, by this fork.

Development State   | Feature Name          | Description
--------------------|-----------------------|---------------------------------------------------------------
implemented         | Rulings               | Extracts the rulings array of the cards from JSON response.
implemented         | Fluent Querying       | Developers should be able to use filters in a fluent and readable way.
not implemented     | Fitler Integration    | The Filter mechanism must be integrated to the existing API.
implemented         | NameFilter            | Adds support for filtering by a cards name.
implemented         | LayoutFilter          | Adds support for filtering by a cards layout.

Prerequisites
-------
- Java JDK 7 or higher

Usage examples
-------

#### Get a Card
```java
int multiverseId = 1;
Card card = CardAPI.getCard(multiverseId);
```

#### Get all Cards
```java
List<Card> cards = CardAPI.getAllCards();
```

#### Get a Set
```java
String setCode = "KLD";
MtgSet set = SetAPI.getSet(setCode);
```

#### Get all Sets
```java
List<MtgSet> sets = SetAPI.getAllSets();
```

#### Generate a Booster
```java
String setCode = "KLD";
List<Card> booster = SetAPI.getBooster(setCode);
```

#### Create a Path with Filter API
```java
String path = new Filter().withName("Nissa").or("Jace").end().compile();
```
License
-------
This project is licensed under [MIT license](http://opensource.org/licenses/MIT).
