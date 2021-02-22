# Relationships

This repository contains a small spring boot application to demonstrate an introduction to using JPA relationships
within a spring boot application.

To keep things simple for demonstration:

- there is no nested package structure in the Java source code
- there is a single controller which also contains the application's `main` method
- No templated views, i.e. included navbars, footers, etc, and minimal CSS

This application consists of 3 key entities: phones, carriers, and companies.

- Each phone is manufactured by one company, each company can manufacture multiple phones
- Each carrier services multiple phones
- A phone can be offered by multiple carriers

[See also the roadmap here.](https://docs.google.com/presentation/d/e/2PACX-1vTZ6Ht7aGkSt_NNx9uTQUhk34wePFcpmRVX4qd3xUMDXPvkI2oOEvnWzOGl7GMcFsdtR5uBb0y6hyGA/pub?start=true&loop=true&delayms=60000)

