#language:pt
#Encoding: UTF-8
@regressivo
Funcionalidade:  My Account - Registration

  Contexto: Automationtesting HomePage
    Dado Open the browser and Enter the URL "http://practice.automationtesting.in/"

  @signin
  Cenario: Registration-Sign-in
    Quando Click on My Account Menu
    E Enter registered Email Address in Email-Address textbox
    E Enter your own password in password textbox
    E Click on Register button
    Entao User will be registered successfully
    E Will be navigated to the Home page
