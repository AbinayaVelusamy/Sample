package com.restassuredlearning;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class WeatherRequestREST {
	public Response getResponse()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest=RestAssured.given();
		Response httpResponse=httpRequest.get("/hyderabad");
		return httpResponse;
	}
	
    @Test
	public void getWeatherDetails()
	{
    	Response response=getResponse();
		ResponseBody responseBody=response.getBody();
		System.out.println("The Response is"+response.asString());
		System.out.println(response.header("Content-Type"));
	    Headers allHeaders=response.headers();
	    for(Header header: allHeaders)
	    {
	    	System.out.println("Key is:"+header.getName()+"Value is:"+header.getValue());
	    }
	}
		
    @Test
    public void getWeatherDetailsByJsonPath()
    {
    	Response response=getResponse();
		JsonPath jsonPathEvaluator=response.jsonPath();
		String city=jsonPathEvaluator.get("City");
		String windSpeed=response.jsonPath().get("WindSpeed");
		System.out.println(windSpeed);
		System.out.println(city);
	}
    @Test
    //To use JSONObject download theSImple Json Library  from Maven Repository
    public  void postRequestByJSONObject()
    {
    	RestAssured.baseURI="http://restapi.demoqa.com/customer";
    	RequestSpecification httpRequest=RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "Ai"); // Cast
        requestParams.put("LastName", "Velu");
        requestParams.put("UserName", "AbiyaVe");
        requestParams.put("Password", "Lohithashwin@8");
        requestParams.put("Email",  "vabiya@gmail.com");
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());
        Response httpResponse=httpRequest.post("/register");
        String successCode=(httpResponse.jsonPath().get("SuccessCode"));
        System.out.println(successCode);
        Assert.assertEquals(httpResponse.jsonPath().get("SuccessCode"), "OPERATION_SUCCESS");
        System.out.println(httpResponse.getBody().asString());
    	
    }
    
  
}

