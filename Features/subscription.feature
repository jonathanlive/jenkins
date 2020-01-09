@Cadastro @Navegar_Pagina_Inicial @AcessoCadastro @Preencher_Formulário @Validar_Mensagem
Feature: Nubank account subscription
	In order to save money 
	As a new client 
	I want to subscribe for a new bank account	
	
	Scenario Outline: Subscribe as a new client
	
	Given I have navigated to nubank site
	When I click on subscribe button 
	And Fill the form with my name<name> and identification<identification> and my email<email> 
	Then The subscription will be sent sucessful
	
	Examples:
	|name|identification|email|
	|Jonathan Silva|10721505490|nubanktest@gmail.com|
	
	
	

