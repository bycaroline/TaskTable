package carolineeklund.tables.service;

import carolineeklund.tables.dto.RestaurantTableDto;
import carolineeklund.tables.model.RestaurantTable;
import carolineeklund.tables.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TableService {

    private final TableRepository tableRepository;

    @Autowired
    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public List<RestaurantTableDto> getAllTables() {
        return tableRepository.findAll()
                .stream()
                .map(r -> new RestaurantTableDto(r))
                .collect(Collectors.toList());
    }

    public RestaurantTableDto getTableById(long id){
       RestaurantTable restaurantTable = tableRepository.findById(id)
               .orElseThrow(); 

        return new RestaurantTableDto(restaurantTable);
    }

    public RestaurantTable createTable (RestaurantTable restaurantTable){
        if (restaurantTable.getNumber_of_seats() >0){
            return tableRepository.save(restaurantTable);
        } else{
            throw new RuntimeException();
        }
    }

    public RestaurantTable updateTable(Long id, RestaurantTable restaurantTable){
        RestaurantTable restaurantTableToUpdate = tableRepository.findById(id)
                .orElseThrow();

        if(restaurantTable.getNumber_of_seats() > 0){
            restaurantTableToUpdate.setNumber_of_seats(restaurantTable.getNumber_of_seats());
            restaurantTableToUpdate.setReserved(restaurantTable.isReserved());

            return tableRepository.save(restaurantTableToUpdate);
        } else {
            throw new RuntimeException();
        }
    }

    public void deleteTable(long id){
        RestaurantTable restaurantTableToDelete = tableRepository.findById(id) //
                .orElseThrow();

        tableRepository.delete(restaurantTableToDelete);
    }
}
