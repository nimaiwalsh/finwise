# ADR-0004: Linting + Code analysis

## Context

A linter is a static analysis tool that can be used to evaluate code and enforce code standards throughout the project. Maintaining a consistent code style makes it easier for everyone to reason about the project and reduces noise when comparing code diffs.

You have multiple options when linting Kotlin Android app code, including [Detekt](https://github.com/detekt/detekt), [Android Lint](https://developer.android.com/studio/write/lint), [KTLint](https://github.com/pinterest/ktlint), [Spotless](https://github.com/diffplug/spotless), and more.

- Android Lint is the default lint tool provided by Android Studio. It checks for a wide range of issues, including performance, security, usability, and code style issues.
- Detekt offers a comprehensive set of built-in rules for checking coding conventions, performance, and security. It also provides a plugin mechanism for adding custom rules, and an annotation-based rule suppression system, making it a good choice for those who need more control over their linting process.
- KTLint focuses on enforcing code style, providing an easy-to-configure set of rules with a strong focus on simplicity and clarity.
- Spotless allows you to maintain a consistent code style by defining and automatically applying formatting rules using Gradle or Maven plugins.

The choice between these tools would depend on your specific needs and preferences.

Our preference is to employ Detekt as:
- It has a more comprehensive set of built-in rules and provides a wrapper over KTLint as the formatting rule set, which facilitates formatting checks and auto-correction.
- It allows for the suppression of findings via the `@Suppress` annotation.
- It has good HTML & XML-based reporting options.
- It can report on code complexity, in addition to various other code smells.
- There is a Detekt plugin for [Android Studio](https://github.com/detekt/detekt-intellij-plugin) and support for [SonarQube](https://www.sonarqube.org/) integration.

## Decision

- We will use [Detekt](https://github.com/detekt/detekt) as our static code analysis and linting tool for Kotlin code.
- Pull requests will not be accepted if the code does not pass Detekt's configured checks.

## Status

Accepted

## Consequences

- This decision will help in enforcing code standards across the project, resulting in less noise during code review and a greater emphasis on the actual solution
- Initially, configuration changes related to compose will be required; however, this is easy to accomplish by following the detekt's [guidelines for compose configuration](https://detekt.dev/docs/introduction/compose).
- We’ll have to spend some time configuring the general rules, so that we’re not overwhelmed with lint warnings/errors for rules we don’t want to enforce.
- While having variety of configuration options is beneficial, devs would also need to take the possibility of over-engineering configurations into consideration, which can lead to the point where team ends up creating their own code standards, deviating from the recommended official code/language standards.
