package accelerate.alumni.alumnibackend.services.event;

import accelerate.alumni.alumnibackend.exceptions.EventNotFoundException;
import accelerate.alumni.alumnibackend.models.Event;
import accelerate.alumni.alumnibackend.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EventServiceImpl implements EventService{
    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event findById(Integer id) {
        return eventRepository.findById(id).orElseThrow(()
                -> new EventNotFoundException(id));
    }

    @Override
    public Collection<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event add(Event entity) {
        return eventRepository.save(entity);
    }

    @Override
    public Event update(Event entity) {
        return eventRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        eventRepository.deleteById(id);
    }
}
