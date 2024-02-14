# ADR-0007: Adoption of CI/CD and Github Actions

## Context

With Continuous Integration (CI), we aim to integrate small chunks of code into the repository.
Continuous Delivery (CD) is the deployment of the code to production.

By integrating and delivering code in small chunks, it will be easier to identify the cause of any
bugs. We can also automate the CI/CD process and include testing. This will help save time from
manually running our tests and it also gives us greater confidence in our code. Automating other tools
such as linters in the process can also help to keep code more consistent and at a higher quality.

Fast delivery and frequent deployment are factors to efficient software delivery. A good CI/CD pipeline
helps to achieve this.

## Decision

There are various other CI/CD platforms such as Jenkins and CircleCI. However, Github Actions was chosen
due to its seamless integration with Github, reliability and ease of use.

Currently there are several workflows implemented.

`continuous-integration.yml` runs when a pull request has been opened/reopened or when it is updated.
It runs unit tests and instrumented tests to ensure new commits can pass our tests.

`continuous-deployment.yml` runs when a new commit has been pushed to main.
It runs unit tests and instrumented tests to ensure new commits can pass our tests.
Then it builds, signs the app bundle and deploys it to the internal track of the Google Play.
This automation of deployment saves time in creating new releases and provides testers with frequent
builds.

`shell-check.yml` runs when a pull request has been opened/reopened or when it is updated.
This analyzes shell scripts in `support/scripts` for syntax and provides warnings to help avoid bugs.

`yaml-lint.yml` runs when a pull request targeting main has been opened/reopened or when it is updated.
This analyzes all `.yml` files for code syntax and consistency.
It uses [reviewdog](https://github.com/reviewdog/reviewdog) to help annotate issues in the PR.

## Status

Accepted

## Consequences

- CI/CD platforms cost money. However it can be argued it saves you more time and money by helping
to prevent bugs and automating process.
- Automated checks can be flaky. Whether it's due to the platform, or the tests themselves. It can 
waste time and money trying to fix or restart these workflows.
- Linters can also give too many warnings if they have restrictive rules which can reduce productivity.