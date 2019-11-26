package com.example.database;

import org.springframework.data.repository.CrudRepository;

public interface Repo extends CrudRepository<Something, Long> {
}
