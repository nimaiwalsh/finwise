# ADR-0007: Dependency Injection

## Context

[Dependency Injection](https://en.wikipedia.org/wiki/Dependency_injection) (DI) is a design pattern in which an object or function receives other objects or functions that it depends on. Dependency
injection aims to separate the concerns of constructing objects and using them, leading to loosely coupled programs.

Implementing dependency injection provides the following advantages:

- Reusability of code
- Ease of refactoring
- Ease of testing
- Separation of concerns

For further details and some examples of DI, see:
[Google's Guide to Android DI](https://developer.android.com/training/dependency-injection#what-is-di)

There are multiple approaches and alternatives to DI on Android:

[**Manual DI**](https://developer.android.com/training/dependency-injection/manual)  
Implementing DI manually is great for learning and understanding the technique. However, it requires a lot of boilerplate. The complexity of the DI system increases with project size, and it can
be hard to coordinate across multiple modules (see [ADR-0005](ADR-0005-build-modularization.md)). As such, manual DI is not very scalable.

[**Service Locator**](https://developer.android.com/training/dependency-injection#di-alternatives)  
A service locator is a registry of dependencies, which allows classes to request a particular dependency without having to construct the dependency itself. This helps solve some of the same problems
as dependency injection.

There are a few downsides of the service locator pattern:

The service locator is typically a global or static object. This makes it difficult to scope dependencies to a specific lifecycle, e.g. a View Model. This can be wasteful in terms of memory
management.

Testing is also more difficult with a service locator. Isolated tests are dependent on the global service locator. It can be difficult to control and isolate the specific dependencies required for the
test.

Dependencies are pulled into the class in the class implementation itself, rather than the API surface (the class constructor). This makes classes more tightly coupled to the implementation of the
service locator.

**Using a framework**

There are many different DI frameworks and service locator libraries available for Android.

[Koin](https://insert-koin.io/), [Kodein](https://github.com/kosi-libs/Kodein), [k2](https://github.com/Wokdsem/kInject2), [kotlin-inject](https://github.com/evant/kotlin-inject)
and [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)

_Most_ of these libraries do not offer compile-time validation, which means it's possible to cause runtime errors with misconfiguration.

However, those that are compile-time validated use annotation processing, which has a detrimental impact on build performance.

## Decision

We will use [Hilt Android](https://developer.android.com/training/dependency-injection/hilt-android) for Dependency Injection in the IBA App Template

Hilt-Android is the recommended & official DI framework for Android, maintained by Google. As such it is well used, documented & maintained. Hilt Android also works well with mutli-module projects,
Jetpack Compose, AndroidX ViewModels and the official Fragment & Compose navigation libraries.

As Hilt is the conventional approach to DI in modern Android Applications, alternative frameworks were not given much consideration for this Android App Template. A more in-depth comparison is encouraged before
choosing to adopt Hilt in a real-world application.

## Status

Accepted

## Consequences

- Improved separation of concerns
- Easier to employ project modularisation
- Easier to swap out dependencies in Unit & UI tests
- Support for Jetpack Compose, AndroidX ViewModels and Fragment & Compose navigation
- Recommended & supported approach to DI by Google
- Steep learning curve
- Degraded build performance (though this is mitigated by our approach to modularisation [ADR-0005](ADR-0005-build-modularization.md))
