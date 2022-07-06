# playwright-java

- [Playwright](https://playwright.dev/docs/intro)
- [TestNg](https://testng.org/doc/)
- [Gradle](https://docs.gradle.org/current/userguide/userguide.html)

### Steps to Set up Playwright

```
- Ensure you have NodeJS installed.
- Install a code editor. We will be using Visual Studio Code.
- $npm init playwright@latest <project-name> 
Note: We can install Playwright from VS Code marketplace as well. 

Example: Enter ‘Install playwright’ on the marketplace search bar.
```

### Steps to run tests
```
Basic Run: $npx playwright test
```
Using Gradle:
```
 ./gradlew test -Dheadless=<true|false> -Dbrowser=<chrome|firefox|webkit>
 ```
