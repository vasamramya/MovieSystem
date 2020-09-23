package com.capgemini.omts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.omts.entity.ScreenBean;

@Repository
public interface ScreenRepo extends JpaRepository<ScreenBean, Integer> {

}
