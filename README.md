# FlowaPowa

This is an exercise to practice branching by abstraction and feature flags.

## The problem

FlowaPowa is an application to create flower bouquets. It depends on a library to get the latest prices for flowers and other elements, like Foliage and Ribbons, from the _Worldwide Flower Market_. Sadly, this library was deprecated, and it will be declared _end of life_ soon.

So, we will need to migrate to a new library that will give us access to the same prices, but with a new interface.

The problem is that we need to execute the migration during the most important season of the year. We want to achieve zero downtime to avoid loosing sales.

The architecture of the application is pretty decent, but it has some flaws. The deprecated library was used with little care and code is tightly coupled to it. You could find other code smells as well, because original programmer was not so proficient.

## The challenge

We want zero downtime, so we should migrate the application to use the new library without breaking the app. Fortunately we have a comprehensive test suite, and any change that could break it should be noticed by the tests.

Also, we want to use Trunk Based Development and small batches. We need to follow a strategy to isolate the changes needed and be able to make the transition without breaking the pipeline.

## Some caveats and design decisions

* We don't use currency for the sake of simplicity
* Interface of FlowaPowa::main() accepts recipe strings like "rose:12;daisy:15;foliage:1;"
* Flower names in singular are used as id of the products
* Sort of Hexagonal Architecture, ports are named from the kind of conversation they establish with the outer world
