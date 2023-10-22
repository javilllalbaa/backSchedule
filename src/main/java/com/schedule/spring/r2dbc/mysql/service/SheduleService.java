package com.schedule.spring.r2dbc.mysql.service;

import com.schedule.spring.r2dbc.mysql.model.Schedule;
import com.schedule.spring.r2dbc.mysql.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class SheduleService {

  @Autowired
  ScheduleRepository scheduleRepository;

  public Mono<Schedule> saveSchedule(Schedule schedule) {
    return scheduleRepository.save(schedule);
  }

  public Mono<Schedule> updateSchedule(int id, Schedule schedele) {
    return scheduleRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
            .flatMap(optionalSchedule -> {
              if (optionalSchedule.isPresent()) {
                schedele.setId(id);
                return scheduleRepository.save(schedele);
              }

              return Mono.empty();
            });
  }

  public Mono<Void> deleteScheduleById(int id) {
    return scheduleRepository.deleteById(id);
  }

  public Flux<Schedule> getSchedule(int pagina, int tamanio) {

    int offset = pagina * tamanio;
    int limit = tamanio;

    return scheduleRepository.findByPaginated(limit, offset);
  }

}
