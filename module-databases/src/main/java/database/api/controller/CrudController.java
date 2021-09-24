package database.api.controller;

import static database.constants.URL.CREATE;
import static database.constants.URL.DELETE;
import static database.constants.URL.GET;
import static database.constants.URL.GET_ALL;
import static database.constants.URL.UPDATE;
import static org.springframework.http.ResponseEntity.ok;

import database.api.services.CrudService;
import database.entities.AbstractIdentifiableObject;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CrudController<T extends AbstractIdentifiableObject> {

  @Autowired
  protected CrudService<T> service;

  @PostMapping(CREATE)
  public ResponseEntity<T> create(@RequestBody T object) {
    return ok(service.create(object));
  }

  @GetMapping(GET)
  public ResponseEntity<T> get(@RequestParam Long id) {
    return ok(service.read(id));
  }

  @GetMapping(GET_ALL)
  public ResponseEntity<List<T>> getAll() {
    return ok(service.readAll());
  }

  @PutMapping(UPDATE)
  public ResponseEntity<Boolean> update(@RequestBody T object, @RequestParam Long id) {
    return ok(service.update(object, id));
  }

  @DeleteMapping(DELETE)
  public ResponseEntity<Boolean> delete(@RequestParam Long id) {
    return ok(service.delete(id));
  }
}
