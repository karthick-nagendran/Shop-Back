$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/Signin.feature");
formatter.feature({
  "line": 1,
  "name": "Login to the app",
  "description": "",
  "id": "login-to-the-app",
  "keyword": "Feature"
});
formatter.before({
  "duration": 20905520523,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "I want to logout from Application",
  "description": "",
  "id": "login-to-the-app;i-want-to-logout-from-application",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 9,
      "name": "@2"
    },
    {
      "line": 9,
      "name": "@reset"
    }
  ]
});
formatter.step({
  "line": 11,
  "name": "I am on App launch screen",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "I login to the app",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I logout from app",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "I should see the text Sign up with email",
  "keyword": "Then "
});
formatter.match({
  "location": "SignInSteps.iAmOnAppLaunchScreen()"
});
formatter.result({
  "duration": 5293613332,
  "status": "passed"
});
formatter.match({
  "location": "SignInSteps.iLogignToTheApp()"
});
formatter.result({
  "duration": 9087134991,
  "status": "passed"
});
formatter.match({
  "location": "SignInSteps.iLogoutFromApp()"
});
formatter.result({
  "duration": 3550953616,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sign up with email",
      "offset": 22
    }
  ],
  "location": "SignInSteps.iShouldSeeTheTextSignUpWithEmail(String)"
});
formatter.result({
  "duration": 1981386665,
  "status": "passed"
});
formatter.after({
  "duration": 1525391739,
  "status": "passed"
});
});