
package br.dev.laris.airports.services;

import br.dev.laris.airports.DTO.AirportMinDTO;
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
    
    public List<Airport> findByCity(String city) {
        List<Airport> result = airportRepository.findByCityIgnoreCase(city);
        return result; 
    }
    
    
    public List<AirportMinDTO> findByCountry(String country) {
        List<Airport> resultAirport = airportRepository.findByCountryIgnoreCase(country);
        
        List<AirportMinDTO> resultDTO = resultAirport.stream()
                .map(x -> new AirportMinDTO(x)).toList();
        
        return resultDTO;
                
    }
    
    public Airport findByIataCode(String iataCode) {
        Airport result = airportRepository.findByIataCode(iataCode);
        return result; 
    }
    
}

