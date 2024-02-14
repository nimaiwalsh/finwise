# ADR-0002: Dependency Version Management

## Context

Managing versions for dependencies is important as it helps to keep dependency versions consistent,
especially in multi-module projects.

There are currently 2 main methods:
1. BuildSrc with Kotlin DSL
2. Version Catalogs

### BuildSrc with Kotlin DSL
Versions and dependencies are defined in a Kotlin file using static strings. The strings can then be
accessed in build.gradle files.
- It has the added advantage of autocomplete.
- It is written in a familiar language (Kotlin).

### Version Catalogs
Versions and dependencies are defined in a `libs.version.toml` file. It contains separate sections for
versions, libraries (dependencies) and plugins.
- It does not support autocomplete yet.
- It is the official way of versioning by [Gradle.](https://docs.gradle.org/current/userguide/platforms.html)

## Decision

We have decided upon using Version Catalogs to manage our dependency versions due to being the
official method provided by Gradle.

Although it currently lacks support for autocomplete and warnings on outdated dependencies, 
it seems [future Android Studio versions will support this.](https://issuetracker.google.com/issues/228233333#comment11)

## Status

Accepted

## Consequences

Developers will need to learn a new way of managing versions which isn't too common at the moment.

The lack of autocomplete can give less confidence and direction on how to declare a dependency.