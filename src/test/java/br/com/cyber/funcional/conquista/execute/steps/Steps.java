package br.com.cyber.funcional.conquista.execute.steps;

import static br.com.cyber.funcional.conquista.core.DriverFactory.getDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	
	@Given("I want to write a step with precondition")
	public void iWantToWriteAStepWithPrecondition() {
	    getDriver().get("https://www.youtube.com");
	}
	@Given("some other precondition")
	public void someOtherPrecondition() {
		getDriver().get("https://www.youtube.com");
	}
	@When("I complete action")
	public void iCompleteAction() {
		getDriver().get("https://www.google.com");
	}
	@When("some other action")
	public void someOtherAction() {
		getDriver().get("https://www.youtube.com");
	}
	@When("yet another action")
	public void yetAnotherAction() {
		getDriver().get("https://www.youtube.com");
	}
	@Then("I validate the outcomes")
	public void iValidateTheOutcomes() {
		getDriver().get("https://www.google.com");
	}
	@Then("check more outcomes")
	public void checkMoreOutcomes() {
		getDriver().get("https://www.youtube.com");
	}
	
	@Given("I want to write a step with name1")
	public void iWantToWriteAStepWithName1() {
		getDriver().get("https://www.youtube.com");
	}
	
	@Given("I want to write a step with name2")
	public void iWantToWriteAStepWithName2() {
		getDriver().get("https://www.youtube.com");
	}
	@When("I check for the {int} in step")
	public void iCheckForTheInStep(Integer int1) {
		getDriver().get("https://www.google.com");
	}
	@Then("I verify the Fail in step")
	public void iVerifyTheFailInStep() {
		getDriver().get("https://www.google.com");
	}
	@Then("I verify the success in step")
	public void iVerifyTheSuccessInStep() {
		getDriver().get("https://www.youtube.com");
	}

}
