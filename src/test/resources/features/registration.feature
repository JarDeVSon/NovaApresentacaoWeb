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

  @signinOutlin
  Esquema do Cenario: Registration with <identificacao>
    Quando Click on My Account Menu
    E Enter invalid Email Address in <Email-Address> textbox
      | Email Address | <Email Address> |
    E  Enter your own password in <password> textbox
      | password | <password> |
    E Click on Register button
    Entao Registration must fail with a warning message:
      | Message | <message> |
    Exemplos:
      | identificacao             | Email Address          | password  | message                                 |
      | invalid Email-id          | email@ehahsbe          | 3Hpo31as$ | ie You must enter a valid email address |
      | empty Email-id            |                        | 3Hpo31as$ | ie please provide valid email address   |
      | empty password            | email.teste5@email.com |           | ie please enter an account password     |
      | empty Email-id & password |                        |           | ie please provide valid email address   |

