# ADR-0005: Build Modularization

## Context

Managing maintenance and scalability is a difficult challenge in an Android application. It can be
difficult to figure out where to draw the boundaries between different parts of our codebase.

Traditionally, Android projects have been built within a single gradle module - the 'app' module.

Modularization is the practice of breaking down code into smaller pieces, rather than a single,
monolithic piece.

There are many benefits to the practice of modularization:

**Scalability** - In a tightly coupled codebase, a single change can trigger a cascade of
alterations. A properly modularized project will embrace
the [separation of concerns](https://en.wikipedia.org/wiki/Separation_of_concerns) principle. This
in turn empowers the contributors with more autonomy while also enforcing architectural patterns.

**Enabling work in parallel** - Modularization helps decrease version control conflicts and enables
more efficient work in parallel for developers in larger teams.

**Encapsulation** - Isolated code is easier to read, understand, test and maintain.

**Reduced build time** - Leveraging Gradle’s parallel and incremental build can reduce build times.

**Dynamic delivery** - Modularization is a requirement
for [Play Feature Delivery](https://developer.android.com/guide/playcore/feature-delivery) which
allows certain features of your app to be delivered conditionally or downloaded on demand.

**Reusability** - Proper modularization enables opportunities for code sharing and building multiple
apps, across different platforms, from the same foundation.

There are also some disadvantages of modularization:

**Too many modules** - each module has an overhead that comes in the form of increased complexity of
the build configuration. This can cause Gradle sync times to increase, and incurs an ongoing
maintenance cost. In addition, adding more modules increases the complexity of the project’s Gradle
setup, when compared to a single monolithic module. This can be mitigated by making use of
convention plugins, to extract reusable and composable build configuration into type-safe Kotlin
code. In the Now in Android app, these convention plugins can be found in
the [`build-logic` folder](https://github.com/android/nowinandroid/tree/main/build-logic).

**Not enough modules** - conversely if your modules are few, large and tightly coupled, you end up
with yet another monolith. This means you lose some benefits of modularization. If your module is
bloated and has no single, well defined purpose, you should consider splitting it.

**Too complex** - there is no silver bullet here. In fact it doesn’t always make sense to modularize
your project. A dominating factor is the size and relative complexity of the codebase. If your
project is not expected to grow beyond a certain threshold, the scalability and build time gains
won’t apply.

### Modularization strategy

It’s important to note that there is no single modularization strategy that fits all projects.
However, there are general guidelines that can be followed to ensure you maximize its benefits and
minimize its downsides.

A barebone module is simply a directory with a Gradle build script inside. Usually though, a module
will consist of one or more source sets and possibly a collection of resources or assets. Modules
can be built and tested independently. Due to Gradle's flexibility there are few constraints as to
how you can organize your project. In general, you should strive for low coupling and high cohesion.

* **Low coupling** - Modules should be as independent as possible from one another, so that changes
  to one module have zero or minimal impact on other modules. They should not possess knowledge of
  the inner workings of other modules.

* **High cohesion** - A module should comprise a collection of code that acts as a system. It should
  have clearly defined responsibilities and stay within boundaries of certain domain knowledge.

## Decision

We will embrace the concept of gradle modularization, and use modules to help encourage separation
of concerns.

We will use `core:` as a prefix for common library modules containing auxiliary code and specific
dependencies that
need to be shared between other modules in the app. These modules can depend on other core
modules, but they shouldn’t depend on feature nor app modules.

We will use `feature:` as a prefix for feature specific modules which are scoped to handle a single
responsibility in the app. These modules can be reused by any app, including test or other flavoured
apps, when needed, while still keeping it separated and isolated. If a class is needed only by
one `feature` module, it should remain within that module. If not, it should be extracted into an
appropriate `core` module. A `feature` module should have no dependencies on other feature modules.
They only depend on the `core` modules that they require.

The `app` module - contains app level and scaffolding classes that bind the rest of the codebase,
such as `MainActivity`.

Various other modules may be created as needed.

## Status

Accepted

## Consequences

Developers will need to understand the purpose of various different modules in the app, and take
care not to create circular dependencies between modules.

Care must also be taken not to proliferate modules to the point where they become unmanageable.

It may be more difficult to navigate the project hierarchy to find certain pieces of code.