package com.embibe.musicPlatform.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.embibe.musicPlatform.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
