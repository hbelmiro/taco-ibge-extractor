# taco-ibge-extractor project

This project parses information from "Tabelas de Composição Nutricional dos Alimentos Consumidos no Brasil".

IBGE (Brazilian Institute of Geography and Statistics) presents in this publication the Tables of Nutritional 
Composition of Food Consumed in Brazil, which define the components for each 100 grams of edible parts of food and 
preparations - energy, macronutrients and fiber; fats and sugar; minerals; and vitamins – as well as the reference(s) 
adopted to obtain the respective composition. 

Tabelas de Composição Nutricional dos Alimentos Consumidos no Brasil is available at:
https://biblioteca.ibge.gov.br/visualizacao/livros/liv50002.pdf

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `taco-ibge-extractor-999-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/taco-ibge-extractor-999-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/taco-ibge-extractor-999-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.