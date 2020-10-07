package com.example.amazonses.repository;

import com.example.amazonses.model.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient, Integer> {

    public List<Recipient> findByIdIn(List<Integer> ids);
}
