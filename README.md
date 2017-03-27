# Marvel API Anypoint Connector

Mule Anypoint Connector for the Marvel API - https://developer.marvel.com/

## Mule supported versions
Mule 3.8.x

## Service or application supported modules
Marvel API (https://developer.marvel.com/)

## Installation
For beta connectors you can download the source code and build it with devkit to find it available on your local repository. Then you can add it to Studio

For released connectors you can download them from the update site in Anypoint Studio.
Open Anypoint Studio, go to Help → Install New Software and select Anypoint Connectors Update Site where you’ll find all avaliable connectors.

## Usage
Required system properties are your public and private keys from Marvel:
MARVEL_KEY
MARVEL_SECRET

`mvn test -DMARVEL_KEY=publickey -DMARVEL_SECRET=secretkey`

For more information about usage our documentation at https://github.com/eebbesen/marvel-api-connector.

## Reporting Issues
https://github.com/eebbesen/marvel-api-connector/issues
