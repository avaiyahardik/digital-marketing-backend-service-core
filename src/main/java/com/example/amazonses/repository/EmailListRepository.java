package com.example.amazonses.repository;

import com.example.amazonses.model.EmailList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailListRepository extends JpaRepository<EmailList, Integer> {

}
