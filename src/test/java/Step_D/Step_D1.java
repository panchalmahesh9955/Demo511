package Step_D;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Step_D1 {
	RequestSpecification a;
	Response b;

	
//Get
	
	
	@Given("Load URL")
	public void load_url() {
	   RestAssured.baseURI="https://reqres.in/";
	   this.a=RestAssured.given().log().all().queryParam("page", "2");
	}

	@When("Hit the request")
	public void hit_the_request() {
	  this.b=a.when().get("/api/users");
	}

	@Then("Verify the response")
	public void verify_the_response() {
	    b.then().log().all().statusCode(200);
	    
	}
	
// Post 
	
	
	@Given("Load URL and Body")
	public void load_url_and_body() {
	    RestAssured.baseURI="https://reqres.in/";
	    this.a=RestAssured.given().body("{\r\n"
	    		+ "    \"name\": \"morpheus\",\r\n"
	    		+ "    \"job\": \"leader\"\r\n"
	    		+ "}").header("Content-Type","application/json").log().all();
	}

	@When("Hit the post request")
	public void hit_the_post_request() {
	   this.b=a.when().post("/api/users");
	}

	@Then("Verify the response of post request")
	public void verify_the_response_of_post_request() {
		b.then().log().all().statusCode(201);
	    
	}

	
	
//Put
	
	
	@Given("Load URL and Body fot put")
	public void load_url_and_body_fot_put() {
		
		RestAssured.baseURI="https://reqres.in/";
		this.a=RestAssured.given().body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}").header("Content-Type","application/json").log().all().pathParam("id", "2");
	
	}

	@When("Hit the put request")
	public void hit_the_put_request() {
	    this.b=a.when().put("/api/users/{id}");
	}

	@Then("Verify the response of put request")
	public void verify_the_response_of_put_request() {
		b.then().log().all().statusCode(200);
	}
	
	
//Delete
	

	@Given("Load URL and Body for delete")
	public void load_url_and_body_for_delete() {
	  RestAssured.baseURI="https://reqres.in/";
	 this.a=RestAssured.given().log().all().pathParam("id","2");
	  
	}

	@When("Hit the delete request")
	public void hit_the_delete_request() {
	  this.b=a.when().delete("/api/users/{id}");
	}

	@Then("Verify the response of delete request")
	public void verify_the_response_of_delete_request() {
		b.then().log().all().statusCode(204);
	}
	
}
