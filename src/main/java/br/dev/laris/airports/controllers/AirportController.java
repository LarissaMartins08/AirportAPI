
package br.dev.laris.airports.controllers;

import br.dev.laris.airports.entities.Airport;
import br.dev.laris.airports.services.AirportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
