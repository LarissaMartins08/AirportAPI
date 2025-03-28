package br.dev.laris.airports.controllers;

import br.dev.laris.airports.DTO.AirportMinDTO;
import br.dev.laris.airports.entities.Airport;
import br.dev.laris.airports.services.AirportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sesidevb
 */
@RestController
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping("/airport")
    public List<Airport> findAll() {
        List<Airport> result = airportService.findAll();
        return result;
    }

    @GetMapping("/city/{cityName}")
    public ResponseEntity<List<Airport>> findByCityIgnoreCase(@PathVariable String cityName) {
       
        List<Airport> result = airportService.findByCity(cityName);
        if (result.isEmpty()) {
            //Ops lista vazia 
            //notFound devolve 404
          return ResponseEntity.notFound().build();
            
        } else {
            //eba tem dados 
            //ok devolve 200
            return ResponseEntity.ok(result);
            
         }        
    }
    
    @GetMapping("/country/{countryName}")
    public ResponseEntity<List<AirportMinDTO>> findByCountryIgnoreCase(@PathVariable String countryName) {
       
        List<AirportMinDTO> result = airportService.findByCountry(countryName);
        if (result.isEmpty()) {
            //Ops lista vazia 
            //notFound devolve 404
          return ResponseEntity.notFound().build();
            
        } else {
            //eba tem dados 
            //ok devolve 200
            return ResponseEntity.ok(result);
            
         }        
    }
    
    @GetMapping("/iatacode/{iataCode}")
    public ResponseEntity<Airport> findByIataCode(@PathVariable String iataCode) {
        Airport result = airportService.findByIataCode(iataCode);
        
        if (result == null) {
            //Ops aeroporto vazio
            //notFound devolve 404
          return ResponseEntity.notFound().build();
            
        } else {
            //eba tem dados 
            //ok devolve 200
            return ResponseEntity.ok(result);
            
         }        
    }
    
}
