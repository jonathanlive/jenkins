$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/subscription.feature");
formatter.feature({
  "name": "Nubank account subscription",
  "description": "\tIn order to save money \n\tAs a new client \n\tI want to subscribe for a new bank account\t",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Cadastro"
    },
    {
      "name": "@Navegar_Pagina_Inicial"
    },
    {
      "name": "@AcessoCadastro"
    },
    {
      "name": "@Preencher_Formulário"
    },
    {
      "name": "@Validar_Mensagem"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Subscribe as a new client",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I have navigated to nubank site",
  "keyword": "Given "
});
formatter.step({
  "name": "I click on subscribe button",
  "keyword": "When "
});
formatter.step({
  "name": "Fill the form with my name\u003cname\u003e and identification\u003cidentification\u003e and my email\u003cemail\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "The subscription will be sent sucessful",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "name",
        "identification",
        "email"
      ]
    },
    {
      "cells": [
        "Jonathan Silva",
        "10721505490",
        "nubanktest@gmail.com"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Subscribe as a new client",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Cadastro"
    },
    {
      "name": "@Navegar_Pagina_Inicial"
    },
    {
      "name": "@AcessoCadastro"
    },
    {
      "name": "@Preencher_Formulário"
    },
    {
      "name": "@Validar_Mensagem"
    }
  ]
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I have navigated to nubank site",
  "keyword": "Given "
});
formatter.match({
  "location": "SubscriptionSteps.i_have_navigated_to_nubank_site()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I click on subscribe button",
  "keyword": "When "
});
formatter.match({
  "location": "SubscriptionSteps.i_click_on_subscribe_button()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "Fill the form with my nameJonathan Silva and identification10721505490 and my emailnubanktest@gmail.com",
  "keyword": "And "
});
formatter.match({
  "location": "SubscriptionSteps.fill_the_form_with_my_name_and_identification_and_my_email(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "The subscription will be sent sucessful",
  "keyword": "Then "
});
formatter.match({
  "location": "SubscriptionSteps.the_subscription_will_be_sent_sucessful()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
});