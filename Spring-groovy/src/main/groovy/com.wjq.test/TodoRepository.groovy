package com.wjq.test

import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository extends JpaRepository<Todo,Integer>{

}