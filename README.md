# android-app-template
A template Android Application Project.

# After cloning the template

### Altering the project name and namespace

Several project files refer to the "Android App Template", and each Kotlin file declares itself part
of the `com.ittybittyapps.apptemplate.android` package. Update these files to suit the client's new
application.

- In `app/build.gradle`, modify `android.namespace` and `android.defaultConfig.applicationId`.
- Change the `rootProject.name` variable in `settings.gradle`.
- Rename the app's themes in `Theme.kt` and `themes.xml`.
- In `strings.xml`, set the `app_name` string resource.
- Update the package declarations in all Kotlin files by performing a project-wide find and
  replace of `com.ittybittyapps.apptemplate.android`.
- Update the package name `com.ittybittyapps.apptemplate` in `continuous-deployment.yml`.

### Generate Keystore
- See [Generate keystore](https://developer.android.com/studio/publish/app-signing) for instructions
- Make a note of the alias and password being used as this is required for github secrets 

### Github Actions
- Configure Github secrets for `IBA_GOOGLEPLAY_KEYSTORE`, `IBA_GOOGLEPLAY_KEYSTORE_PASSWORD`,
`IBA_GOOGLEPLAY_KEYSTORE_KEY_ALIAS`, `IBA_GOOGLEPLAY_KEYSTORE_KEY_PASSWORD` and 
`GOOGLEPLAY_SERVICE_ACCOUNT`.
- This is done via your github repo -> settings -> security -> secrets & variables -> actions
- For `IBA_GOOGLEPLAY_KEYSTORE`, you need to convert your keystore file to base64 encoding, use a tool like [this](https://8gwifi.org/Base64Functions.jsp) the output is your secret for `IBA_GOOGLEPLAY_KEYSTORE`

### Deploy -> Automate creating a release and deploying it to Google Play
- You can configure the deploy section of the .yml section to automatically create a new test track on google play
- In order for CI/CD environment to be able to upload .apk or .aab via API, you need to generate Service Account JSON (`GOOGLEPLAY_SERVICE_ACCOUNT` private key) and add it to Github Secrets. 
  - Create or get access to the [Google Cloud Project](console.cloud.google.com)
  - Enable the Google Play Developer API for this project
  - Create a service account for the project
  - Copy the email that was generated for the service account, it will look something like this: project-name@project-name.iam.gserviceaccount.com, save this in github secrets as `GOOGLEPLAY_SERVICE_ACCOUNT`


### See `continuous-deployment.yml` for more information.

If the deployment workflow is not yet required, you can disable the action manually in Github.

# Building and testing
Build and run
```shell
./gradlew assembleDebug
./gradlew installDebug
```

Unit test 
```shell
./gradlew testDebugUnitTest
```

Instrumentation test
```shell
./gradlew connectedandroidtest
```


