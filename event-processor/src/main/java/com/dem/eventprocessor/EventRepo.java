package com.dem.eventprocessor;

import org.springframework.data.jpa.repository.JpaRepository;
public interface EventRepo extends JpaRepository<EventMessage, Long> {}
