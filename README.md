# FlowaPowa

This is an exercise to practice branching by abstraction and  feature flags.

## The problem

FlowaPowa is an application to create flower bouquets. It depends on a library to get the latest prices for flowers and other elements. This library is marked as deprecated, and it will be end of life soon.

So, we will need to migrate to a new library that will give access to the same prices, but with a new interface.

The problem is that we need to execute the migration during the most important season of the year. We need zero downtime to avoid loosing sales.

The architecture of the application is pretty good, but it has some flaws. The deprecated library was used with little care and code is tightly coupled to it. You could find other code smells as well.

## The challenge

We need to achieve zero downtime, so we should migrate the application to use the new library without breaking the app. Fortunately we have a comprehensive test suite, and any change that could break it should be noticed.

## Some caveats and design decisions

* We don't use currency for the sake of simplicity
* Interface of FlowaPowa::main accepts recipe strings like "rose:12;daisy:15;foliage:1;"
* Flower names in singular are used as id of the products
* Sort of Hexagonal Architecture, ports are named from the kind of conversation they establish with the outer world
