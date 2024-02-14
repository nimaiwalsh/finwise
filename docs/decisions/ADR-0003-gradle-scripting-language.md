# ADR-0003: Gradle Scripting Language

## Context

Our Android project uses the Gradle build system. There are two choices of language for this build system; Groovy and Kotlin Script (KTS).

KTS is the [recommended](https://developer.android.com/studio/build/migrate-to-kts) language for writing Gradle scripts on Android.

According to the Android developer docs, KTS:

- Is more readable
- Offers better compile-time checking
- Offers better IDE support

Advantages of using KTS:
- Android developers are already familiar with Kotlin (and not generally familiar with Groovy)
- KTS claims to be more performant than Groovy (faster build times)

Disadvantages of using KTS:
- KTS is not the default language for Gradle scripts. Examples and documentation may be written in Groovy, and need to be translated.

## Decision

We will use KTS as the language for our Gradle scripts

## Status

Accepted

## Consequences

- Developers will need to familiarise themselves with KTS