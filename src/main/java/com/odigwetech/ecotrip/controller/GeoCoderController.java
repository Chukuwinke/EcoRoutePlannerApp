package com.odigwetech.ecotrip.controller;
import com.odigwetech.ecotrip.model.GeocoderResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GeoCoderController {

    @Value("${bingmaps.api.key}")
    private String bingMapsApiKey;

    // ROUTE FOR FETCHING AND RETURNING THE LAT AND LONG COORDINATES
    @GetMapping("/geocode")
    public ResponseEntity<double[]> geoCodeAddress(@RequestParam String address) {
        String url = "http://dev.virtualearth.net/REST/v1/Locations?query=" + address + "&key=" + bingMapsApiKey;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<GeocoderResponse> responseEntity = restTemplate.getForEntity(url, GeocoderResponse.class);

        GeocoderResponse geocoderResponse = responseEntity.getBody();
        // CHECK IF RESPONSE IS IS NOT EMPTY BEFORE GETTING LAT AND LONG
        if (geocoderResponse != null && geocoderResponse.getResourceSets().length > 0) {
            GeocoderResponse.ResourceSet.Resource.Point point = geocoderResponse.getResourceSets()[0].getResources()[0].getPoint();
            if (point != null) {
                double[] coordinates = point.getCoordinates();
                return ResponseEntity.ok(coordinates);
            }
        }

        return ResponseEntity.badRequest().build();
    }
}
