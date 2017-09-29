package org.aitesting.microservices.passengermanagement.controllers;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.maps.DirectionsApi;
import com.google.maps.GaeRequestHandler;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;

@Controller
@RequestMapping("api")
public class GoogleApiController {

	@GetMapping("geocoding")
	public @ResponseBody GeocodingApiRequest getGeocoding(@RequestBody String address) {

		GeoApiContext context = new GeoApiContext.Builder(new GaeRequestHandler.Builder())
				.apiKey("AIzaSyB4uaoaPtxAHijM9oFBKrgxAcQBeqXSlKE").build();
		
		GeocodingApiRequest result = GeocodingApi.geocode(context, address);
		
		return result;
	}

	@GetMapping("directions")
	public @ResponseBody DirectionsResult getDirections(@RequestBody String origin, @RequestBody String destination) {

		GeoApiContext context = new GeoApiContext.Builder(new GaeRequestHandler.Builder())
				.apiKey("AIzaSyB4uaoaPtxAHijM9oFBKrgxAcQBeqXSlKE").build();

		DirectionsResult result = null;
		try {
			result = DirectionsApi.getDirections(context, origin, destination).await();
		} catch (ApiException | InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
}
