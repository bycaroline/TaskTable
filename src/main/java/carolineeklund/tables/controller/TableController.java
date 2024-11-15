package carolineeklund.tables.controller;

import carolineeklund.tables.dto.RestaurantTableDto;
import carolineeklund.tables.model.RestaurantTable;
import carolineeklund.tables.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TableController {

    private final TableService tableService;

    @Autowired
    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping("/tables")
    public ResponseEntity<List<RestaurantTableDto>> getAllTables() {
        return ResponseEntity.status(HttpStatus.OK).body(tableService.getAllTables());
    }

    @GetMapping("/table/{id}")
    public ResponseEntity<RestaurantTableDto> getTableById(@PathVariable long id) {
        try {
            RestaurantTableDto restaurantTableDto = tableService.getTableById(id);
            return ResponseEntity.status(HttpStatus.OK).body(restaurantTableDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/tables/seats")
    public ResponseEntity<List<RestaurantTableDto>> getTablesBySeats(@RequestBody int seats){
        return ResponseEntity.status(HttpStatus.OK).body(tableService.getTablesBySeats(seats));
    }

    @PostMapping("/table")
    public ResponseEntity<RestaurantTableDto> createTable(@RequestBody RestaurantTable restaurantTable) {
        RestaurantTable newRestaurantTable = tableService.createTable(restaurantTable);
        RestaurantTableDto newRestaurantTableDto = new RestaurantTableDto(newRestaurantTable);
        return ResponseEntity.status(HttpStatus.OK).body(newRestaurantTableDto);
    }

    @PutMapping("/table/{id}")
    public ResponseEntity<RestaurantTableDto> updateTable(@PathVariable long id, @RequestBody RestaurantTable restaurantTable) {
        try{
            RestaurantTable restaurantTableToUpdate = tableService.updateTable(id, restaurantTable);
            RestaurantTableDto restaurantTableDtoToUpdate = new RestaurantTableDto(restaurantTableToUpdate);
            return ResponseEntity.status(HttpStatus.OK).body(restaurantTableDtoToUpdate);
        } catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/table/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable long id){
        try{
            tableService.deleteTable(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
