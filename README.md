# FlowaPowa

This is an exercise to practice branching by abstraction and  feature flags.

## The problem

FlowaPowa is an application to create flower bouquets. It depends on a library to get the latest prices for flowers and other elements. This library is marked as deprecated, and it will be end of life soon.

So, we will need to migrate to a new library that will give access to the same prices, but with a new interface.

The problem is that we need to execute the migration during the most important season of the year. We need zero downtime to avoid loosing sales.

The architecture of the application is pretty good, but it has some flaws. The deprecated library was used with little care and  code is coupled to it.

## The challenge

We need to achieve zero downtime, so we should migrate the application to use the new library without breaking the app. Fortunately we have a comprehensive test suite, and any change that could break it should be noticed.
