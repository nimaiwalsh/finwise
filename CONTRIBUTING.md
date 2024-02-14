# Welcome

Welcome to this project! Thank you for wanting to contribute.

## How to get started

Start by reading the [README.md](README.md).

## How to submit changes

This project uses [github flow](https://guides.github.com/introduction/flow/) style [trunk based development](https://trunkbaseddevelopment.com). For authorised project contributors it is not necessary to fork the repository before pushing a branch and creating a [pull request](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/about-pull-requests) (PR).

Before merging, the PR branch must be up-to-date with `main` (rebased), all checks must pass, and all other branch protection rules complied with.

### Clone the repository

    git clone git@github.com:ittybittyapps/android-app-template.git

### Create a branch

    git checkout -b feature/short-feature-description

Branch names should include a prefix such as `tech`, `feature`, `doc`, or `fix` for technical tasks, feature development, documentation, or bugfixes respectively!

### Ensure your Git client is correctly configured

Please ensure you have set your email address and name correctly for the cloned repo. You can do this like so:

    cd android-app-template
    git config --local user.name "Joe Contributor"
    git config --local user.email "joe.contributor@me.com"

### Commit code, Unit Tests, and UI Tests

    git add com/ittybittyapps/android-app-template/MainActivity.kt
    git commit

* Do your work in the branch you created.
* Rebase your branch on `main` on a regular basis while you are working on your branch to keep it up to date with `main`.
* Commit regularly. Commit small chunks of work.
* Try and ensure each commit compiles without uncommitted work.
* Provide commit messages that describe **why** you're changing files not **what** you changed.
* Tag your commits with GitHub issue or PR numbers when relevant. Use [supported keywords](https://docs.github.com/en/issues/tracking-your-work-with-issues/linking-a-pull-request-to-an-issue#linking-a-pull-request-to-an-issue-using-a-keyword) so tagged issues automatically close when merging the commit to `main`.
* Keep your total changes as small as you can. Don't do too much work in a single branch is it makes it harder to code review.
* Write unit and UI automation tests for your feature or bugfix.

#### Commit messages

First read Chris Beams' post on [How to Write a Git Commit Message](https://chris.beams.io/posts/git-commit/).

##### The seven rules of a great Git commit message

Keep in mind: [This](https://tbaggery.com/2008/04/19/a-note-about-git-commit-messages.html) [has](https://www.git-scm.com/book/en/v2/Distributed-Git-Contributing-to-a-Project#_commit_guidelines) [all](https://github.com/torvalds/subsurface-for-dirk/blob/master/README#L92-L120) [been](http://who-t.blogspot.com/2009/12/on-commit-messages.html) [said](https://github.com/erlang/otp/wiki/writing-good-commit-messages) [before](https://github.com/spring-projects/spring-framework/blob/30bce7/CONTRIBUTING.md#format-commit-messages).

1. Separate subject from body with a blank line
2. Limit the subject line to 50 characters
3. Capitalize the subject line
4. Do not end the subject line with a period
5. Use the imperative mood in the subject line
6. Wrap the body at 72 characters
7. Use the body to explain what and why vs. how

Use a [git commit message template](https://gist.github.com/lisawolderiksen/a7b99d94c92c6671181611be1641c733) to guide you.

### Test your contribution

Run the project unit tests before pushing your branch.

    ./gradlew test
    ./gradlew connectedAndroidTest

#### Push your branch and create a Pull Request

Push your branch and open a Pull Request - following the [Pull Request Template](.github/PULL_REQUEST_TEMPLATE.md).

    git push origin feature/short-feature-description

Like commit messages, PR's can tag GitHub issues. Try placing a [keyword](https://docs.github.com/en/issues/tracking-your-work-with-issues/linking-a-pull-request-to-an-issue#linking-a-pull-request-to-an-issue-using-a-keyword) before the issue number. GitHub will close that issue automatically when someone merges this PR.
Here's what you might add to your PR's description: "Resolves #2, fixed #3, plus we can close #1 as it's no longer a problem".

**Note**: Pushing changes directly to the `main` branch of this repository is not allowed. All changes must be integrated via an approved pull-request. All pull request branches are also built but a continuous integration build agent and must pass all checks before they can be merged.

## How to report a bug

Use GitHub issues to track bugs - following the [Bug Report Issue Template](.github/ISSUE_TEMPLATE/bug_report.md).