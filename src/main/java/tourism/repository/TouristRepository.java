package tourism.repository;

import org.springframework.stereotype.Repository;
import tourism.model.TouristAttraction;

import java.util.ArrayList;
import java.util.List;


@Repository
public class TouristRepository {

    private List<TouristAttraction> touristAttractions = new ArrayList<>(List.of(
            new TouristAttraction("Liberty Statue", "A tall lady"),
            new TouristAttraction("Vegas", "What happens in vegas, stays in Vegas"),
            new TouristAttraction("Los Angeles", "Home of hollywood")));


    public List<TouristAttraction> getAllTouristAttractions() {
        return touristAttractions;
    }

    public TouristAttraction getTouristAttractionById(String name) {
        for (TouristAttraction attraction : touristAttractions) {
            if (attraction.getName().equals(name)) {
                return attraction;
            }
        }
        return null;
    }

    public TouristAttraction addTouristAttraction(TouristAttraction touristAttraction) {
        TouristAttraction newAttraction = new TouristAttraction(touristAttraction.getName(), touristAttraction.getDescription());
        if (newAttraction != null) {
            touristAttractions.add(newAttraction);
        }
        return newAttraction;
    }

    public TouristAttraction updateTouristAttraction(TouristAttraction updatedTouristAttraction) {
        int i = 0;
        TouristAttraction attraction = touristAttractions.get(i);
        for (i = 0; i < touristAttractions.size(); i++) {
            if (attraction.getName().equals(updatedTouristAttraction.getName())) {
                attraction.setName(updatedTouristAttraction.getName());
                attraction.setDescription(updatedTouristAttraction.getDescription());

            }
        }
        return attraction;
    }

    public TouristAttraction deleteTouristAttraction(String name) {
        TouristAttraction deleteAttraction = null;
        for (TouristAttraction touristAttraction : touristAttractions) {
            if (touristAttraction.getName().equalsIgnoreCase(name)) {
                deleteAttraction = touristAttraction;
                break;
            }
        }
        touristAttractions.remove(deleteAttraction);
        return deleteAttraction;
    }
}
