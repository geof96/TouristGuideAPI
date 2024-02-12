package tourism.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tourism.model.TouristAttraction;
import tourism.service.TouristService;

import java.util.List;

@Controller
@RequestMapping("/attractions")
public class TouristController {

    private TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping("/attractions")
    public ResponseEntity<List<TouristAttraction>> getAllAttractions() {
        return new ResponseEntity<>(touristService.getAllTouristAttractions(), HttpStatus.OK);
    }

    @GetMapping("/searchAttraction/{name}")
    public ResponseEntity<TouristAttraction> getAttractionById(@PathVariable String name) {
        return new ResponseEntity<>(touristService.getTouristAttractionById(name), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestBody TouristAttraction touristAttraction) {
        return new ResponseEntity<>(touristService.addTouristAttraction(touristAttraction), HttpStatus.OK);
    }

    @PostMapping("/updateAttraction")
    public ResponseEntity<TouristAttraction> updateAttraction(@RequestBody TouristAttraction touristAttraction) {
        touristService.updateTouristAttraction(touristAttraction);
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }

    @GetMapping("/deleteAttraction/{name}")
    public ResponseEntity<TouristAttraction> deleteAttraction(@PathVariable String name) {
        return new ResponseEntity<>(touristService.deleteTouristAttraction(name), HttpStatus.OK);
    }
}
