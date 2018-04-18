package org.activityplanner.DAOs;

import org.activityplanner.Entities.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventDao extends CrudRepository<Event, Integer> {
}
