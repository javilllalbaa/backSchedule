package com.schedule.spring.r2dbc.mysql.controller;

import com.schedule.spring.r2dbc.mysql.model.Schedule;
import com.schedule.spring.r2dbc.mysql.service.SheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ScheduleController {
  @Autowired
  SheduleService sheduleService;

  @PostMapping("/schedule")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Schedule> createSchedule(@RequestBody Schedule schedele) {
    return sheduleService.saveSchedule(schedele);
  }

  @PutMapping("/schedule/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Schedule> updateSchedule(@PathVariable("id") int id, @RequestBody Schedule schedele) {
    return sheduleService.updateSchedule(id, schedele);
  }

  @DeleteMapping("/schedule/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono<Void> deleteScheduleById(@PathVariable("id") int id) {
    return sheduleService.deleteScheduleById(id);
  }

  @GetMapping("/schedule")
  @ResponseStatus(HttpStatus.OK)
  public Flux<Schedule> getSchedule(
          @RequestParam(name = "pagina", defaultValue = "0", required = true) int pagina,
          @RequestParam(name = "tamanio", defaultValue = "5", required = true) int tamanio
  ) {
    return sheduleService.getSchedule(pagina, tamanio);

  }

}
