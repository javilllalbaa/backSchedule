package com.schedule.spring.r2dbc.mysql.repository;

import com.schedule.spring.r2dbc.mysql.model.Schedule;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface ScheduleRepository extends R2dbcRepository<Schedule, Integer> {

    @Query(value="""   
            SELECT * 
            FROM schedule 
            ORDER BY id DESC
            LIMIT :limit 
            OFFSET :offset
            """)
    Flux<Schedule> findByPaginated(int limit, int offset);
}
