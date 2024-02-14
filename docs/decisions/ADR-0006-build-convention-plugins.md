# ADR-0006: Gradle Build Convention Plugins

## Context

As a multi-module project grows in complexity so does the associated Gradle build script
complexity. [Convention Plugins](https://docs.gradle.org/current/samples/sample_convention_plugins.html)
are Gradle’s way of sharing build logic between modules and addressing this issue. These plugins
provide a standard structure and behavior for projects. Using these plugins can simplify and
standardize a build process reducing duplication and boilerplate in`build.gradle[.kts]` scripts, and
make it easier to manage and maintain a project over time.

## Decision

We will use Gradle 'convention plugins' to simplify and standardize our build process.

## Status

Accepted

## Consequences

Convention Plugins are not commonly used in simpler application projects so less experienced Android
developers may not be familiar with them. This places an additional knowledge and experience
requirement on engineers who join the team.
