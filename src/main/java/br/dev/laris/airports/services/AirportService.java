
package br.dev.laris.airports.services;

import br.dev.laris.airports.entities.Airport;
import br.dev.laris.airports.repositories.AirportRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sesidevb
 *
 */
@Service 
public class AirportService {
    @Autowired 
    private AirportRepository airportRepository;
    
    public List<Airport> findAll() {
        List<Airport> result = airportRepository.findAll();
        return result;
    }
    
}
